package audio;

import com.xtaudio.xt.*;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class AudioRenderer extends Thread {
  private static double[] phases;
  private static double FREQUENCY;
  private static XtFormat FORMAT;

  private static List<Shape> shapes;
  private static int currentShape;
  private static int framesDrawn;

  private boolean stopped;

  public AudioRenderer(int sampleRate, double frequency) {
    AudioRenderer.FORMAT = new XtFormat(new XtMix(sampleRate, XtSample.FLOAT32), 0, 0, 2, 0);
    AudioRenderer.phases = new double[1];
    AudioRenderer.FREQUENCY = frequency;
    stopped = false;
    shapes = new ArrayList<>();
    currentShape = 0;
    framesDrawn = 0;
  }

  static void render(XtStream stream, Object input, Object output, int frames,
                     double time, long position, boolean timeValid, long error, Object user) {

    for (int f = 0; f < frames; f++) {
      Shape shape = getCurrentShape();

      double framesToDraw = shape.getWeight() * shape.getLength();
      double drawingProgress = framesDrawn / framesToDraw;

      for (int c = 0; c < FORMAT.outputs; c++) {
        ((float[]) output)[f * FORMAT.outputs] = (float) shape.nextX(drawingProgress);
        ((float[]) output)[f * FORMAT.outputs + 1] = (float) shape.nextY(drawingProgress);
      }

      framesDrawn++;

      if (framesDrawn > framesToDraw) {
        framesDrawn = 0;
        currentShape++;
      }
    }
  }

  public static void addShape(Shape shape) {
    shapes.add(shape);
  }

  public static void addShapes(List<Shape> newShapes) {
    shapes.addAll(newShapes);
  }

  private static Shape getCurrentShape() {
    if (currentShape >= shapes.size()) {
      currentShape -= shapes.size();
    }

    return shapes.get(currentShape);
  }

  public void start() {
    try (XtAudio audio = new XtAudio(null, null, null, null)) {
      XtService service = XtAudio.getServiceBySetup(XtSetup.CONSUMER_AUDIO);
      try (XtDevice device = service.openDefaultDevice(true)) {
        if (device != null && device.supportsFormat(FORMAT)) {

          XtBuffer buffer = device.getBuffer(FORMAT);
          try (XtStream stream = device.openStream(FORMAT, true, false,
            buffer.current, AudioRenderer::render, null, null)) {
            stream.start();
            while (true) {

            }
          }
        }
      }
    }
  }
}
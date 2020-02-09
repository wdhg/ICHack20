package audio;

import com.xtaudio.xt.*;
import shapes.Point;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AudioRenderer extends Thread {
  private static double[] phases;
  private static XtFormat FORMAT;

  private static List<Shape> shapes;
  private static Lock lock;
  private static int currentShape;
  private static int framesDrawn;
  private static double FACTOR;
  private static boolean frameUpdated;

  private boolean stopped;

  public AudioRenderer(int sampleRate, double frequency) {
    AudioRenderer.FORMAT = new XtFormat(new XtMix(sampleRate, XtSample.FLOAT32), 0, 0, 2, 0);
    AudioRenderer.phases = new double[1];
    lock = new ReentrantLock();
    stopped = false;
    shapes = new ArrayList<>();
    currentShape = 0;
    framesDrawn = 0;
    FACTOR = 1;
  }

  static void render(XtStream stream, Object input, Object output, int frames,
                     double time, long position, boolean timeValid, long error, Object user) {
    lock.lock();
      for (int f = 0; f < frames; f++) {
        Shape shape = getCurrentShape();

        shape = shape.scale(FACTOR);

        double framesToDraw = shape.getWeight() * shape.getLength();

        double drawingProgress = framesToDraw == 0 ? 1 : framesDrawn / framesToDraw;

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
    lock.unlock();
  }

  public static void scale(double factor) {
    AudioRenderer.FACTOR = factor;
  }

  public static void addShape(Shape shape) {
      shapes.add(shape);
  }

  public static void addShapes(List<Shape> newShapes) {
    shapes.addAll(newShapes);
  }

  public static void updateFrame(List<Shape> frame) {
    lock.lock();
    currentShape = 0;
    shapes = new ArrayList<>();
    shapes.addAll(frame);
    lock.unlock();
  }

  private static Shape getCurrentShape() {
    if (shapes.size() == 0) {
      return new Point(0, 0);
    }

    if (currentShape >= shapes.size()) {
      currentShape -= shapes.size();
    }

    return shapes.get(currentShape);
  }

  @Override
  public void run() {
    try (XtAudio audio = new XtAudio(null, null, null, null)) {
      XtService service = XtAudio.getServiceBySetup(XtSetup.CONSUMER_AUDIO);
      try (XtDevice device = service.openDefaultDevice(true)) {
        if (device != null && device.supportsFormat(FORMAT)) {

          XtBuffer buffer = device.getBuffer(FORMAT);
          try (XtStream stream = device.openStream(FORMAT, true, false,
            buffer.current, AudioRenderer::render, null, null)) {
            stream.start();
            while (!stopped) {
              Thread.onSpinWait();
            }
            stream.stop();
          }
        }
      }
    }
  }
}
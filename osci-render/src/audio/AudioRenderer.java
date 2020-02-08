package audio;

import com.xtaudio.xt.*;

public class AudioRenderer extends Thread {
  private static double phase;
  private static double FREQUENCY;
  private static XtFormat FORMAT;

  private boolean stopped;

  public AudioRenderer(int sampleRate, double frequency) {
    AudioRenderer.FORMAT = new XtFormat(new XtMix(sampleRate, XtSample.FLOAT32), 0, 0, 2, 0);
    AudioRenderer.phase = 0.0;
    AudioRenderer.FREQUENCY = frequency;
    stopped = false;
  }

  static void render(XtStream stream, Object input, Object output, int frames,
                     double time, long position, boolean timeValid, long error, Object user) {

    for (int f = 0; f < frames; f++) {
      phase += FREQUENCY / FORMAT.mix.rate;
      if (phase >= 1.0)
        phase = -1.0;


      for (int c = 0; c < FORMAT.outputs; c++) {
        ((float[]) output)[f * FORMAT.outputs] = (float) Math.sin(Math.PI * phase);
        ((float[]) output)[f * FORMAT.outputs + 1] = (float) Math.cos(Math.PI * phase);
      }
    }
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
import java.util.ArrayList;
import java.util.List;

public class Hypercube {

  private List<Vector4> vertices;
  private List<Integer> edgeData;
  private Vector4 rotation;

  public Hypercube() {
    this.vertices = new ArrayList<>();
    this.edgeData = new ArrayList<>();
    this.rotation = new Vector4();
    for(int w = 0; w <= 1; w++) {
      for(int x = 0; x <= 1; x++) {
        for(int y = 0; y <= 1; y++) {
          for(int z = 0; z <= 1; z++) {
            this.vertices.add(new Vector4(w,x,y,z));
          }
        }
      }
    }
    for(int i = 0; i < 16; i++) {
      this.edgeData.add(i);
    }
  }
}

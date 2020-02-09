public class Ball {
  private Vector2 pos;
  private Vector2 vel;

  public Ball(Vector2 pos, Vector2 vel) {
    this.pos = pos;
    this.vel = vel;
  }

  public Vector2 getPos() {
    return pos;
  }

  public Vector2 getVel() {
    return vel;
  }

  public void setPos(Vector2 pos) {
    this.pos = pos;
  }

  public void setVel(Vector2 vel) {
    this.vel = vel;
  }
}

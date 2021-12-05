package Chess.Match;

import java.awt.Point;

public class Movement {
  public final Point from;
  public final Point to;

  private Movement(Point from, Point to) {
    this.from = from;
    this.to = to;
  }

  public static Movement from(Point from, Point to) {
    return new Movement(from, to);
  }

  public static Movement from(int fromX, int fromY, int toX, int toY) {
    return new Movement(new Point(fromX, fromY), new Point(toX, toY));
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof Movement))
      return false;
    final var movement = (Movement) object;
    return movement.from.equals(from) && movement.to.equals(to);
  }

  @Override
  public String toString() {
    return "(" + from.x + "," + from.y + ")->(" + to.x + "," + to.y + ")";
  }
}

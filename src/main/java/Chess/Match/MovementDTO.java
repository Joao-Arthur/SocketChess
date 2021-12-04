package Chess.Match;

import java.awt.Point;

public class MovementDTO {
  public final Point from;
  public final Point to;

  private MovementDTO(Point from, Point to) {
    this.from = from;
    this.to = to;
  }

  public static MovementDTO from(Point from, Point to) {
    return new MovementDTO(from, to);
  }

  public static MovementDTO from(int fromX, int fromY, int toX, int toY) {
    return new MovementDTO(new Point(fromX, fromY), new Point(toX, toY));
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;
    if (!(object instanceof MovementDTO))
      return false;
    final var movement = (MovementDTO) object;
    return movement.from.equals(from) && movement.to.equals(to);
  }
}

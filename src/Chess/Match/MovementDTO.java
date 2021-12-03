package Chess.Match;

import java.awt.Point;

public class MovementDTO {
  public final Point from;
public final Point to;

  public MovementDTO(Point from, Point to) {
    this.from= from;
    this.to= to;
  }
}

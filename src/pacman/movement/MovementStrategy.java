package pacman.movement;

import pacman.Direction;
import pacman.TileCoordinate;

public interface MovementStrategy {
    Direction getNextDirection(TileCoordinate currentTile);

    void jump(TileCoordinate tileCoordinate);

    Direction getDirection();

    boolean isMoving();
}

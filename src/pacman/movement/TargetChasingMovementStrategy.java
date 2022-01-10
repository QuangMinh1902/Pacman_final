package pacman.movement;

import pacman.Direction;
import pacman.TileCoordinate;
import pacman.maze.Maze;

public class TargetChasingMovementStrategy implements MovementStrategy {

    public TargetChasingMovementStrategy(Maze maze, TargetStrategy targetStrategy) {
    }

    public Direction getNextDirection(TileCoordinate currentTile) {
        return null;
    }

    public void jump(TileCoordinate tileCoordinate) {
    }

    public Direction getDirection() {
        return null;
    }

    public boolean isMoving() {
        return false;
    }
}

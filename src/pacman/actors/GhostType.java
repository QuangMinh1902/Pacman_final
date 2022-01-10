package pacman.actors;
import javax.swing.*;
import java.awt.*;

import pacman.Game;
import pacman.SpacialCoordinate;
import pacman.Tile;
import pacman.movement.MovementStrategy;
import pacman.movement.RandomMovementStrategy;


public enum GhostType {
    BLINKY(Color.red, new SpacialCoordinate(14 * Tile.SIZE, 14 * Tile.SIZE + Tile.SIZE / 2)) {
        @Override
        public MovementStrategy getMovementStrategy(Game game) {
            return new RandomMovementStrategy(getStartCoordinate(), game.getMaze());
        }
    },
    PINKY(Color.pink, new SpacialCoordinate(14 * Tile.SIZE + Tile.SIZE / 2, 17 * Tile.SIZE + Tile.SIZE / 2)) {
        @Override
        public MovementStrategy getMovementStrategy(Game game) {
            return new RandomMovementStrategy(getStartCoordinate(), game.getMaze());
        }
    },
    INKY(Color.blue, new SpacialCoordinate(12 * Tile.SIZE + Tile.SIZE / 2, 17 * Tile.SIZE + Tile.SIZE / 2)) {
        @Override
        public MovementStrategy getMovementStrategy(Game game) {
            return new RandomMovementStrategy(getStartCoordinate(), game.getMaze());
        }
    },
    CLYDE(Color.orange, new SpacialCoordinate(16 * Tile.SIZE + Tile.SIZE / 2, 17 * Tile.SIZE + Tile.SIZE / 2)) {
        @Override
        public MovementStrategy getMovementStrategy(Game game) {
            return new RandomMovementStrategy(getStartCoordinate(), game.getMaze());
        }
    };

    private final SpacialCoordinate startCoordinate;
    private final Color color;
    

    private GhostType(Color color, SpacialCoordinate startCoordinate) {
        this.color = color;
       
        this.startCoordinate = startCoordinate;
    }

    public SpacialCoordinate getStartCoordinate() {
        return startCoordinate;
    }

    public Color getColorOne() {
        return color;
    }


    public static SpacialCoordinate doorExit() {
        return GhostType.BLINKY.getStartCoordinate();
    }

    public abstract MovementStrategy getMovementStrategy(Game game);
}

package pacman.tiles;

import pacman.Tile;
import pacman.TileCoordinate;
import pacman.TileVisitor;

public class OrangeDot extends Tile {
    private boolean eaten;

    public OrangeDot(TileCoordinate coordinate, String value) {
        super(coordinate);
    }

    public OrangeDot(TileCoordinate coordinate) {
        super(coordinate);
    }

    public boolean isEaten() {
        return eaten;
    }

    public void eat() {
        this.eaten = true;
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public <T> T visit(TileVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return ".";
    }
}

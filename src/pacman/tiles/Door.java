package pacman.tiles;

import pacman.Tile;
import pacman.TileCoordinate;
import pacman.TileVisitor;

public class Door extends Tile {

    public Door(TileCoordinate coordinate, String value) {
        super(coordinate);
    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public <T> T visit(TileVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "-";
    }
}

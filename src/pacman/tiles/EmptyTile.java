package pacman.tiles;

import pacman.Tile;
import pacman.TileCoordinate;
import pacman.TileVisitor;

public class EmptyTile extends Tile {

    public EmptyTile(TileCoordinate coordinate, String value) {
        super(coordinate);
    }

    public EmptyTile(TileCoordinate coordinate) {
        super(coordinate);
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
        return " ";
    }
}

package pacman.tiles;

import java.awt.Shape;

import pacman.Tile;
import pacman.TileCoordinate;
import pacman.TileVisitor;

public class Wall extends Tile {

    private final WallType type;

    public Wall(TileCoordinate coordinate, String value) {
        super(coordinate);
        this.type = WallType.fromMazeTile(value);
    }

    public Wall(TileCoordinate coordinate) {
        super(coordinate);
        this.type = WallType.BOTTOM_LEFT;
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
        return "+";
    }

    public Shape getShape() {
        return type.getShape(this.getCenter());
    }
}

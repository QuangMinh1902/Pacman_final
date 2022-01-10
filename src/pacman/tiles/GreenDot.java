package pacman.tiles;

import pacman.Tile;
import pacman.TileCoordinate;
import pacman.TileVisitor;

public class GreenDot extends Tile {
    private boolean eaten;

    public GreenDot(TileCoordinate coordinate, String value) {
        super(coordinate);
    }

    public GreenDot(TileCoordinate coordinate) {
        super(coordinate);
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

	public boolean isEaten() {
		 return eaten;
    }
}



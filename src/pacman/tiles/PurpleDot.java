package pacman.tiles;

import pacman.Tile;
import pacman.TileCoordinate;
import pacman.TileVisitor;

public class PurpleDot extends Tile {
    private boolean eaten;
    
    public PurpleDot(TileCoordinate coordinate, String value) {
        super(coordinate);
    }

    public PurpleDot(TileCoordinate coordinate) {
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


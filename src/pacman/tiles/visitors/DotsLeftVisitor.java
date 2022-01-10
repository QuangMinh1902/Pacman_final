package pacman.tiles.visitors;

import pacman.TileVisitor;
import pacman.tiles.Door;
import pacman.tiles.Dot;
import pacman.tiles.PurpleDot;
import pacman.tiles.EmptyTile;
import pacman.tiles.Wall;
import pacman.tiles.GreenDot;
import pacman.tiles.OrangeDot;

public class DotsLeftVisitor implements TileVisitor<Integer> {
    public Integer visit(Dot dot) {
        return dot.isEaten() ? 0 : 1;
    }

    public Integer visit(Wall wall) {
        return 0;
    }

    public Integer visit(EmptyTile emptyTile) {
        return 0;
    }

    public Integer visit(Door door) {
        return 0;
    }

	public Integer visit(PurpleDot purpledot) {
		return purpledot.isEaten() ? 0 : 1;
	}
	
	public Integer visit(GreenDot greendot) {
		return greendot.isEaten() ? 0 : 1;
	}
	public Integer visit(OrangeDot orangedot) {
		return orangedot.isEaten() ? 0 : 1;
	}
}

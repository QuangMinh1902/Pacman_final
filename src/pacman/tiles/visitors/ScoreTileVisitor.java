package pacman.tiles.visitors;

import pacman.TileVisitor;
import pacman.tiles.Door;
import pacman.tiles.Dot;
import pacman.tiles.EmptyTile;
import pacman.tiles.PurpleDot;
import pacman.tiles.GreenDot;
import pacman.tiles.OrangeDot;
import pacman.tiles.Wall;

public class ScoreTileVisitor implements TileVisitor<Integer> {
    private static final int SCORE_PER_DOT = 100;
    private static final int SCORE_PER_PURPLE_DOT = 300;
    private static final int SCORE_PER_ORANGE_DOT = 500;
    private static final int SCORE_PER_GREEN_DOT = 1000;

    public Integer visit(Dot dot) {
        return dot.isEaten() ? SCORE_PER_DOT : 0;
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
		return purpledot.isEaten() ? SCORE_PER_PURPLE_DOT : 0;
	}
	
	public Integer visit(GreenDot greendot) {
		return greendot.isEaten() ? SCORE_PER_GREEN_DOT : 0;
	}
	public Integer visit(OrangeDot orangedot) {
		return orangedot.isEaten() ? SCORE_PER_ORANGE_DOT : 0;
	}
}

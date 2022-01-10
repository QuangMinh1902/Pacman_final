package pacman.tiles.visitors;

import pacman.TileVisitor;
import pacman.tiles.Door;
import pacman.tiles.Dot;
import pacman.tiles.EmptyTile;
import pacman.tiles.PurpleDot;
import pacman.tiles.GreenDot;
import pacman.tiles.OrangeDot;
import pacman.tiles.Wall;

public class PacmanTileVisitor implements TileVisitor<Void> {
	public int effect;

    public Void visit(Dot dot) {
        dot.eat();
        return null;
    }

    public Void visit(Wall wall) {
        return null;
    }

    public Void visit(EmptyTile emptyTile) {
        return null;
    }

    public Void visit(Door door) {
        return null;
    }

	@Override
	public Void visit(PurpleDot purpledot) {
		 purpledot.eat();
		 effect = 1;
		return null;
	}
	
	@Override
	public Void visit(GreenDot greendot) {
		greendot.eat();
		effect = 3;
		return null;
	}
	
	@Override
	public Void visit(OrangeDot orangedot) {
		orangedot.eat();
		effect = 2;
		return null;
	}
}

package pacman;

import pacman.Tile;
import pacman.TileVisitor;
import pacman.tiles.Door;
import pacman.tiles.Dot;
import pacman.tiles.EmptyTile;
import pacman.tiles.PurpleDot;
import pacman.tiles.GreenDot;
import pacman.tiles.OrangeDot;
import pacman.tiles.Wall;
import pacman.presenters.DoorPresenter;
import pacman.presenters.DotPresenter;
import pacman.presenters.GreenDotPresenter;
import pacman.presenters.PurpleDotPresenter;
import pacman.presenters.OrangePresenter;
import pacman.presenters.NullPresenter;
import pacman.presenters.WallPresenter;

public class TileToPresenterFactory implements TileVisitor<Presenter> {
    public static Presenter toPresenter(Tile tile) {
        final TileToPresenterFactory factory = new TileToPresenterFactory();
        return tile.visit(factory);
    }

    public Presenter visit(Dot dot) {
        return new DotPresenter(dot);
    }

    public Presenter visit(Wall wall) {
        return new WallPresenter(wall);
    }

    public Presenter visit(EmptyTile emptyTile) {
        return new NullPresenter();
    }

    public Presenter visit(Door door) {
        return new DoorPresenter(door);
    }

	@Override
	public Presenter visit(PurpleDot purpledot) {
		 return new PurpleDotPresenter(purpledot);
	}
	
	@Override
	public Presenter visit(GreenDot greendot) {
		 return new GreenDotPresenter(greendot);
	}
	
	@Override
	public Presenter visit(OrangeDot orangedot) {
		 return new OrangePresenter(orangedot);
	}
}

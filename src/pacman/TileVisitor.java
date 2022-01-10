package pacman;

import pacman.tiles.Door;
import pacman.tiles.Dot;
import pacman.tiles.PurpleDot;
import pacman.tiles.GreenDot;
import pacman.tiles.OrangeDot;
import pacman.tiles.EmptyTile;
import pacman.tiles.Wall;

public interface TileVisitor<T> {
    T visit(Dot dot);
    T visit(PurpleDot purpledot);
    T visit(GreenDot greendot);
    T visit(OrangeDot orangedot);
    T visit(Wall wall);
    T visit(EmptyTile emptyTile);
    T visit(Door door);
}

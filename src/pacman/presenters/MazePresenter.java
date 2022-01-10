package pacman.presenters;

import static pacman.TileToPresenterFactory.toPresenter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import pacman.Tile;
import pacman.TileCoordinate;
import pacman.maze.Maze;
import pacman.Presenter;

public class MazePresenter implements Presenter {
    private final Maze maze;
    private final List<Presenter> mazeTiles;

    private static final Font FONT = new Font("Monospaced", Font.BOLD, Tile.SIZE);

    public MazePresenter(Maze maze) {
        this.maze = maze;
        this.mazeTiles = new ArrayList<Presenter>();
        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                mazeTiles.add(toPresenter(maze.tileAt(new TileCoordinate(x, y))));
            }
        }
    }

    public void draw(Graphics2D graphics) {
        for (Presenter tilePresenter : mazeTiles) {
            tilePresenter.draw(graphics);
        }
        drawScore(graphics);
    }

    private void drawScore(Graphics2D graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(FONT);
        graphics.drawString(String.format("Score: %2d", maze.getScore()), Tile.SIZE * 5 +100, Tile.SIZE * 2);
    }
}

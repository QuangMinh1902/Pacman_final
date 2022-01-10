package pacman.presenters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import pacman.tiles.Wall;
import pacman.Presenter;

public class WallPresenter implements Presenter {
    private final Wall wall;

    public WallPresenter(Wall wall) {
        this.wall = wall;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.blue);
        graphics.setStroke(new BasicStroke(2.5f));
        graphics.draw(wall.getShape());
    }
}

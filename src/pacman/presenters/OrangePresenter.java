package pacman.presenters;

import pacman.SpacialCoordinate;
import pacman.tiles.OrangeDot;
import pacman.Presenter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class OrangePresenter implements Presenter {
    private static final int SIDE = 8;
    private final OrangeDot dot;
    private final Rectangle bounds;

    public OrangePresenter(OrangeDot dot) {
        this.dot = dot;
        this.bounds = getBounds();
    }

    public void draw(Graphics2D graphics) {
        if (!dot.isEaten()) {
            graphics.setColor(Color.orange);
            graphics.fill(bounds);
        }
    }

    public Rectangle getBounds() {
        int delta = SIDE / 2;
        Point upperLeft = dot.getCenter().add(new SpacialCoordinate(-delta, -delta)).toPoint();
        return new Rectangle(upperLeft.x, upperLeft.y, SIDE, SIDE);
    }
}

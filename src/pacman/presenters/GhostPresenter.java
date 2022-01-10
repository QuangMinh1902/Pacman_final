package pacman.presenters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import pacman.SpacialCoordinate;
import pacman.actors.Ghost;
import pacman.Presenter;

public class GhostPresenter implements Presenter {
    private static final int DIMENSION = 20;
    private final Ghost ghost;
	private Color color;
    public GhostPresenter(Ghost ghost, Color color) {
        this.ghost = ghost;
        this.color = ghost.getType().getColorOne();
    }

    public void draw(Graphics2D graphics) {
    	graphics.setColor(color); 
        Rectangle bounds = getBounds();
        graphics.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        
    }

    public Rectangle getBounds() {
        int radius = DIMENSION / 2;
        SpacialCoordinate upperLeft = ghost.getCenter().add(new SpacialCoordinate(-radius, -radius));
        return new Rectangle(upperLeft.toPoint(), new Dimension(DIMENSION, DIMENSION));
    }

	public Color getColor() {
		return color;
	}
}

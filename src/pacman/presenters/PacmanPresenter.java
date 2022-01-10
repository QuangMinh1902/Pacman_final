package pacman.presenters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import pacman.SpacialCoordinate;
import pacman.Tile;
import pacman.actors.Pacman;
import pacman.Presenter;

public class PacmanPresenter implements Presenter {
    static final int DIAMETER = 20;
    static final int DELAY_AFTER_DEAD = 60;
    private static final Font FONT = new Font("Monospaced", Font.BOLD, Tile.SIZE);


    private final Pacman pacman;
    private int deadFrame;
    private Color color = Color.yellow;

    public PacmanPresenter(Pacman pacman) {
        this.pacman = pacman;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(color);
        Rectangle bounds = getBounds();
        graphics.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
        drawPacLeft(graphics);
    }


    Rectangle getBounds() {
        int radius = DIAMETER / 2;
        SpacialCoordinate upperLeft = pacman.getCenter().add(new SpacialCoordinate(-radius, -radius));
        return new Rectangle(upperLeft.toPoint(), new Dimension(DIAMETER, DIAMETER));
    }

    boolean isDying() {
        return pacman.isDead() && deadFrame++ <=  DELAY_AFTER_DEAD;
    }
    private void drawPacLeft(Graphics2D graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(FONT);
        graphics.drawString(String.format("Lives: %2d", pacman.getPacLeft()), Tile.SIZE * 5 - 80 , Tile.SIZE * 2);
    }
}

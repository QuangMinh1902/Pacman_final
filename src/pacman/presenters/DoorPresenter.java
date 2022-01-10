package pacman.presenters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import pacman.tiles.Door;
import pacman.tiles.WallType;
import pacman.Presenter;

public class DoorPresenter implements Presenter {

    private final Door door;

    public DoorPresenter(Door door) {
        this.door = door;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.pink);
        graphics.setStroke(new BasicStroke(2.5f));
        graphics.draw(WallType.HORIZONTAL.getShape(door.getCenter()));
    }
}

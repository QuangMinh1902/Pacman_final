package pacman.presenters;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import pacman.Game;
import pacman.actors.Ghost;
import pacman.Presenter;

public class GamePresenter implements Presenter {
    private final MazePresenter mazePresenter;
    private final PacmanPresenter pacmanPresenter;
    private final List<GhostPresenter> ghostPresenters;

    public GamePresenter(Game game) {
        mazePresenter = new MazePresenter(game.getMaze());
        pacmanPresenter = new PacmanPresenter(game.getPacman());
        ghostPresenters = new LinkedList<GhostPresenter>();
        for (Ghost ghost : game.getGhosts()) {
            ghostPresenters.add(new GhostPresenter(ghost, null));
        }
    }

    public void draw(Graphics2D graphics) {
        mazePresenter.draw(graphics);
        pacmanPresenter.draw(graphics);
        if (!isDying()) {
            for (GhostPresenter ghostPresenter : ghostPresenters) {
                ghostPresenter.draw(graphics);
            }
        }
    }

    public boolean isDying() {
        return pacmanPresenter.isDying();
    }
}
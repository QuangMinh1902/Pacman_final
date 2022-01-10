package pacman;

import pacman.actors.Ghost;
import pacman.actors.GhostType;
import pacman.actors.Pacman;
import pacman.maze.Maze;

public class Ghosts {
    private Ghost blinky;
    private Ghost pinky;
    private Ghost inky;
    private Ghost clyde;

    public Ghosts(Game game) {
        this(new Ghost(game, GhostType.BLINKY), new Ghost(game, GhostType.PINKY), new Ghost(game, GhostType.INKY),
                new Ghost(game, GhostType.CLYDE));
    }

    Ghosts(Ghost blinky, Ghost pinky, Ghost inky, Ghost clyde) {
        this.blinky = blinky;
        this.pinky = pinky;
        this.inky = inky;
        this.clyde = clyde;
    }

    public Ghost getBlinky() {
        return blinky;
    }

    public Ghost getPinky() {
        return pinky;
    }

    public Ghost getInky() {
        return inky;
    }

    public Ghost getClyde() {
        return clyde;
    }

    public void freeGhosts() {
        if (blinky.isHalted()) {
            blinky.free();
        } else if (pinky.isHalted()) {
            pinky.free();
        } else if (inky.isHalted()) {
            inky.free();
        } else if (clyde.isHalted()) {
            clyde.free();
        }        
    }

    public void advance(long timeDeltaInMillis) {
        blinky.advance(timeDeltaInMillis);
        pinky.advance(timeDeltaInMillis);
        inky.advance(timeDeltaInMillis);
        clyde.advance(timeDeltaInMillis);
    }

    public boolean killed(Pacman pacman) {
        return pacman.collidesWith(blinky) || pacman.collidesWith(pinky) || pacman.collidesWith(inky)
                || pacman.collidesWith(clyde);
    }
}
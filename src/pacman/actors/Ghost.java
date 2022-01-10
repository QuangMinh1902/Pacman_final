package pacman.actors;

import pacman.Actor;
import pacman.Game;

public class Ghost extends Actor {
    private final GhostType type;
    private boolean free;

    public Ghost(Game game, GhostType type) {
        super(game.getMaze(), type.getMovementStrategy(game) , type.getStartCoordinate());
        this.type = type;
    }

    public GhostType getType() {
        return type;
    }

    public void free() {
        jump(GhostType.doorExit());
        free = true;
    }

    @Override
	public boolean isHalted() {
    	return !free;
    }
}

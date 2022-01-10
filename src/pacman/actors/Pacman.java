package pacman.actors;

import pacman.Actor;
import pacman.Direction;
import pacman.SpacialCoordinate;
import pacman.Tile;
import pacman.maze.Maze;
import pacman.movement.UserControlledMovementStrategy;

public class Pacman extends Actor {
	public int pacLeft = 3;
    private boolean dead = false;

    public Pacman(Maze maze) {
        this(maze, new SpacialCoordinate(14 * Tile.SIZE, 26 * Tile.SIZE + Tile.SIZE / 2), Direction.LEFT);
        
    }

    protected Pacman(Maze maze, SpacialCoordinate center, Direction direction) {
        super(maze, new UserControlledMovementStrategy(maze, direction), center);
        
    }
    
    

    public void die() {
//    	this.pacLeft = this.pacLeft -1;
    	
    	if(this.pacLeft == 0) {
    		this.dead = true;
    	}
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    protected boolean isHalted() {
        return isDead();
    }

    public void setNextDirection(Direction direction) {
    	if(maze.getScore() % 5000 == 0 && maze.getScore() >0) {
        	this.pacLeft++;
        }
        ((UserControlledMovementStrategy) movementStrategy).setNextDirection(direction);
    }

    public Direction getDirection() {
        return movementStrategy.getDirection();
    }

    public boolean isMoving() {
        return movementStrategy.isMoving();
    }
    
    public int getPacLeft() {
        return pacLeft;
    }

}

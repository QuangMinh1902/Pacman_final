package pacman.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import pacman.Game;

import pacman.Screen;

public class WinScreen implements Screen {
   
	String s = "Press s to start.";
    Font small = new Font("Helvetica", Font.BOLD, 50);
    private final Dimension dimension;
    private final Game game;
    private boolean startGame;

    public WinScreen(Game game) {
        this.dimension = game.getDimension();
        this.game = game;
        this.startGame = false;
    }

    public void draw(Graphics2D graphics) {
    	graphics.setColor(new Color(0,32,48));
    	graphics.fillRect(50, dimension.width/2 -30, dimension.width - 100, 50);
    	graphics.setColor(Color.white);
    	graphics.drawRect(50, dimension.width/2 -30, dimension.width - 100, 50);
    	
    	String s = "YOU WIN!";
    	Font small = new Font("Helvetica", Font.BOLD, 14);
    	

    	graphics.setColor(Color.white);
    	graphics.setFont(small);
    	graphics.drawString(s, dimension.width / 2 - 50, dimension.width / 2);
    }

    public Screen getNextScreen() {
        if (startGame) {
            return new IntroScreen(game);
        }
        return this;
    }

    public void keyPressed(KeyEvent e) {
        startGame = true;
    }
}

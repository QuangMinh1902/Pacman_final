package pacman.screens;

import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;

import pacman.Game;
import pacman.Screen;

public class IntroScreen implements Screen {
    String s = "Press s to start.";
    Font small = new Font("Helvetica", Font.BOLD, 50);
    private final Dimension dimension;
    private boolean startGame;

    public IntroScreen(Game game) {
        this.dimension = game.getDimension();
        this.startGame = false;
    }
    
    


    public void draw(Graphics2D graphics) {
    	graphics.setColor(new Color(0,32,48));
    	graphics.fillRect(50, dimension.width/2 -30, dimension.width - 100, 50);
    	graphics.setColor(Color.white);
    	graphics.drawRect(50, dimension.width/2 -30, dimension.width - 100, 50);
    	
    	String s = "WELCOME TO PACMAN GAME";
    	Font small = new Font("Helvetica", Font.BOLD, 14);
    	

    	graphics.setColor(Color.white);
    	graphics.setFont(small);
    	graphics.drawString(s, dimension.width / 2 - 100, dimension.width / 2);
    }


	public Screen getNextScreen() throws Exception {
        if (startGame) {
            return new GameScreen();
        }
        return this;
    }

    public void keyPressed(KeyEvent e) {
        startGame = true;
    }
}

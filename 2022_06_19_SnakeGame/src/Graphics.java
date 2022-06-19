import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.Timer;
import javax.swing.JPanel;

/*
 * This class manages the visuals and how often the game is updated
 */
public class Graphics extends JPanel implements ActionListener{
	// run update every 100 ms
	private Timer time = new Timer(100, this);
	// either "START", "RUNNING" or "END"
	public String state;
	
	private Snake snake;
	private Food food;
	private Game game;
	
	public Graphics(Game game) {
		time.start();
		state = "START";
		
		this.game = game;
		snake = game.getSnake();
		food = game.getFood();
		
		this.addKeyListener(game);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	/*
	 * Paints the canvas with all the objects
	 */
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, Game.w * Game.d + 5, Game.h * Game.d + 5);
		
		// Introduction screen
		if(state == "START") {
			g2d.setColor(Color.white);
			g2d.drawString("Press Any Key", Game.w/2 * Game.d - 40, Game.h/2 * Game.d - 20);
		}
	
		 // Screen that is displayed while the game is being played
		else if(state == "RUNNING") {
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, Game.w * Game.d, Game.h * Game.d);
			
			g2d.setColor(Color.red);
			g2d.fillRect(food.getX() * Game.d, food.getY() * Game.d, Game.d, Game.d);
			
			g2d.setColor(Color.green);
			for(Rectangle r : snake.getBody()) {
				g2d.fill(r);
			}
		}
		// ending screen
		else {
			g2d.setColor(Color.white);
			g2d.drawString("Your Score: " + (snake.getBody().size() - 3), Game.w/2 * Game.d - 40, Game.h/2 * Game.d);
		}
		
	}
	/*
	 * Runs whenever the user presses a key
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();	
		
		game.update();
	}

}

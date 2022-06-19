import javax.swing.JFrame;

import java.awt.event.*;
/*
 * This class manages the game when it's updated by the graphics class
 */
public class Game implements KeyListener{
	private Snake snake;
	private Food food;
	private Graphics graphics;
	
	private JFrame window;
	
	// dimensions
	public static final int w = 30;
	public static final int h = 30;
	public static final int d = 20;
	
	public Game() {
		// setup the window
		window = new JFrame();
		
		snake = new Snake();
		food = new Food(snake);
		graphics = new Graphics(this);
		
		window.add(graphics);
		
		window.setTitle("Snake Game - Ben Platt");
		window.setSize(w * d + 2, h * d + d + 4);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/*
	 * runs when the game is started
	 */
	public void start() {
		graphics.state = "RUNNING";
	}
	/*
	 * updates the game every 100 ms (see graphics for timer)
	 */
	public void update() {
		if(graphics.state == "RUNNING") {
			if(check_food_collision()) {
				snake.grow();
				food.random_spawn(snake);
			}
			else if(check_wall_collision() || check_self_collision()) {
				graphics.state = "END";
			}
			else {
				snake.move();
			}
		}
	}
	/*
	 * 
	 * Collision detection
	 * 
	 */
	private boolean check_wall_collision() {
		if(snake.getX() < 0 || snake.getX() >= w * d || snake.getY() < 0 || snake.getY() >= w * d) {
			return true;
		}
		return false;
	}
	
	private boolean check_food_collision() {
		if(snake.getX() == food.getX() * d && snake.getY() == food.getY() * d) {
			return true;
		}
		return false;
	}
	
	private boolean check_self_collision() {
		for(int i = 1; i < snake.getBody().size(); i++) {
			if(snake.getX() == snake.getBody().get(i).x && snake.getY() == snake.getBody().get(i).y) {
				return true;
			}
		}
		return false;
	}
	/*
	 * 
	 * Key events: define player controls for the snake
	 * 
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(graphics.state == "RUNNING") {
			if(keyCode == KeyEvent.VK_W) {
				snake.up();
			}
			else if(keyCode == KeyEvent.VK_A) {
				snake.left();
			}
			else if(keyCode == KeyEvent.VK_D) {
				snake.right();
			}
			else if(keyCode == KeyEvent.VK_S) {
				snake.down();
			}
		}
		else {
			this.start();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	 * 
	 * Getters and setters
	 * 
	 */
	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}
}

import java.awt.Rectangle;
/*
 * This class creates the food object which is the objective for the player
 */
public class Food {
	private int x;
	private int y;
	
	public Food(Snake snake) {
		this.random_spawn(snake);
	}
	
	public void random_spawn(Snake snake) {
		
		// food is not touching the snake
		boolean onSnake = true;
		while(onSnake) {
			onSnake = false;
			
			x = (int) (Math.random() * Game.w - 1);
			y = (int) (Math.random() * Game.h - 1);
			// enhanced for loop to check if the snake is touching the food
			for(Rectangle r : snake.getBody()) {
				if(r.x == x && r.y == y) {
					onSnake = true;
				}
			}
		}
	}
	
	/*
	 * 
	 * getters and setters
	 * 
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

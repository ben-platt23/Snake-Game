import java.util.ArrayList;

import java.awt.Rectangle;
/*
 * This class creates the snake object and controls it's attributes
 */
public class Snake {
	// list of how many segments the snake has
	private ArrayList<Rectangle> body;
	// dimensions again
	private int w = Game.w;
	private int h = Game.h;
	private int d = Game.d;
	// "NONE" or "UP" or "DOWN" or "LEFT" or "RIGHT"
	private String move; 
	/*
	 * Construct the snake initially (no initial movement)
	 */
	public Snake() {
		// create 3 wide body for the start of the game
		body = new ArrayList<Rectangle>();
		
		Rectangle seg1 = new Rectangle(d, d);
		seg1.setLocation(w*d/2, h*d/2);
		body.add(seg1);
		
		Rectangle seg2 = new Rectangle(d, d);
		seg2.setLocation(w*d/2-1, h*d/2);
		body.add(seg2);
		
		Rectangle seg3 = new Rectangle(d, d);
		seg3.setLocation(w*d/2-2, h*d/2);
		body.add(seg3);
		
		move = "NONE";
	}
	/*
	 * Tells the program where to move the snake depending on the directional input.
	 * Basically just adds segments to the end of the snake and removes it as it moves
	 */
	public void move() {
		if(move != "NONE") {
			Rectangle first = body.get(0);
			
			Rectangle temp = new Rectangle(d, d);
			
			if(move == "UP") {
				temp.setLocation(first.x, first.y - d);
			}
			else if(move == "DOWN") {
				temp.setLocation(first.x, first.y + d);
			}
			
			else if(move == "LEFT") {
				temp.setLocation(first.x - d, first.y);
			}
			
			else if(move == "RIGHT") {
				temp.setLocation(first.x + d, first.y);
			}
			
			body.add(0, temp);
			body.remove(body.size()-1);
		}
	}
	/*
	 * Same concept as the move function but doesn't remove the segment at the end
	 */
	public void grow() {
		if(move != "NONE") {
			Rectangle first = body.get(0);
			
			Rectangle temp = new Rectangle(d, d);
			
			if(move == "UP") {
				temp.setLocation(first.x, first.y - d);
			}
			else if(move == "DOWN") {
				temp.setLocation(first.x, first.y + d);
			}
			
			else if(move == "LEFT") {
				temp.setLocation(first.x - d, first.y);
			}
			
			else if(move == "RIGHT") {
				temp.setLocation(first.x + d, first.y);
			}
			
			body.add(0, temp);
		}
	}
	/*
	 * Movement controls
	 */
	public void up() {
		if(move != "DOWN") {
			move = "UP";
		}
	}
	
	public void down() {
		if(move != "UP") {
			move = "DOWN";
		}
	}
	
	public void left() {
		if(move != "RIGHT") {
			move = "LEFT";
		}
	}
	
	public void right() {
		if(move != "LEFT") {
			move = "RIGHT";
		}
	}
	/*
	 * Getters and setters
	 */
	public ArrayList<Rectangle> getBody() {
		return body;
	}

	public void setBody(ArrayList<Rectangle> body) {
		this.body = body;
	}
	
	public int getX() {
		return body.get(0).x;
	}
	
	public int getY() {
		return body.get(0).y;
	}
}

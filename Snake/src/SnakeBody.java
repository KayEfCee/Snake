import java.awt.Color;
import java.awt.Graphics;

public class SnakeBody {
	
	private int xCoords, yCoords, width, height;
    
	public SnakeBody(int xCoords, int yCoords, int tile) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		width = tile;
		height = tile;
		
		
	}
	
	public void seconds() {
		
	}
	
	public int getxCoords() {
		return xCoords;
	}

	public void setxCoords(int xCoords) {
		this.xCoords = xCoords;
	}

	public int getyCoords() {
		return yCoords;
	}

	public void setyCoords(int yCoords) {
		this.yCoords = yCoords;
	}

	public void draw(Graphics a) {
		a.setColor(Color.green);
		a.fillRect(xCoords * width, yCoords * height, width, height);
		
	}
public static void main(String[] args) {
		
	}
}

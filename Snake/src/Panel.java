import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
     
	public static final int WIDTH = 500, HEIGHT = 500;
	
	private Thread thread;
	private boolean right = true, left = false, up = false, down = false;
	private boolean on;
	private SnakeBody a;
	private ArrayList<SnakeBody> snake;
	private int xCoords = 10, yCoords = 10, size = 5;
	private int seconds = 0;
	private Apple apple;
	private ArrayList<Apple> apples;
	
	private Random r;
	
	public Panel() {
		
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		
		snake = new ArrayList<SnakeBody>();
		apples = new ArrayList<Apple>();
		r = new Random();
		
		
		start();
		
	}
	
	public void start() {
		thread = new Thread(this);
		on = true;
		thread.start();
		
	}
	
	public void stop() {
		on = false;
		
		try {
			thread.join();
		} catch (InterruptedException c) {
			
			c.printStackTrace();
		}
		
		
	}
	public void seconds() {
		
		if(snake.size() == 0) {
			a = new SnakeBody(xCoords, yCoords, 10);
			snake.add(a);
		}
		seconds++;
		if (seconds > 250000) {
			if (right) xCoords++;
			if (left)  xCoords--;
			if (up) yCoords--;
			if (down) yCoords++;
			
			seconds = 0;
			
			a = new SnakeBody(xCoords, yCoords, 10);
			snake.add(a);
			
			if (snake.size() > size) {
				snake.remove(0);
			}
				
			
		}
		
		if (apples.size() == 0) {
			int xCoords = r.nextInt(49);		
		    int yCoords = r.nextInt(49);
		    
		    apple = new Apple(xCoords, yCoords, 10);
		    apples.add(apple);
		}
		
		for (int b = 0 ; b < apples.size() ; b++) {
			if (xCoords == apples.get(b).getxCoords() && yCoords == apples.get(b).getyCoords()) {
				size++;
				apples.remove(b);
				b++;
			}
		}
		
		for (int b = 0 ; b < snake.size() ; b++) {
			if (xCoords == snake.get(b).getxCoords() && yCoords == snake.get(b).getyCoords()) {
				if (b != snake.size()- 1) {
					System.out.println("Game Over!");	
					stop();
				}
			}
		}
		
		if (xCoords < 0 || xCoords > 49 || yCoords < 0 || yCoords > 49) {
			
	
			
			System.out.println("Game Over!");		
			stop();
		}
	}
	
	public void paint(Graphics a) {
		
		  a.clearRect(0, 0, WIDTH, HEIGHT);	  
		  a.setColor(Color.black);
		  a.fillRect(0, 0, WIDTH, HEIGHT);
		  
		  for(int b = 0; b < WIDTH/10 ; b++) {
		   a.drawLine(b * 10, 0, b * 10, HEIGHT);
		  }
		  for(int b = 0; b < HEIGHT/10 ; b++) {
		   a.drawLine(0, b * 10 , HEIGHT, b * 10);
		  }
		  for(int b = 0 ; b < snake.size() ; b++) {
			  snake.get(b).draw(a);  
		  }
		  for (int b = 0 ; b < apples.size(); b++) {
			  apples.get(b).draw(a);
		  }
		  
	}

	@Override
	public void run() {
		while(on) {
			seconds();
			repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
             int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT && !left) {
			right = true;
			up = false;
			down = false;
		
		}
		if (key == KeyEvent.VK_LEFT && !right) {
			left = true;
			up = false;
			down = false;
		
		}
		if (key == KeyEvent.VK_UP && !down) {
			up = true;
			left = false;
			right = false;
		
		}
		if (key == KeyEvent.VK_DOWN && !up) {
			down = true;
			left = false;
			right = false;
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		
	}
}


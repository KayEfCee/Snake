
import javax.swing.JFrame;

public class Main {

	public Main() {
		
		Panel panel = new Panel();
		
		JFrame display = new JFrame();
		
		display.add(panel);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setTitle("Snake Game");
		display.setLocationRelativeTo(null);
		display.pack();
		display.setVisible(true);
		
		
		
	}
	 public static void main(String[] args) {
		 new Main();
	 }
	
}


import java.awt.Color;

import javax.swing.JFrame;


public class SpaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Space Invader");
		
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
//		frame.setAlwaysOnTop(true);
		frame.setLocation(175, 75);
		
//		frame.getContentPane().setBackground(Color.GRAY);
		frame.add(new SpaceFrame());
		frame.setVisible(true);
	}

}

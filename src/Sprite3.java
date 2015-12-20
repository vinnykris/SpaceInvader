import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Sprite3 extends Entity{
	int startX;

	int startY;
	
	public Sprite3(int x, int y) {
		super(x, y);
		startX = x;
		startY = y;
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics2D g2d){
		
		
		g2d.drawImage(getPlayerImg(), x, y, null);

	}
	private Image getPlayerImg() {
		// TODO Auto-generated method stub
		
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/sprite3.png"));
		
		return ic.getImage();
		
		
	
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 50);
	}
}

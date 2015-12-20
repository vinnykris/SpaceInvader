import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Shield extends Entity{

	public Shield(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
public void draw(Graphics2D g2d){
		
		
		g2d.drawImage(getPlayerImg(), x, y, null);

	}
	private Image getPlayerImg() {
		// TODO Auto-generated method stub
		
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/shield.png"));
		
		return ic.getImage();
		
		
	
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 100, 100);
	}
	public void removeSpot(Entity e){
		
	}
}

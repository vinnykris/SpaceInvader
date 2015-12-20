import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.ImageIcon;



public class Bullet extends Entity {

	public Bullet(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void move(){
		y-=1;
	}
	public void moveDown() {
		// TODO Auto-generated method stub
		y+=1;
	}
	public void draw(Graphics2D g2d){
		
		
		g2d.drawImage(getPlayerImg(), x, y, null);

	}
	private Image getPlayerImg() {
		// TODO Auto-generated method stub
		
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/bullet.png"));
		
		return ic.getImage();
		
		
	
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
	}
	
	
}

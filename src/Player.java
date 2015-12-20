
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class Player extends Entity{
	int startX;
	int velX = 0;
	int speed = 3;
	
	public Player(int x, int y) {
		super(x, y);
		startX = x;
		update();
		
		// TODO Auto-generated constructor stub
	}
	public void update(){

			x += velX;
		
	}
	
	public void draw(Graphics2D g2d){
		
		
		g2d.drawImage(getPlayerImg(), x, y, null);

	}
	private Image getPlayerImg() {
		// TODO Auto-generated method stub
		
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/player.png"));
		
		return ic.getImage();
		
		
	
	}
	public void remove(Graphics2D g2d){
		g2d.fillRect(x, y, 20, 20);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			if (checkOff() == false){
				velX = -speed;	
			}
										
		} else if (key == KeyEvent.VK_RIGHT){
			if (checkOff() == false){
				velX = speed;	
			}				
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){			
			velX = 0;
			
		} else if (key == KeyEvent.VK_RIGHT){
			velX = 0;
		}
	}
	
	public boolean checkOff(){
		if (this.x > 1000 || this.x < -75){
			return true;
		}
		return false;
	}
	
	public void stop(KeyEvent e){
		if (this.x > 1000){
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT){
					velX = -speed;	
				
											
			} else if (key == KeyEvent.VK_RIGHT){
				if (checkOff() == false){
					velX = 0;	
				}				
			}
		}
	}
}

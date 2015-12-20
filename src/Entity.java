import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;


public class Entity {

	int x, y;
	int velX = 1;
	int speed = 3;
	boolean status;
	public Entity(int x , int y){
		this.x = x;
		this.y = y;
		
	}
	
	public void update(){
		
		checkOffScreen();
		x+=velX;

	}
	
	public void draw(Graphics2D g2d) {
		
	}
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		if(status==true){
			velX = -1;
		}
		else
			velX = 1;
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void addX(int newX){
		x += newX;
	}
	public void addY(int newY){
		y += newY;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
	}
	public boolean collision(Entity e) {
		return this.getBounds().intersects(e.getBounds());
	}
	
}

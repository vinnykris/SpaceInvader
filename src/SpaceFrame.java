import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class SpaceFrame extends JPanel implements ActionListener{
	Timer mainTimer;
	int control =0;
	int spriteCount = 11;
	Player player;
	int playerH = 40;
	int playerW = 60;
	ArrayList<Entity> sprites = new ArrayList<Entity>();
	ArrayList<Shield> shields = new ArrayList<Shield>();
	ArrayList<Bullet> playerBullets = new ArrayList<Bullet>(),
			alienBullets= new ArrayList<Bullet>();
	Random rand = new Random();
	
	public SpaceFrame(){
		this.setBackground(Color.black);
		setFocusable(true);
		player = new Player(500 - playerW/2 , 600 - playerH*2);
		addKeyListener(new KeyAdapt(player));
		mainTimer = new Timer(10, this);
		setUpKeyBindings();
		startGame();
		
		
	}
	
	public void paint (Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		player.draw(g2d);
		for(int i = 0; i < sprites.size(); i++){
			Entity temp = sprites.get(i);
			temp.draw(g2d);
		}
		for(int s = 0;s<playerBullets.size();s++){
			playerBullets.get(s).draw(g2d);
			playerBullets.get(s).move();
		}
		for(int s = 0;s<shields.size();s++){
			shields.get(s).draw(g2d);
		}
		for(int s = 0;s<alienBullets.size();s++){
			alienBullets.get(s).draw(g2d);
			alienBullets.get(s).moveDown();
		}
		
	}

	private void startGame() {
		// TODO Auto-generated method stub
		mainTimer.start();
		int x = 54;
		for (int i = 0; i < spriteCount; i++){
			addSprites(new Sprite1(x, 150));
			x+=55;
		}
		x = 54;
		for (int i = 0; i < spriteCount; i++){
			addSprites(new Sprite2(x, 200));
			x+=55;
		}
		x=54;
		for (int i = 0; i < spriteCount; i++){
			addSprites(new Sprite3(x, 250));
			x+=55;
		}
		addShields();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		control++;
		moveEverything();
		alienFire();
		checkCollision();
		repaint();
		
	}
	private void checkCollision() {
		// TODO Auto-generated method stub
		checkAlienCollision();
		
	}
	public void checkAlienCollision(){
		for(int e = playerBullets.size()-1; e>=0; e--){
			for(int s = sprites.size()-1 ; s>=0;s--){
				if(playerBullets.get(e).collision(sprites.get(s))){
					sprites.remove(sprites.get(s));
//					alienBullets.add(playerBullets.get(e));
					playerBullets.remove(e);
					break;
				}
			}
		}
	}
	public void checkPlayerCollision(){
		for(int e = alienBullets.size()-1; e>=0; e--){
			if(playerBullets.get(e).collision(player)){
//					alienBullets.add(playerBullets.get(e));
					alienBullets.remove(e);
					break;
				}
			}
		
	}
	public void alienFire(){
		if(control%300==0){
			addAlienBullet();
		}
	}

	public void moveEverything(){
		player.update();
		for(Entity e: sprites){
			e.update();
			checkOffScreen(e);
			
		}

	}
	private void checkOffScreen(Entity e) {
		// TODO Auto-generated method stub
		if(e.getX()>=950){
			for(Entity a: sprites){
				a.addY(20);
				a.status=true;
			}
		}
		else if(e.getX()<=0)
			for(Entity a: sprites){
				a.addY(20);
				a.status=false;
			}
		
	}
	public void addShields(){
		shields.add(new Shield(150,440));
		shields.add(new Shield(350,440));
		shields.add(new Shield(575,440));
		shields.add(new Shield(775,440));

	}

	public void addSprites(Entity s){
		sprites.add(s);
	
	}
	public void addBullet(){
		playerBullets.add(new Bullet(player.x+27,player.y-15));
	}
	public void addAlienBullet(){
		int r = rand.nextInt(sprites.size());
		Entity b = sprites.get(r);
		alienBullets.add(new Bullet(b.x+30,b.y+30));

	}
	

	
	private void setUpKeyBindings() {
		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"fire");
		this.getActionMap().put("fire",
			new AbstractAction() {

		@Override

		public void actionPerformed(ActionEvent e) {
			launchWeapon();

		}

		});
		}

		protected void launchWeapon() {
			if(control%3==0)
				addBullet();
		}
		
		
		


}

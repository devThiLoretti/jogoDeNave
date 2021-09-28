package Application;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle{
	
	public int spd = 4;
	public boolean right, up, down, left;
	
	public static int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	public static List<Bullet> bullets = new ArrayList<>();
	public boolean shoot = false;
	public int dir = 1;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		boolean moved = false;
		if(right) {
			x += spd;
			moved = true;
			dir = 1;
		}
		else if(left ) {
			x -= spd;
			moved = true;
			dir = -1;
		}
		
		if(up ) {
			y -= spd;
			moved = true;
			dir = 1;
			
		}
		else if(down ) {
			y += spd;
			moved = true;
			
			
		}
		
		if(moved) {
		curFrames++;
		if(curFrames == targetFrames) {
			curFrames = 0;
			curAnimation++;
			if(curAnimation == Spritesheet.player_front.length) {
				curAnimation = 0;
			}
		}
		}
		
		if(shoot) {
			shoot = false;
			bullets.add(new Bullet(x, y, 1));
		}
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}
	
	
	
	public void render(Graphics g) {
		//g.setColor(Color.BLUE);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.player_front[curAnimation], x, y, 60, 60, null);
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);;
		}
	}
	
	

}

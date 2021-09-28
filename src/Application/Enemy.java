package Application;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Rectangle{
	
	public int spd = 2;
	
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	public static List<Bullet> bullets = new ArrayList<>();
	public boolean shoot = false;
	public int dir = 1;
	
	public Enemy(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void seekPlayer() {
		Player p = Game.player;
		if(x+400 < p.x) {
			if(new Random().nextInt(100)<50)
			x += spd;
		}else if(x+100 > p.x) {
			
			x -= spd;
		}
		
		if(y+100 < p.y ) {
			if(new Random().nextInt(100)<90)
			y += spd;
		}else if(y+100 > p.y ) {
			
			y -= spd;
		}
	}
	
	public void tick() {
		boolean moved = true;
		seekPlayer();
		
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
			bullets.add(new Bullet(x, y, dir));
		}
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}
	
	
	
	public void render(Graphics g) {
		//g.setColor(Color.BLUE);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.enemy_front[curAnimation], x, y, 627/4, 427/4, null);
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);;
		}
	}
	
	

}

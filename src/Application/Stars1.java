package Application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Stars1 extends Rectangle{
	
	public int dir = 1;
	public int speed = 8;
	public int frames = 0;
	
	public Stars1(int x, int y, int dir) {
		super(x+16, y+16, 6, 6);
		this.dir = dir;
	}
	
	public void tick() {
		x += speed*dir;
		frames++;
		if(frames == 360) {
			Game.stars1.remove(this);
			
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
	}

}

package Application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Stars2 extends Rectangle{
	
	public int dir = 1;
	public int speed = 2;
	public int frames = 0;
	
	public Stars2(int x, int y, int dir) {
		super(x, y, 5, 5);
		this.dir = dir;
	}
	
	public void tick() {
		x += speed*dir;
		frames++;
		if(frames == 1360) {
			Game.stars2.remove(this);
			
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(135, 206, 250));
		g.fillOval(x, y, width, height);
	}

}

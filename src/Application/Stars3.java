package Application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Stars3 extends Rectangle{
	
	public int dir = 1;
	public int speed = 1;
	public int frames = 0;
	
	public Stars3(int x, int y, int dir) {
		super(x, y, 2, 2);
		this.dir = dir;
	}
	
	public void tick() {
		x += speed*dir;
		frames++;
		if(frames == 1360) {
			Game.stars3.remove(this);
			
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(106, 90, 205));
		g.fillOval(x, y, width, height);
	}

}

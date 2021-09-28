package Application;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planets2 extends Rectangle {

	public int spd = 1;
	public int frames = 0;
	public int dir = 1;

	public Planets2(int x, int y, int dir) {
		super(x + 16, y + 16, 10, 10);
		this.dir = dir;
	}

	public void move() {
		x += spd * dir;
		frames++;
		if (frames == 2360) {
			Game.planets2.remove(this);
		}
	}

	public void tick() {

		move();

	}

	public void render(Graphics g) {
		// g.setColor(Color.BLUE);
		// g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.planets2, x, y, 95, 50, null);

	}

}

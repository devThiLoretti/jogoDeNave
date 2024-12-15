package Application;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	public static BufferedImage spritesheet;
	public static BufferedImage[] player_front; 
	public static BufferedImage bullet;
	public static BufferedImage[] enemy_front;
	public static BufferedImage planets;
	public static BufferedImage planets2;
	public static BufferedImage planets3;
	public static BufferedImage planets4;
	
	public Spritesheet() {
		try {
		spritesheet = ImageIO.read(getClass().getResource("/sprites-de-jogo-de-nave-espacial_22191-156.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
				
		player_front = new BufferedImage[2];
		enemy_front = new BufferedImage[2];
		
		player_front[0] = Spritesheet.getSprite(1, 57, 132, 72);
		player_front[1] = Spritesheet.getSprite(435, 262, 132, 72);
		
		enemy_front[0] = Spritesheet.getSprite(40, 319, 239, 106);
		enemy_front[1] = Spritesheet.getSprite(40, 319, 239, 106);
		
		bullet = Spritesheet.getSprite(306, 0, 68, 48);
		planets = Spritesheet.getSprite(530, 149, 83, 83);
		planets2 = Spritesheet.getSprite(282, 278, 95, 50);
		planets3 = Spritesheet.getSprite(6, 254, 65, 64);
		planets4 = Spritesheet.getSprite(256, 126, 52, 49);
		
		
		
	}
	
	

	
	//159, 211
	//177, 211
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}

}

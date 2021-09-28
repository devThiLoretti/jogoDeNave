package Application;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();

		frame.add(game);
		frame.setTitle("Jogo de nave");
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		new Thread(game).start();

	}

	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;

	public static Player player;
	

	public static List<Enemy> enemies = new ArrayList<Enemy>();
	public static List<Stars1> stars1 = new ArrayList<Stars1>();
	public static List<Stars2> stars2 = new ArrayList<Stars2>();
	public static List<Stars3> stars3 = new ArrayList<Stars3>();
	public static List<Planets> planets = new ArrayList<Planets>();
	public static List<Planets2> planets2 = new ArrayList<Planets2>();
	public static List<Planets3> planets3 = new ArrayList<Planets3>();
	public static List<Planets4> planets4 = new ArrayList<Planets4>();

	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		int delay4 = 1700;
		int interval4 = 87500;
		Timer timer4 = new Timer();
		timer4.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				planets.add(new Planets(1064, 500, -1));
			}
		}, delay4, interval4);

		int delay5 = 1000;
		int interval5 = 97500;
		Timer timer5 = new Timer();
		timer5.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				planets2.add(new Planets2(2064, 200, -1));
			}
		}, delay5, interval5);

		int delay6 = 33600;
		int interval6 = 77500;
		Timer timer6 = new Timer();
		timer6.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				planets3.add(new Planets3(1500, 300, -1));
			}
		}, delay6, interval6);

		int delay7 = 23300;
		int interval7 = 67500;
		Timer timer7 = new Timer();
		timer7.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				planets4.add(new Planets4(1700, 500, -1));
			}
		}, delay7, interval7);

		player = new Player(32, 32);
		enemies.add(new Enemy(32, 300));

		int delay3 = 500;
		int interval3 = 27500;
		Timer timer3 = new Timer();
		timer3.scheduleAtFixedRate(new TimerTask() {
			public void run() {

				stars3.add(new Stars3(1430, 250, -1));
				stars3.add(new Stars3(2430, 450, -1));
				stars3.add(new Stars3(3430, 750, -1));
				stars3.add(new Stars3(1630, 450, -1));
				stars3.add(new Stars3(2630, 650, -1));
				stars3.add(new Stars3(3630, 950, -1));
				stars3.add(new Stars3(430, 650, -1));
				stars3.add(new Stars3(1430, 250, -1));
				stars3.add(new Stars3(1430, 1750, -1));
				stars3.add(new Stars3(1330, 850, -1));
				stars3.add(new Stars3(1690, 950, -1));
				stars3.add(new Stars3(2630, 1050, -1));

			}
		}, delay3, interval3);

		if (new Random().nextInt(100) < 98) {
			int delay2 = 19000;
			int interval2 = 19200;
			Timer timer2 = new Timer();
			timer2.scheduleAtFixedRate(new TimerTask() {
				public void run() {

					stars2.add(new Stars2(1630, 270, -1));
					stars2.add(new Stars2(1630, 670, -1));
					stars2.add(new Stars2(1830, 470, -1));
					stars2.add(new Stars2(1530, 370, -1));
					stars2.add(new Stars2(1430, 470, -1));
					stars2.add(new Stars2(1230, 370, -1));

				}
			}, delay2, interval2);
		}

		int delay = 1000;
		int interval = 1000;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {

				stars1.add(new Stars1(1300, 200, -1));
				stars1.add(new Stars1(1400, 400, -1));
				stars1.add(new Stars1(1450, 600, -1));
				stars1.add(new Stars1(1900, 450, -1));
				stars1.add(new Stars1(1390, 100, -1));
				stars1.add(new Stars1(1700, 40, -1));
				stars1.add(new Stars1(1480, 20, -1));
				stars1.add(new Stars1(1490, 713, -1));
				stars1.add(new Stars1(1200, 810, -1));
				stars1.add(new Stars1(1200, 340, -1));
				stars1.add(new Stars1(1700, 640, -1));
				stars1.add(new Stars1(1740, 700, -1));
				stars1.add(new Stars1(1100, 1340, -1));

			}
		}, delay, interval);

		new Spritesheet();
	}

	public void tick() {
		player.tick();
		

		for (int i = 0; i < stars1.size(); i++) {
			stars1.get(i).tick();
		}

		for (int i = 0; i < stars2.size(); i++) {
			stars2.get(i).tick();
		}

		for (int i = 0; i < stars3.size(); i++) {
			stars3.get(i).tick();
		}

		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).tick();
		}

		for (int i = 0; i < planets.size(); i++) {
			planets.get(i).tick();
		}

		for (int i = 0; i < planets2.size(); i++) {
			planets2.get(i).tick();
		}

		for (int i = 0; i < planets3.size(); i++) {
			planets3.get(i).tick();
		}

		for (int i = 0; i < planets4.size(); i++) {
			planets4.get(i).tick();
		}

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		

		for (int i = 0; i < stars1.size(); i++) {
			stars1.get(i).render(g);
		}

		for (int i = 0; i < planets4.size(); i++) {
			planets4.get(i).render(g);
		}

		for (int i = 0; i < planets3.size(); i++) {
			planets3.get(i).render(g);
		}

		for (int i = 0; i < planets2.size(); i++) {
			planets2.get(i).render(g);
		}

		for (int i = 0; i < planets.size(); i++) {
			planets.get(i).render(g);
		}

		for (int i = 0; i < stars2.size(); i++) {
			stars2.get(i).render(g);
		}

		for (int i = 0; i < stars3.size(); i++) {
			stars3.get(i).render(g);
		}

		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render(g);
		}

		
		player.render(g);
		

		bs.show();
	}

	@Override
	public void run() {
		while (true) {
			tick();
			render();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_Z) {
			player.shoot = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}

	}

}

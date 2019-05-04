package tank;

import common.ResourceManager;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	/**
	 * 子弹宽高
	 */
	private static int WIDTH = 30;
	private static int HEIGHT = 30;
	/**
	 * 字段速度
	 */
	private static final int SPEED = 10;

	/**
	 * 子弹位置
	 */
	protected int x;
	protected int y;
	/**
	 * 子弹方向
	 */
	protected Dir dir;

	/**
	 * 是否存活
	 */
	protected boolean live = true;

	TankClient tf = null;

	public Bullet(int x, int y, Dir dir, TankClient tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		if (!live) {
			tf.bullets.remove(this);
		}

//		Color c = g.getColor();
//		g.setColor(Color.RED);
//		g.fillOval(x, y, WIDTH, HEIGHT);
//		g.setColor(c);
		if(Dir.LEFT.equals(dir)){
			g.drawImage(ResourceManager.bulletL,x,y ,null);
		}else if(Dir.RIGHT.equals(dir)){
			g.drawImage(ResourceManager.bulletR,x,y ,null);
		} else if (Dir.UP.equals(dir)) {
			g.drawImage(ResourceManager.bulletU,x,y ,null);
		} else if (Dir.DOWN.equals(dir)) {
			g.drawImage(ResourceManager.bulletD,x,y ,null);
		}

		move();
	}

	protected void move() {
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
		if (x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT) {
			live = false;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

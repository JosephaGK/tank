package core.base.bullet;

import common.ResourceManager;
import core.base.ClientFrame;
import core.base.ClientFrameObject;
import core.base.Dir;

import java.awt.Graphics;

public class Bullet extends ClientFrameObject {

	/**
	 * 子弹宽高
	 */
	public static int WIDTH = 5;
	public static int HEIGHT = 5;

	public int speed = 10;

	/**
	 * 是否存活
	 */
	public boolean live = true;

	public Bullet(int x, int y, Dir dir, ClientFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.moving  = true;
		this.clientFrame = tf;
	}

	@Override
	public void paint(Graphics g) {
		if (!live) {
			clientFrame.bullets.remove(this);
		}
		if (Dir.LEFT.equals(dir)) {
			g.drawImage(ResourceManager.bulletL, x, y, null);
		} else if (Dir.RIGHT.equals(dir)) {
			g.drawImage(ResourceManager.bulletR, x, y, null);
		} else if (Dir.UP.equals(dir)) {
			g.drawImage(ResourceManager.bulletU, x, y, null);
		} else if (Dir.DOWN.equals(dir)) {
			g.drawImage(ResourceManager.bulletD, x, y, null);
		}
		move();
	}

	@Override
	public void move() {
		if (moving) {
			switch (dir) {
			case LEFT:
				x -= speed;
				break;
			case UP:
				y -= speed;
				break;
			case RIGHT:
				x += speed;
				break;
			case DOWN:
				y += speed;
				break;
			default:
			}
		}
		checkBorder();
	}

	@Override
	public void checkBorder() {
		if (x < 0 || y < 0 || x > ClientFrame.GAME_WIDTH || y > ClientFrame.GAME_HEIGHT) {
			live = false;
		}
	}
}

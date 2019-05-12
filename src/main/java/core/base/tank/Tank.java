package core.base.tank;

import common.ResourceManager;
import core.base.bullet.Bullet;
import core.base.ClientFrame;
import core.base.ClientFrameObject;
import core.base.Dir;

import java.awt.Graphics;

/**
 * @author Joseph
 */
public class Tank extends ClientFrameObject {
	/**
	 * 坦克宽高
	 */
	public static int WIDTH = 10;
	public static int HEIGHT = 10;
	public int speed = 5;

	public Tank(int x, int y, Dir dir,boolean moving,int speed, ClientFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.speed = speed;
		this.moving = moving;
		this.clientFrame = tf;
	}

	@Override
	public void paint(Graphics g) {
		if (Dir.LEFT.equals(dir)) {
			g.drawImage(ResourceManager.tankL, x, y, null);
		} else if (Dir.RIGHT.equals(dir)) {
			g.drawImage(ResourceManager.tankR, x, y, null);
		} else if (Dir.UP.equals(dir)) {
			g.drawImage(ResourceManager.tankU, x, y, null);
		} else if (Dir.DOWN.equals(dir)) {
			g.drawImage(ResourceManager.tankD, x, y, null);
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
	}

	@Override
	public void checkBorder() {
		if(this.x<=0){
			this.dir = (Dir.RIGHT);
		}
		if(this.x>= ClientFrame.GAME_WIDTH){
			this.dir = (Dir.LEFT);
		}
		if(this.y<=0){
			this.dir = (Dir.DOWN);
		}
		if(this.y>= ClientFrame.GAME_HEIGHT){
			this.dir = (Dir.UP);
		}
	}

	public void fire() {
		clientFrame.bullets.add(new Bullet(this.x + ResourceManager.tankD.getWidth() / 2, this.y + ResourceManager.tankD.getWidth() / 2, this.dir, this.clientFrame));
	}
}

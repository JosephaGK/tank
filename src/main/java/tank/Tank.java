package tank;

import common.ResourceManager;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Joseph
 */
public class Tank {
	/**
	 * 位置坐标xy
	 */
	protected int x;
	protected int y;
	/**
	 * 方向
	 */
	protected Dir dir = Dir.DOWN;
	/**
	 * 坦克速度
	 */
	private static final int SPEED = 5;
	/**
	 * 是否运动
	 */
	private boolean moving = false;

	protected TankClient tf = null;

	public Tank() {
	}

	public Tank(int x, int y, Dir dir, TankClient tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void paint(Graphics g) {

		if(Dir.LEFT.equals(dir)){
			g.drawImage(ResourceManager.tankL,x,y,null);
		}else if(Dir.RIGHT.equals(dir)){
			g.drawImage(ResourceManager.tankR,x,y,null);
		} else if (Dir.UP.equals(dir)) {
			g.drawImage(ResourceManager.tankU,x,y,null);
		} else if (Dir.DOWN.equals(dir)) {
			g.drawImage(ResourceManager.tankD,x,y,null);
		}
		move();
	}

	private void move() {
		if (moving) {
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
		}
	}

	public void fire() {
		tf.bullets.add(new Bullet(this.x+ResourceManager.tankD.getWidth()/2, this.y+ResourceManager.tankD.getWidth()/2, this.dir, this.tf));
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}
}

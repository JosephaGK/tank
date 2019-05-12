package core.base;

import java.awt.*;

/**
 * 窗口对象，窗口物体的父类
 * @author Joseph
 */
public abstract class ClientFrameObject {
	/**
	 * 位置坐标xy
	 */
	public int x;
	public int y;
	/**
	 * 方向
	 */
	public Dir dir = Dir.DOWN;
	/**
	 * 是否运动
	 */
	public boolean moving = false;

	public ClientFrame clientFrame = null;

	/**
	 * 显示图像
	 * @param g
	 */
	public abstract void paint(Graphics g);

	/**
	 * 移动
	 */
	public abstract void move();

	public abstract void checkBorder();
}

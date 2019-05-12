package core.base;

import common.ResourceManager;

import java.awt.*;

/**
 * 爆炸类
 * @author Joseph
 */
public class Explode extends ClientFrameObject {
	/**
	 * 图片不断变换下标
	 */
	public int order;

	public Explode(int x, int y, ClientFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.order = 0;
		this.clientFrame = tf;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(ResourceManager.explodes[order++],x,y,null);
		if (order==ResourceManager.explodes.length) {
			clientFrame.explodeList.remove(this);
		}
	}

	@Override
	public void move() {

	}

	@Override
	public void checkBorder() {

	}
}

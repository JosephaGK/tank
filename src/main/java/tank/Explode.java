package tank;

import common.ResourceManager;

import java.awt.*;

public class Explode {
	private int x;
	private int y;
	private int order;
	private TankClient tf = null;

	public Explode(int x, int y, int order, TankClient tf) {
		this.x = x;
		this.y = y;
		this.order = order;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		g.drawImage(ResourceManager.explodes.get(order++),x,y,null);
		if (order==ResourceManager.explodes.size()) {
			tf.explodeList.remove(this);
		}
	}

}

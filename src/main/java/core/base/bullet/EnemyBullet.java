package core.base.bullet;

import common.ResourceManager;
import core.base.ClientFrame;
import core.base.Dir;

import java.awt.*;

public class EnemyBullet extends Bullet {
	public EnemyBullet(int x, int y, Dir dir, ClientFrame tf) {
		super(x, y, dir, tf);
	}

	@Override
	public void paint(Graphics g) {
		if (!live) {
			clientFrame.enemyBulletList.remove(this);
		}
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
}

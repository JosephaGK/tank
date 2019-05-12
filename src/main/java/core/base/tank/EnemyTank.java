package core.base.tank;

import common.RandomUtil;
import common.ResourceManager;
import core.base.bullet.EnemyBullet;
import core.base.ClientFrame;
import core.base.Dir;

import java.awt.*;
import java.util.Random;

/**
 * 敌人坦克类
 * @author Joseph
 */
public class EnemyTank extends Tank {

	Random r = new Random();

	public EnemyTank(int x, int y, Dir dir, ClientFrame tf) {
		super(x, y, dir,true,2, tf);
		this.moving=true;
	}

	@Override
	public void fire() {
		clientFrame.enemyBulletList.add(
				new EnemyBullet(this.x+ ResourceManager.tankD.getWidth()/2, this.y+ResourceManager.tankD.getWidth()/2, this.dir, this.clientFrame));
	}

	@Override
	public void paint(Graphics g) {
		if (Dir.LEFT.equals(dir)) {
			g.drawImage(ResourceManager.enemyTankL, x, y, null);
		} else if (Dir.RIGHT.equals(dir)) {
			g.drawImage(ResourceManager.enemyTankR, x, y, null);
		} else if (Dir.UP.equals(dir)) {
			g.drawImage(ResourceManager.enemyTankU, x, y, null);
		} else if (Dir.DOWN.equals(dir)) {
			g.drawImage(ResourceManager.enemyTankD, x, y, null);
		}
		move();
		checkBorder();
		//判断是否发射子弹
		if(RandomUtil.eightyPercent()){
			this.fire();
		}
		//判断是否改变方向
		if(RandomUtil.eightyPercent()){
			this.dir = getChangeDir();
		}
	}

	Dir getChangeDir(){
		int i = r.nextInt(4);
		if (i==0) {
			return Dir.DOWN;
		}else if(i==1){
			return Dir.LEFT;
		}else if(i==2){
			return Dir.RIGHT;
		}else if(i==3){
			return Dir.UP;
		}
		return Dir.UP;
	}

}

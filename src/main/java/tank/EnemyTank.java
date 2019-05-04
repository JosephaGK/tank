package tank;

import common.ResourceManager;

import java.awt.*;
import java.util.Random;

public class EnemyTank extends Tank{
	Random r = new Random();
	public EnemyTank(int x, int y, Dir dir, TankClient tf) {
		super(x, y, dir, tf);
		this.setMoving(true);
	}

	@Override
	public void fire() {
		tf.enemyBulletList.add(new EnemyBullet(this.x+ ResourceManager.tankD.getWidth()/2, this.y+ResourceManager.tankD.getWidth()/2, this.dir, this.tf));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//判断是否发射子弹
		if(r.nextInt(10)>8){
			this.fire();
		}
		//判断是否改变方向
		if(r.nextInt(10)>8){
			this.setDir(getChangeDir());
		}
		checkBoundry();
	}

	private void checkBoundry() {
		if(this.x<=0){
			this.setDir(Dir.RIGHT);
		}
		if(this.x>=TankClient.GAME_WIDTH){
			this.setDir(Dir.LEFT);
		}
		if(this.y<=0){
			this.setDir(Dir.DOWN);
		}
		if(this.y>=TankClient.GAME_HEIGHT){
			this.setDir(Dir.UP);
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
		return null;
	}
}

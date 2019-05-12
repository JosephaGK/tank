package start;

import core.base.Dir;
import core.base.tank.EnemyTank;
import core.base.ClientFrame;

public class ClientStarter {
	public static void main(String[] args) throws InterruptedException {
		ClientFrame tf = new ClientFrame();
		//增加敌人坦克
		for (int i = 0; i < 5; i++) {
			tf.enemyTankList.add(new EnemyTank(100 * i, 100, Dir.DOWN, tf));
		}
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}
}

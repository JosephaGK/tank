package tank;

import common.ResourceManager;
import common.Util;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankClient extends Frame {

	/**
	 * 客户端窗口大小
	 */
	static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
	/**
	 * 每个客户端有一个自己的坦克对象
	 */
	Tank myTank = new Tank(200, 200, Dir.DOWN, this);
	/**
	 * 客户端发射的子弹集合
	 */
	List<Bullet> bullets = new ArrayList<>();
	/**
	 * 敌人坦克集合
	 */
	List<EnemyTank> enemyTankList = new ArrayList<>();
	/**
	 * 敌人子弹集合
	 */
	List<Bullet> enemyBulletList = new ArrayList<>();
	/**
	 * 爆炸的集合
	 */
	List<Explode> explodeList = new ArrayList<>();

	public TankClient() {
		//设置窗口打下
		setSize(GAME_WIDTH, GAME_HEIGHT);
		//设置不能改变窗口大小
		setResizable(false);
		//设置窗口名称
		setTitle("tank war");
		//设置窗口可见
		setVisible(true);
		//初始化敌人坦克
		initEnemyTank();
		//增加按键监听器
		this.addKeyListener(new MyKeyListener());

		//增加窗口监听器设置可以关闭
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void initEnemyTank() {
		for (int i = 0; i < 2; i++) {
			this.enemyTankList.add(new EnemyTank(100 * i, 100, Dir.DOWN, this));
		}
	}

	Image offScreenImage = null;

	/**
	 * 解决屏幕闪的问题
	 *
	 * @param g
	 */
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量:" + bullets.size(), 10, 60);
		g.setColor(c);

		g.setColor(Color.WHITE);
		g.drawString("敌人坦克的数量:" + enemyTankList.size(), 10, 80);
		g.setColor(c);

		g.setColor(Color.WHITE);
		g.drawString("敌人子弹的数量:" + enemyBulletList.size(), 10, 100);
		g.setColor(c);

		myTank.paint(g);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint(g);
		}
		for (int i = 0; i < enemyTankList.size(); i++) {
			enemyTankList.get(i).paint(g);
		}
		for (int i = 0; i < enemyBulletList.size(); i++) {
			enemyBulletList.get(i).paint(g);
		}
		for (int i = 0; i < explodeList.size(); i++) {
			explodeList.get(i).paint(g);
		}
		//增加敌人坦克
		if (Util.r.nextInt(10) > 8) {
			if (enemyTankList.size() <5) {
				this.enemyTankList.add(new EnemyTank(400, 10, Dir.DOWN, this));
			}
		}
		checkExplode();
	}

	private void checkExplode() {
		checkHitEnemy();
		checkHieMe();
	}

	private void checkHieMe() {

	}

	private void checkHitEnemy() {
		Iterator<Bullet> bulletIterator = bullets.iterator();
		//遍历，如果子弹击中坦克，上方消失
		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			Iterator<EnemyTank> enemyTankIterator = enemyTankList.iterator();
			while (enemyTankIterator.hasNext()) {
				EnemyTank enemyTank = enemyTankIterator.next();
				if (
						bullet.getX() >= enemyTank.x &&
						bullet.getX()+ResourceManager.bulletD.getWidth() <= enemyTank.x + ResourceManager.tankD.getWidth() &&
						bullet.getY() >= enemyTank.y
						&& bullet.getY()+ResourceManager.bulletD.getHeight() <= enemyTank.y + ResourceManager.tankD.getHeight()) {
					enemyTankIterator.remove();
					bulletIterator.remove();
					this.explodeList.add(new Explode(enemyTank.x,enemyTank.y,1,this));
				}
			}
		}
//		for (int i = 0; i < bullets.size(); i++) {
//
//		}
	}

	class MyKeyListener extends KeyAdapter {

		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;

			case KeyEvent.VK_CONTROL:
				//ctrl键发射子弹
				myTank.fire();
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			//任何一个方向为true时需要移动
			if (bL || bU || bR || bD) {
				myTank.setMoving(true);
				if (bL) {
					myTank.setDir(Dir.LEFT);
				}
				if (bU) {
					myTank.setDir(Dir.UP);
				}
				if (bR) {
					myTank.setDir(Dir.RIGHT);
				}
				if (bD) {
					myTank.setDir(Dir.DOWN);
				}
			} else {
				myTank.setMoving(false);
			}
		}

	}

}

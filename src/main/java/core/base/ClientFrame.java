package core.base;

import common.ResourceManager;
import core.base.bullet.Bullet;
import core.base.tank.EnemyTank;
import core.base.tank.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 客户端窗口类
 *
 * @author Joseph
 */
public class ClientFrame extends Frame {

	/**
	 * 客户端窗口大小
	 */
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	/**
	 * 每个客户端有一个自己的坦克对象
	 */
	public Tank myTank = new Tank(200, 200, Dir.DOWN, false, 5, this);
	/**
	 * 客户端发射的子弹集合
	 */
	public List<Bullet> bullets = new ArrayList<>();
	/**
	 * 敌人坦克集合
	 */
	public List<EnemyTank> enemyTankList = new ArrayList<>();
	/**
	 * 敌人子弹集合
	 */
	public List<Bullet> enemyBulletList = new ArrayList<>();
	/**
	 * 爆炸的集合
	 */
	public List<Explode> explodeList = new ArrayList<>();

	/**
	 * 防止闪屏用
	 */
	private Image offScreenImage = null;

	public ClientFrame() {
		//设置窗口打下
		setSize(GAME_WIDTH, GAME_HEIGHT);
		//设置不能改变窗口大小
		setResizable(false);
		//设置窗口名称
		setTitle("core war");
		//设置窗口可见
		setVisible(true);
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
		checkExplode();
	}

	private void checkExplode() {
		checkHitEnemy();
	}

	private void checkHitEnemy() {
		Iterator<Bullet> bulletIterator = bullets.iterator();
		//遍历，如果子弹击中坦克，上方消失
		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			Iterator<EnemyTank> enemyTankIterator = enemyTankList.iterator();
			while (enemyTankIterator.hasNext()) {
				EnemyTank enemyTank = enemyTankIterator.next();
				if (bullet.x >= enemyTank.x &&
					bullet.x + ResourceManager.bulletD.getWidth() <= enemyTank.x + ResourceManager.tankD.getWidth() &&
					bullet.y >= enemyTank.y &&
					bullet.y + ResourceManager.bulletD.getHeight() <= enemyTank.y + ResourceManager.tankD.getHeight()) {
					enemyTankIterator.remove();
					bulletIterator.remove();
					this.explodeList.add(new Explode(enemyTank.x, enemyTank.y, this));
				}
			}
		}
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
				myTank.moving = true;
				if (bL) {
					myTank.dir = (Dir.LEFT);
				}
				if (bU) {
					myTank.dir = (Dir.UP);
				}
				if (bR) {
					myTank.dir = (Dir.RIGHT);
				}
				if (bD) {
					myTank.dir = (Dir.DOWN);
				}
			} else {
				myTank.moving = false;
			}
		}

	}

}

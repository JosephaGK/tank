package common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 资源管理类
 * @author Joseph
 */
public class ResourceManager {
	public static BufferedImage tankU;
	public static BufferedImage tankL;
	public static BufferedImage tankR;
	public static BufferedImage tankD;

	public static BufferedImage enemyTankU;
	public static BufferedImage enemyTankL;
	public static BufferedImage enemyTankR;
	public static BufferedImage enemyTankD;

	public static BufferedImage bulletU;
	public static BufferedImage bulletD;
	public static BufferedImage bulletL;
	public static BufferedImage bulletR;

	public static BufferedImage[] explodes = new BufferedImage[5];

	static {
		try {

			tankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tank/tankU.png"));
			tankL = ImageUtil.rotateImage(tankU, -90);
			tankR = ImageUtil.rotateImage(tankU, 90);
			tankD = ImageUtil.rotateImage(tankU, 180);

			enemyTankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tank/enemyTankU.png"));
			enemyTankL = ImageUtil.rotateImage(enemyTankU, -90);
			enemyTankR = ImageUtil.rotateImage(enemyTankU, 90);
			enemyTankD = ImageUtil.rotateImage(enemyTankU, 180);

			bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tank/bulletU.png"));
			bulletL = ImageUtil.rotateImage(bulletU, -90);
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletU, 180);

			for (int i = 1; i <= 5; i++) {
				explodes[i-1]=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/explode/explode"+i+".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

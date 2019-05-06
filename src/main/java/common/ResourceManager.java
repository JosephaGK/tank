package common;

import com.sun.imageio.plugins.common.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceManager {
	public static BufferedImage tankU;
	public static BufferedImage tankD;
	public static BufferedImage tankL;
	public static BufferedImage tankR;

	public static BufferedImage enemyTankU;
	public static BufferedImage enemyTankD;
	public static BufferedImage enemyTankL;
	public static BufferedImage enemyTankR;

	public static BufferedImage bulletU;
	public static BufferedImage bulletD;
	public static BufferedImage bulletL;
	public static BufferedImage bulletR;

	public static List<BufferedImage> explodes = new ArrayList<>();

	static {
		try {
			tankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			tankL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankR.gif"));

			bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			bulletL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));

			for (int i = 1; i <= 16; i++) {
				explodes.add(ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e"+i+".gif")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

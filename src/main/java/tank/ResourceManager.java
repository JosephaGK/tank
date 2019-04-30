package tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManager {
	public static BufferedImage tankU;
	public static BufferedImage tankD;
	public static BufferedImage tankL;
	public static BufferedImage tankR;

	public static BufferedImage bulletU;
	public static BufferedImage bulletD;
	public static BufferedImage bulletL;
	public static BufferedImage bulletR;

	static {
		try {
			tankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			tankL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

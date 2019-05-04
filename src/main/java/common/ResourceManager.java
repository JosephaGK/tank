package common;

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

	public static BufferedImage e1;
	public static BufferedImage e2;
	public static BufferedImage e3;
	public static BufferedImage e4;
	public static BufferedImage e5;
	public static BufferedImage e6;
	public static BufferedImage e7;
	public static BufferedImage e8;
	public static BufferedImage e9;
	public static BufferedImage e10;
	public static BufferedImage e11;
	public static BufferedImage e12;
	public static BufferedImage e13;
	public static BufferedImage e14;
	public static BufferedImage e15;
	public static BufferedImage e16;

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

			e1 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e1.gif"));
			e2 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e2.gif"));
			e3 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e3.gif"));
			e4 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e4.gif"));
			e5 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e5.gif"));
			e6 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e6.gif"));
			e7 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e7.gif"));
			e8 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e8.gif"));
			e9 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e9.gif"));
			e10 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e10.gif"));
			e11 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e11.gif"));
			e12 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e12.gif"));
			e13 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e13.gif"));
			e14 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e14.gif"));
			e15 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e15.gif"));
			e16 = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e16.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

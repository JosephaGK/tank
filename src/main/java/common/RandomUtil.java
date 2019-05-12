package common;

import java.util.Random;

/**
 * 随机工具类
 * @author Joseph
 */
public class RandomUtil {
	private RandomUtil(){}
	private static Random r = new Random();

	public static boolean halfPercent(){
		if(4 < r.nextInt(10)){
			return true;
		}else{
			return false;
		}
	}
	public static boolean eightyPercent(){
		if(8 < r.nextInt(10)){
			return true;
		}else{
			return false;
		}
	}


}

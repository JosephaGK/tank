package tank;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankClient tf = new TankClient();
		
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
		
	}

}

package tank;

import common.ResourceManager;

import java.awt.*;

public class Explode {
	private int x;
	private int y;
	private int order = 1;
	private TankClient tf = null;

	public Explode(int x, int y, int order, TankClient tf) {
		this.x = x;
		this.y = y;
		this.order = order;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		if(order==1){
			g.drawImage(ResourceManager.e1,x,y ,null);
			order++;
		}else if(order==2){
			g.drawImage(ResourceManager.e2,x,y ,null);
			order++;
		}else if(order==3){
			g.drawImage(ResourceManager.e3,x,y ,null);
			order++;
		}else if(order==4){
			g.drawImage(ResourceManager.e4,x,y ,null);
			order++;
		}else if(order==5){
			g.drawImage(ResourceManager.e5,x,y ,null);
			order++;
		}else if(order==6){
			g.drawImage(ResourceManager.e6,x,y ,null);
			order++;
		}else if(order==7){
			g.drawImage(ResourceManager.e7,x,y ,null);
			order++;
		}else if(order==8){
			g.drawImage(ResourceManager.e8,x,y ,null);
			order++;
		}else if(order==9){
			g.drawImage(ResourceManager.e9,x,y ,null);
			order++;
		}else if(order==10){
			g.drawImage(ResourceManager.e10,x,y ,null);
			order++;
		}else if(order==11){
			g.drawImage(ResourceManager.e11,x,y ,null);
			order++;
		}else if(order==12){
			g.drawImage(ResourceManager.e12,x,y ,null);
			order++;
		}else if(order==13){
			g.drawImage(ResourceManager.e13,x,y ,null);
			order++;
		}else if(order==14){
			g.drawImage(ResourceManager.e14,x,y ,null);
			order++;
		}else if(order==15){
			g.drawImage(ResourceManager.e15,x,y ,null);
			order++;
		}else if(order==16){
			g.drawImage(ResourceManager.e16,x,y ,null);
			tf.explodeList.remove(this);
		}
	}

}

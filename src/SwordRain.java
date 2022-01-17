import java.awt.Rectangle;

public class SwordRain extends Thread {
	DarkLord lord;
int i=0;
	Dragon[] dragons;
   DragonLevel dragonLevel;
   Shooter shooter;
static int score=0;







	public SwordRain(DarkLord sword, Dragon[] dragons, DragonLevel dragonLevel, Shooter shooter) {
	super();
	this.lord = sword;
	this.dragons = dragons;
	this.dragonLevel = dragonLevel;
	this.shooter= shooter;
}



	
	
	




@Override
public void run() {
		
	while(lord.getyAxis()>=-200 && lord.getyAxis()<=1000) {
	
			
			lord.setyAxis(lord.getyAxis()+7);
			 checkcollison();
			try {
				Thread.sleep(10);
				 dragonLevel.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} dragonLevel.repaint();
		}
		 dragonLevel.repaint();
		;}
		
	
			
		
//		
//				while(bullet.getyAxis()>-100) {
//					
//					bullet.setyAxis(bullet.getyAxis()+10);
//				//	 checkcollison();
//					try {
//						Thread.sleep(10);
//						 nob.repaint();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} nob.repaint();
//				}
//				 nob.repaint();
	
	
		



public void checkcollison() {
	
	
			Rectangle birdrec=new Rectangle(shooter.getxAxis(),shooter.getyAxis(),100,100);
				Rectangle brec=new Rectangle(lord.getxAxis(),lord.getyAxis(),40,140);
				if (brec.intersects(birdrec)) {
					
					lord.setxAxis(5000000);
					shooter.setxAxis(-500000);
				score=1;
				
					
				}
			}
		
			
		
	
	
	
	








public SwordRain() {
	super();
}










public static int getScore() {
	return score;
}










public static void setScore(int score) {
	SwordRain.score = score;
}





}

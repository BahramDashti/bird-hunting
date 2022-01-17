import java.awt.Rectangle;

public class Fire extends Thread{
	
	Bullet bullet;
	NoobLevel nob;
	Dragon[] dragons;
   DragonLevel d;
	public Fire(Bullet bullet, Dragon[] dragons,DragonLevel dragonLevel) {
		super();
		this.bullet = bullet;
		this.dragons = dragons;
		this.d = dragonLevel;
	}



	static int score=0;
	Thread mThread=new Thread();

	




@Override
public void run() {
	while(bullet.getyAxis()>-100) {
		
		bullet.setyAxis(bullet.getyAxis()-10);
		 checkcollison();
		try {
			Thread.sleep(10);
			 d.repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} d.repaint();
	}
	 d.repaint();
	
//			while(bullet.getyAxis()>-100) {
//				
//				bullet.setyAxis(bullet.getyAxis()+10);
//			//	 checkcollison();
//				try {
//					Thread.sleep(10);
//					 nob.repaint();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} nob.repaint();
//			}
//			 nob.repaint();
		}



public void checkcollison() {
	
	Rectangle brec=new Rectangle(bullet.getxAxis(),bullet.getyAxis(),20,40);
	for (int i = 0; i < dragons.length; i++) {
		if (dragons[i]!=null) {
			Rectangle birdrec=new Rectangle(dragons[i].getxAxis(),dragons[i].getyAxis(),100,100);
		if (brec.intersects(birdrec)) {
			dragons[i].setxAxis(5000000);
			bullet.setxAxis(-500000);
		score++;
			
		}
			
		
	}
	}
		
	
}



public static void setScore(int score) {
	Fire.score = score;
}



public Fire() {
	super();
}



public int getScore() {
	
	return score;
}
}

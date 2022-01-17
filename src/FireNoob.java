import java.awt.Rectangle;

public class FireNoob extends Thread{
	
	Bullet bullet;
	NoobLevel nob;
	Bird[] bird;
   DragonLevel d;
	



	public FireNoob(Bullet bullet, NoobLevel nob, Bird[] bird) {
	super();
	this.bullet = bullet;
	this.nob = nob;
	this.bird = bird;
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
			 nob.repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} nob.repaint();
	}
	 nob.repaint();
	
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
	for (int i = 0; i < bird.length; i++) {
		if (bird[i]!=null) {
			Rectangle birdrec=new Rectangle(bird[i].getxAxis(),bird[i].getyAxis(),100,100);
		if (brec.intersects(birdrec)) {
			bird[i].setxAxis(5000000);
			bullet.setxAxis(-500000);
		score++;
			
		}
			
		
	}
	}
		
	
}



public static void setScore(int score) {
FireNoob.score = score;
}



public FireNoob() {
	super();
}



public int getScore() {
	
	return score;
}
}

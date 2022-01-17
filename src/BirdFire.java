import java.awt.Rectangle;

public class BirdFire extends Thread {
	Bullet bullet;
	NoobLevel nob;
	Bird[] bird;
	static int score=0;
	Shooter mShooter;
	//Thread mThread=new Thread();

	
	public BirdFire(Bullet bullet, NoobLevel nob, Bird[] bird, Shooter mShooter) {
		
		this.bullet = bullet;
		this.nob = nob;
		this.bird = bird;
		this.mShooter = mShooter;
	}


@Override
public void run() {
	
			while(bullet.getyAxis()>-100) {
				
				bullet.setyAxis(bullet.getyAxis()+10);
		//	checkcollison();
				try {
					Thread.sleep(100);
					 nob.repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} nob.repaint();
			}
			 nob.repaint();
		}













public BirdFire() {
	
}


public void checkcollison() {
	
	Rectangle brec=new Rectangle(bullet.getxAxis(),bullet.getyAxis(),20,40);
	
		
			Rectangle birdrec=new Rectangle(mShooter.getxAxis(),mShooter.getyAxis(),100,100);
		
		if (brec.intersects(birdrec)) {
			
			bullet.setxAxis(-500000);
		score--;
			
		}
			
		
	}
	
	public void setScore() {
	BirdFire.score = score;
}	
	public int getScore() {
	return score;
}
}


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.JobAttributes;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Savepoint;
import java.text.AttributedString;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sun.misc.Cleaner;





public class DragonLevel extends JPanel implements KeyListener {
       JFrame windows=new JFrame();
       Shooter shooter=new Shooter(683,610,"images//revolver1.png");
      Dragon[] dragons=new Dragon[120];
    
      
       Bullet[] bullets=new Bullet[100];
       DarkLord[] sword=new DarkLord[120];
     //  SwordRain swordRaincheck=new SwordRain();
       FinishedDragonLevel mFinished;
       SwordRain swordRain;
      DragonLevel mLevel=this;
     //  int s = 1, seconds = 90, minute = 1;
       Clip sclip;
       int secend=0;int secend1=0;
       int xAxis=0;
       int yAxis=50;
       Timer timer=new Timer();
       int count=0;
       int min =2;
      static int stop=0;
      int taskstoper=0;
      int sec=0;
        int sr=bullets.length;
      //  dragonsFire mdragonsFire=new dragonsFire();
      
        public int getSr() {
			return sr;
		}
        public void closeing() {
        	WindowEvent winClosingEvent = new WindowEvent(windows,WindowEvent.WINDOW_CLOSING);
        	 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
        	 
        }
        TimerTask makesowrd=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(secend1<sword.length) {
					 swordRain=new SwordRain(sword[secend1], dragons, mLevel, shooter);
					swordRain.start();
					}
				
				secend1++;
				
			}
				
		};
		TimerTask movesword=new TimerTask() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				// TODO Auto-generated method stub
			
				 int barkhord=swordRain.getScore();
			     if (barkhord==1&&taskstoper< 1) { 
			    	 swordRain.setScore(0);
			    	 swordRain.stop();
			    	System.out.println(taskstoper);
			    	 taskstoper++;
			    	 closeing();
			    	  mFinished=new FinishedDragonLevel();
			    
			    	
			    	 System.out.println(swordRain.getScore());
			    	
			    	

			    	 if (sclip!=null) {
						sclip.stop();
						
					}
			    	
			    	
			   	 
			     	
			       
			         
						
					}
			     
			}
			
		};
		TimerTask task2=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String[] dragonssStrings= {
						 "images//red dragon.gif","images//Dragon-18-june[1].gif","images//dragon-animated-gif-45[1].gif"		
				};
				if(secend<dragons.length) {
					int a= 0 + (int) (Math.random() * dragonssStrings.length);
					dragons[secend]=new Dragon(1366, yAxis,dragonssStrings[a]);
				
					
					}secend++;
					
			}
		};
       TimerTask task=new TimerTask() {
	
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
		
					for(int j=0;j<dragons.length;j++) {
					if(dragons[j]!=null) {
						dragons[j].setxAxis(dragons[j].getxAxis()-dragons[j].getSpeed());
					}
					
			}		               
		}
	};
       
	public DragonLevel() throws LineUnavailableException {
		windows.add(this);
		Fire mFire=new Fire();
		mLevel.setFocusable(true);
	mLevel.addKeyListener(this); 
		
			 
		 mFire.setScore(0);
		 try {
	    	 File sFile=new File("sounds//17 Fight Club.wav");
	    	 AudioInputStream audio=AudioSystem.getAudioInputStream(sFile);
	    	sclip=AudioSystem.getClip();
	    	 sclip.open(audio);
	    	 sclip.start();
	    	 
	    	
				
			
	     }catch (Exception e) {
	    	 System.out.println(e);
			// TODO: handle exception
		}
		
		
		 timer.scheduleAtFixedRate(movesword, 5000,  100);
	     timer.scheduleAtFixedRate(makesowrd, 5000, 1000);
	  
		
	timer.scheduleAtFixedRate(task2, 1000, 1500);

		timer.scheduleAtFixedRate(task,0,10);
	
	
	for (int i = 0; i < sword.length; i++) {
		sword[i]=new DarkLord(xAxis, -200, "images//mastersword.png");
		
		
	}
	
	
        for (int i = 0; i < bullets.length; i++) {
    		bullets[i]=new Bullet(1366/2-550, 40, "images//bullet1.png");
    	}
//        for (int i = 0; i < bulletsdragons.length; i++) {
//    		bulletsdragons[i]=new Bullet(500000, 40, "images//bullet1.png");
//    	}
       
	

		
		windows.setUndecorated(true);
		windows.setExtendedState(windows.MAXIMIZED_BOTH);
		windows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	 
	     
	      
     Thread t = new Thread(new Runnable() {
        
			@Override
            public void run() {
				   min--;
		            
	                while (min >= 0) { 
	                	sec=59;
	                	
	                   
	                   
	                    while (sec > -1) {
	                        repaint();
	                        try {
	                        	
	                        	
	                        	Thread.currentThread().sleep(1000);
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }sec--;
	                         
	                    }min--;
	                  
	                   }
	                 if((min==-1&&sec==-1)) {
	                	 closeing();
	              FinishedDragonLevel mFinished=new FinishedDragonLevel();
	             sclip.stop();
	          
	            }
	                
	            }});t.start();


            windows.setVisible(true);
          
           
	    
	}
	Fire mFire=new Fire();
	public void paint(Graphics g) {
if (taskstoper>1) {
	 movesword.cancel();
    makesowrd.cancel();
  
	
task2.cancel();

	task.cancel();
}
	String ss="";
	
	
		ImageIcon background=new ImageIcon("images//834.jpg");
		Font nFont=new Font("Forte", Font.PLAIN, 14);
		ss=(min+":"+sec);
		
		 g.drawImage(background.getImage(), 0, 0, null);
		 int a=10*mFire.getScore();
		g.drawString(ss, 1360/2, 50);
		AttributedString atString= new AttributedString("score :"+a);
		atString.addAttribute(TextAttribute.FONT, nFont);
		g.drawString(atString.getIterator(), 1360/2-400, 50);
		
		AttributedString btString= new AttributedString("Bullet :"+(100-count));
		btString.addAttribute(TextAttribute.FONT, nFont);
		
		g.drawString(btString.getIterator(), 1360/2+400, 50);
		for (int i = 0; i < dragons.length; i++) {
			if(dragons[i]!=null)
			dragons[i].drawBird(g);
			
			
		}

		for (int i = 0; i < bullets.length; i++) {
			bullets[i].drawBullet(g);
		}shooter.drawShooter(g);
		for (int i = 0; i < sword.length; i++) {
			if(sword[i]!=null)
			sword[i].drawSword(g);
			
			
		}
	
		windows.setVisible(true);
		windows.repaint();
	}
	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (KeyEvent.VK_ESCAPE==arg0.getKeyCode()){
//			try {
//				FileWriter mFileWriter=new FileWriter("Savepoint.txt");
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		int a=JOptionPane.showConfirmDialog(null,"Do you want exit?");
		if(a==0)
			System.exit(0);	
		}
		if (KeyEvent.VK_D==arg0.getKeyCode()) {
			
			if (shooter.getxAxis()<1366) {
				
				shooter.setxAxis(shooter.getxAxis()+10);	this.repaint();
			}
			
		
		}
		 if (KeyEvent.VK_A==arg0.getKeyCode()) {
			if (shooter.getxAxis()>0) {
				shooter.setxAxis(shooter.getxAxis()-10);
				this.repaint();
			}
			
		}
		if (arg0.getKeyCode()==KeyEvent.VK_SPACE) {
			 try {
		    	 File mFile=new File("sounds//gunshot.wav");
		    	 AudioInputStream audio=AudioSystem.getAudioInputStream(mFile);
		    	 Clip clip=AudioSystem.getClip();
		    	 clip.open(audio);
		    	 clip.start();
		     }catch (Exception e) {System.out.println(e);
				// TODO: handle exception
			}
			if (count<bullets.length) {
				bullets[count].setxAxis(shooter.getxAxis()+8);
				bullets[count].setyAxis(shooter.getyAxis());
				Fire f=new Fire(bullets[count],dragons,this); {
					
				f.start();
				count++;
				  if(count==100) { 
					sclip.stop();
					System.out.println("yes3");
					
					 swordRain.setScore(0);

					FinishedDragonLevel mFinished=new FinishedDragonLevel();
		             windows.dispose();
		           
		           
		            }
			}
			
		}
			}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

}

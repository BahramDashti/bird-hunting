import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.JobAttributes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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





public class NoobLevel extends JPanel implements KeyListener {
       JFrame windows=new JFrame();
       Shooter shooter=new Shooter(683,610,"images//revolver1.png");
       Bird[] bird=new Bird[100];
       Bullet[] bullets=new Bullet[100];
      
       NoobLevel mLevel=this;
     //  int s = 1, seconds = 90, minute = 1;
       Clip sclip;
       int secend=0;
       int xAxis=0;
       int yAxis=50;
       Timer timer=new Timer();
       int count=0;
       int min =2;
      static int stop=0;
      int sec=0;
        int sr=bullets.length;
      //  BirdFireNoob mBirdFireNoob=new BirdFireNoob();
      
        public int getSr() {
			return sr;
		}
		TimerTask task2=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String[] birdsStrings= {
						 "images//animasi-bergerak-elang-0017.gif","images//flying-bird.gif","images//BaldEagleFlyingAnimationRightSide.gif"		
				};
				if(secend<bird.length) {
					int a= 0 + (int) (Math.random() * birdsStrings.length);
					bird[secend]=new Bird(1366, yAxis,birdsStrings[a]);
				
					
					}secend++;
			}
		};
       TimerTask task=new TimerTask() {
	
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
		
					for(int j=0;j<bird.length;j++) {
					if(bird[j]!=null) {
						bird[j].setxAxis(bird[j].getxAxis()-bird[j].getSpeed());
						
//						
					}
					
			}
			

		               
		}
	};
       
	public NoobLevel() throws LineUnavailableException {
		 FireNoob mFireNoob=new FireNoob();
		 mFireNoob.setScore(0);
		 try {
	    	 File sFile=new File("sounds//vvv.wav");
	    	 AudioInputStream audio=AudioSystem.getAudioInputStream(sFile);
	    	sclip=AudioSystem.getClip();
	    	 sclip.open(audio);
	    	 sclip.start();
	    	 
	    	
				
			
	     }catch (Exception e) {System.out.println(e);
			// TODO: handle exception
		}
		
		windows.add(this);
		this.setFocusable(true);
	this.addKeyListener(this);
	
	
	
	
        for (int i = 0; i < bullets.length; i++) {
    		bullets[i]=new Bullet(1366/2-550, 40, "images//bullet1.png");
    	}
//        for (int i = 0; i < bulletsbird.length; i++) {
//    		bulletsbird[i]=new Bullet(500000, 40, "images//bullet1.png");
//    	}
	
timer.scheduleAtFixedRate(task2, 1000, 1500);

	timer.scheduleAtFixedRate(task,0,10);

		
		windows.setUndecorated(true);
		windows.setExtendedState(windows.MAXIMIZED_BOTH);
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	     
	      
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
              Finished mFinished=new Finished();
             sclip.stop();
           windows.dispose();
            }
                
            }});t.start();

            windows.setVisible(true);
          
	    
	}
	FireNoob mFireNoob=new FireNoob();
	public void paint(Graphics g) {
	String ss="";
	
		ImageIcon background=new ImageIcon("images//Background4.png");
		Font nFont=new Font("Forte", Font.PLAIN, 14);
		ss=(min+":"+sec);
		
		 g.drawImage(background.getImage(), 0, 0, null);
		 int a=10*mFireNoob.getScore();
		g.drawString(ss, 1360/2, 50);
		AttributedString atString= new AttributedString("score :"+a);
		atString.addAttribute(TextAttribute.FONT, nFont);
		
		g.drawString(atString.getIterator(), 1360/2-400, 50);
		AttributedString btString= new AttributedString("Bullet :"+(100-count));
		btString.addAttribute(TextAttribute.FONT, nFont);
		
		g.drawString(btString.getIterator(), 1360/2+400, 50);
		for (int i = 0; i < bird.length; i++) {
			if(bird[i]!=null)
			bird[i].drawBird(g);
			
			
		}
//		for (int i = 0; i < bulletsbird.length; i++) {
//			bulletsbird[i].drawBullet(g);
//		}
		for (int i = 0; i < bullets.length; i++) {
			bullets[i].drawBullet(g);
		}shooter.drawShooter(g);
		
	
		windows.setVisible(true);
		windows.repaint();
	}
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
				FireNoob f=new FireNoob(bullets[count],this,bird); {
					
				f.start();
				count++;
				  if(count==100) { 
					sclip.stop();
		              Finished mFinished=new Finished();
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

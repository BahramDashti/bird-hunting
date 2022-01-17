import java.awt.Graphics;
import java.io.File;

import javax.management.ImmutableDescriptor;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.java2d.pipe.DrawImage;

public class OpenWindow extends JPanel
{
	JFrame window=new JFrame();
public OpenWindow() {
	// TODO Auto-generated constructor stub
	//for music add delete comment 
    
	 
	window.setLocation(200,150 );
	window.setUndecorated(true);
	window.add(this);
	window.setVisible(true);
	window.setSize( 1000, 500);
	try {
		Thread.sleep(8000);
		window.dispose();
		AfterWindow mm=new AfterWindow();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public void paint(Graphics g) {
	
	ImageIcon backgrund=new ImageIcon("images//Bird Hunter 5.jpg"); 
			g.drawImage(backgrund.getImage(), 0, 0, null);
}
}

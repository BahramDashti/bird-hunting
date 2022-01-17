import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class DarkLord {
	 private int xAxis;
	 private int yAxis;
	 private int speed;
	 private String imagepath;

	public DarkLord(int xAxis, int yAxis, String imagepath) {
		Random mRandom=new Random();
		this.speed=mRandom.nextInt(6)+3;
		
		this.xAxis = mRandom.nextInt(1360);
		
		this.yAxis = yAxis;
		
		this.imagepath = imagepath;
	}
	public int getSpeed() {
		return speed;
	}
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	 
public void drawSword (Graphics g) {
	ImageIcon image = new ImageIcon((imagepath));
	g.drawImage(image.getImage(), xAxis, yAxis, null);
}
}




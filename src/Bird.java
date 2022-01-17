import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;

public class Bird {
	 private int xAxis;
	 private int yAxis;
	 private int speed;
	 private String imagepath;

	public Bird(int xAxis, int yAxis, String imagepath) {
		Random mRandom=new Random();
		this.speed=mRandom.nextInt(3)+1;
		
		this.xAxis = xAxis;
		this.yAxis = mRandom.nextInt(400)+100;
		
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
	 
public void drawBird (Graphics g) {
	ImageIcon image = new ImageIcon((imagepath));
	g.drawImage(image.getImage(), xAxis, yAxis, null);
}
}

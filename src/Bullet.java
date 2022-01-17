import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Bullet {
	 private int xAxis;
	 private int yAxis;
	 private String imagepath;
	public Bullet(int xAxis, int yAxis, String imagepath) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.imagepath = imagepath;
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
	public void drawBullet(Graphics g) {
		ImageIcon bullet= new ImageIcon(imagepath);
		g.drawImage(bullet.getImage(), xAxis, yAxis, null);
		
		
	}
}

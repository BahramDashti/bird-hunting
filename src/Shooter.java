import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Shooter {
	 private int xAxis;
	 private int yAxis;
	 private String imagepath;
	public Shooter(int xAxis, int yAxis, String imagepath) {
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
public void drawShooter(Graphics g) {
	ImageIcon shooterIcon= new ImageIcon(imagepath);
	g.drawImage(shooterIcon.getImage(), xAxis, yAxis, null);
	
	
}
}

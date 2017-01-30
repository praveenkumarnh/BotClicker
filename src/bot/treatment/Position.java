package bot.treatment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public abstract class Position {

	/*** DONNEES MEMBRES ***/
	
	private double x;
	private double y;
	
	/*** CONSTRUCTOR ***/ 
	public Position(double d, double e) {
		this.x = d;
		this.y = e;
	}
	public void go () {
		try {
			Robot souris = new Robot ();
			souris.mouseMove((int) getX(), (int) getY());
			souris.mousePress(InputEvent.BUTTON1_MASK);
			souris.mouseRelease(InputEvent.BUTTON1_MASK);
			Thread.sleep((long) (800 + (Math.random() * (1000 - 800))));
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*** GETTERS AND SETTERS ***/
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
}

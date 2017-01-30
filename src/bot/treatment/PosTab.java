package bot.treatment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class PosTab extends Position{

	public PosTab(double x, double y) {
		super(x, y);
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
	public String toString() {
		return "PosTab [getX()=" + getX() + ", getY()=" + getY() + "]";
	}
}

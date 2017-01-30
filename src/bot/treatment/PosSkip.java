package bot.treatment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class PosSkip extends Position {

	public PosSkip(double x, double y) {
		super(x, y);
	}
	public void go () {
		try {
			// Si c'est une position de passage de tour on se contente de cliquer dessus
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

}

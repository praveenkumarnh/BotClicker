package bot.treatment;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class PosMob extends Position{

	public PosMob (double d, double e) {
		super(d,e);
	}
	public void go () {
		try {
			// Si c'est une position de mob on double clic pour lancer le cbt
			Robot souris = new Robot ();
			souris.mouseMove((int) getX(), (int) getY());
			souris.mousePress(InputEvent.BUTTON1_MASK);
			souris.mouseRelease(InputEvent.BUTTON1_MASK);
			souris.mousePress(InputEvent.BUTTON1_MASK);
			souris.mouseRelease(InputEvent.BUTTON1_MASK);

			exitIfMouseMovedByUser();
			
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

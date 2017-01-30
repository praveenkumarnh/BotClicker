package bot.treatment;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Path {

	private ArrayList<Position> positions = new ArrayList <Position> ();

	/*** FUNCTIONS ***/
	public void addPos() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		positions.add(new PosMob(b.getX(), b.getY()));
	}

	public void printPositions() {
		for (Position p : positions)
			System.out.println(p);
	}
	public void follow () throws InterruptedException {
		
		for (Position p : positions) {
			p.go();
		}
	}
	/*** GETTERS SETTERS ***/

	public ArrayList<Position> getPositions() {
		return positions;
	}

}

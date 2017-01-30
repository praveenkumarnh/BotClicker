package bot.treatment;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.ArrayList;

public class Path {

	private ArrayList<Position> positions = new ArrayList<Position>();

	/*** FUNCTIONS ***/
	public void addPos(int type) {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		switch (type) {
		case 0:
			positions.add(new PosMob(b.getX(), b.getY()));
			break;
		case 1:
			positions.add(new PosSkip(b.getX(), b.getY()));
			break;
		case 2:
			positions.add(new PosTab(b.getX(), b.getY()));
			break;
		case 3:
			positions.add(new PosSpell(b.getX(), b.getY()));
			break;
		case 4:
			positions.add(new PosEndFight(b.getX(), b.getY()));
			break;
		default:
			break;

		}

	}

	public void printPositions() {
		for (Position p : positions)
			System.out.println(p);
	}

	public void follow() throws InterruptedException {

		for (Position p : positions) {
			p.go();
		}
	}

	/*** GETTERS SETTERS ***/

	public ArrayList<Position> getPositions() {
		return positions;
	}

}

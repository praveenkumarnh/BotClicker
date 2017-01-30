package bot.treatment;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class App {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		frame.setSize(500, 500);
		frame.setResizable(false);
		//

		// TEXT AREA
		JTextArea textArea = new JTextArea(
				"TEST \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		textArea.setSize(400, 400);

		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setVisible(true);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		frame.add(scroll);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Position pos1 = new PosMob(100, 100);
		System.out.println(pos1.getY());

		while (true) {
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			System.out.println(b.getX());
			System.out.println(b.getY());
		}
		/*
		 * try { Robot souris = new Robot(); for (int i = 0 ; i < 200; ++i) {
		 * for (int j = 0; j < 200; ++j) { if (souris.getPixelColor(i ,
		 * j).getRGB() == new Color (53,53,53).getRGB()) {
		 * System.out.println("ca marche"); } } } System.out.println("ok"); if
		 * (souris.getPixelColor(900 , 900).getRGB() == new Color
		 * (53,53,53).getRGB()) souris.mouseMove(650, 650); } catch
		 * (AWTException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}

}

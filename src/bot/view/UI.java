package bot.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import bot.treatment.Path;
import bot.treatment.Position;

public class UI implements KeyListener {

	private ArrayList<Path> paths = new ArrayList<Path>();
	private JTextArea textArea;
	private JFrame mainFrame;

	private static final int WINDOW_X = 1200;
	private static final int WINDOW_Y = 800;
	private static final Color COLOR_GRAY = new Color(53, 53, 53);

	private static final int POS_SELECTION_LOCKED = -1;
	private static final int MOB_POS = 0;
	private static final int PASS_POS = 1;
	private static final int TAB_POS = 2;
	private static final int SPELL_POS = 3;
	private static final int SHUT_ENDFRAME = 4;

	private int posType = -1;

	public UI() {
		mainFrame = buildFrame();

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(COLOR_GRAY);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel titlePanel = buildTitle();
		mainPanel.add(titlePanel);

		JPanel posPanel = buildAddPosPanel();

		JPanel scrollPanel = new JPanel();
		scrollPanel.add(buildPosTextField());
		scrollPanel.setBackground(COLOR_GRAY);
		mainFrame.addKeyListener(this);
		mainPanel.add(posPanel);
		mainPanel.add(buildCreateMobPathPanel());
		mainPanel.add(scrollPanel);
		mainPanel.add(buildLaunchButton());
		mainPanel.add(buildResetButton());
		mainFrame.add(mainPanel);
		mainFrame.pack();
		addPath(new Path());
	}

	public void addPath(Path p) {
		paths.add(p);
	}

	public JPanel buildTitle() {
		JPanel panel = new JPanel();
		JLabel txtInfo = new JLabel();
		txtInfo.setText("BotClicker");
		Font font = new Font("Calibri", Font.BOLD, 45);
		txtInfo.setForeground(new Color(255, 255, 255));
		txtInfo.setFont(font);

		panel.setBackground(COLOR_GRAY);

		panel.add(txtInfo);
		return panel;
	}

	public JPanel buildAddPosPanel() {
		JPanel panel = new JPanel();
		JLabel txtInfo = new JLabel();
		// panel.setLayout(new BoxLayout (panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(Color.WHITE);

		Font font = new Font("Calibri", Font.BOLD, 19);
		txtInfo.setForeground(COLOR_GRAY);
		txtInfo.setFont(font);
		txtInfo.setText("Appuyez sur le bouton 'Capturer'. ");
		panel.add(txtInfo);

		JLabel txtInfo2 = new JLabel();
		txtInfo2.setForeground(COLOR_GRAY);
		txtInfo2.setFont(font);
		txtInfo2.setText("Positionez votre souris sur les �l�ments � ajouter puis appuyez sur 'o'. ");
		panel.add(txtInfo2);

		JLabel txtInfo3 = new JLabel();
		txtInfo3.setForeground(COLOR_GRAY);
		txtInfo3.setFont(font);
		txtInfo3.setText(
				"Une fois tout les �l�ments s�lectionn�s, appuyez sur 'z' pour faire revenir la f�netre � la normale. ");
		panel.add(txtInfo3);

		JLabel txtInfo4 = new JLabel();
		txtInfo4.setForeground(COLOR_GRAY);
		txtInfo4.setFont(font);
		txtInfo4.setText("Lancez le bot et enjoy :)");
		panel.add(txtInfo4);

		return panel;

	}

	public JFrame buildFrame() {
		JFrame frame = new JFrame("Maltesere");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(WINDOW_X, WINDOW_Y));
		return frame;
	}

	public JScrollPane buildPosTextField() {
		textArea = new JTextArea("TEST");
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setVisible(true);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(300, 300));
		return scroll;
	}

	public void catchResizing() {
		mainFrame.setPreferredSize(new Dimension(50, 50));
		mainFrame.setSize(new Dimension(50, 50));
		mainFrame.requestFocus();
	}

	public JPanel buildResetButton() {
		JButton launch = new JButton("Reinitialiser le parcours");
		launch.setBackground(new Color(255, 255, 255));
		launch.setBorder(null);
		launch.setPreferredSize(new Dimension(150, 50));
		launch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				paths.get(0).getPositions().removeAll(paths.get(0).getPositions());
				refreshTextPos();
				mainFrame.requestFocus();

			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(COLOR_GRAY);
		panel.add(launch);
		return panel;
	}

	public JPanel buildLaunchButton() {
		JButton launch = new JButton("Lancer le bot");
		launch.setBackground(new Color(255, 255, 255));
		launch.setBorder(null);
		launch.setPreferredSize(new Dimension(100, 50));
		launch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					mainFrame.setPreferredSize(new Dimension(50, 50));
					mainFrame.setSize(new Dimension(50, 50));
					paths.get(0).follow();
					mainFrame.setPreferredSize(new Dimension(WINDOW_X, WINDOW_Y));
					mainFrame.setSize(new Dimension(WINDOW_X, WINDOW_Y));
					mainFrame.requestFocus();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mainFrame.requestFocus();

			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(COLOR_GRAY);
		panel.add(launch);
		return panel;

	}

	public JPanel buildCreateMobPathPanel() {
		
		JButton addPosMob = new JButton("Position du mob");
		addPosMob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				posType = MOB_POS;
				catchResizing();
			}
		});
		addPosMob.setBackground(Color.WHITE);
		
		JButton addPassTurn = new JButton("Position du bouton passer tour");
		addPassTurn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				posType = PASS_POS;
				catchResizing();
			}
		});
		addPassTurn.setBackground(Color.WHITE);
		
		JButton addChangeTab = new JButton("Position du 1er onglet noemu");
		addChangeTab.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				posType = TAB_POS;
				catchResizing();
			}
		});
		addChangeTab.setBackground(Color.WHITE);
		
		JButton addSpell = new JButton("Position du chati et de la disso");
		addSpell.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				posType = SPELL_POS;
				catchResizing();
			}
		});
		addSpell.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(COLOR_GRAY);
		panel.setLayout(new FlowLayout());
		panel.add(addPosMob);
		panel.add(addPassTurn);
		panel.add(addChangeTab);
		panel.add(addSpell);
		return panel;

	}

	public void refreshTextPos() {
		textArea.setText(null);
		for (Position p : paths.get(0).getPositions()) {
			textArea.append(p.toString() + '\n');
		}

	}

	/*** LISTENER ***/
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			mainFrame.setPreferredSize(new Dimension(WINDOW_X, WINDOW_Y));
			mainFrame.setSize(new Dimension(WINDOW_X, WINDOW_Y));
			mainFrame.requestFocus();
			posType = POS_SELECTION_LOCKED;
		}
		if (e.getKeyCode() == KeyEvent.VK_O && posType != POS_SELECTION_LOCKED) {
			paths.get(0).addPos(posType);
			refreshTextPos();

		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

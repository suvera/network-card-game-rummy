/**
 * @author nramanarayana
 * @revision Aug 3, 2008
 * @fileid GamePanel.java
 * 
 */
package maker.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import maker.Card;

/**
 * class GamePanel
 * 
 */
public class GamePanel extends JFrame {

	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008080314;

	/*
	 * Screen Resolution Constants
	 */
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screensize = toolkit.getScreenSize();
	private int width = screensize.width, height = screensize.height;

	/**
	 * Container container
	 */
	private Container container;

	public PlaySetPanel playset;
	public PackedSetPanel pocket;
	public TopButtonPanel toppane;
	public SharedCardPanel shared;
	public StatusPanel statuspane;

	/**
	 * 
	 */
	public GamePanel() {
		super();
		this.setName("Game Panel");

		playset = new PlaySetPanel();
		pocket = new PackedSetPanel();
		toppane = new TopButtonPanel();
		shared = new SharedCardPanel();
		statuspane = new StatusPanel();
	}

	/**
	 * @throws Exception
	 */
	public void displayWindow() throws Exception {
		// Create Main Frame
		JFrame.setDefaultLookAndFeelDecorated(false);

		this.setVisible(true);
		this.container = this.getContentPane();
		this.container.setLayout(new BorderLayout());

		// this.test();
		container.add(playset, BorderLayout.CENTER);
		container.add(toppane, BorderLayout.PAGE_START);
		container.add(statuspane, BorderLayout.PAGE_END);
		container.add(pocket, BorderLayout.LINE_START);
		container.add(shared, BorderLayout.LINE_END);

		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(container,
						"Are you sure you want to quit Game ?", "Quit Game",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					System.exit(0);
				}
			}
		});
		this.setSize(3 * width / 4, 3 * height / 4);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Rummy - Card Game");
	}

	/**
	 * @param cs
	 */
	public void setPlaySet(Card[] cs) {
		playset.showPanel(cs);
	}

	/**
	 * @param cs
	 */
	public void setPackedSet(Card[] cs) {
		pocket.showPanel(cs);
	}

	/**
	 * @param msg
	 */
	public void showStatus(String msg) {
		toppane.setStatusLabel(msg);
	}
	
	/**
	 * @param msg
	 */
	public void showLog(String msg) {
		statuspane.showStatus(msg);
	}

	/**
	 * cleanup to start a new game
	 */
	public void cleanup() {
		playset.cleanup();
		pocket.cleanup();
		toppane.cleanup();
		shared.cleanup();
		statuspane.cleanup();
	}

	/**
	 * 
	 */
	public void test() {
		/*
		 * Maker m = new Maker(3); //Card[][] disp = m.getDispatched(); playset =
		 * new PlaySetPanel(m.getDispatchedByPlayer(0)); pocket = new
		 * PackedSetPanel(m.getPacked()); toppane = new TopButtonPanel(); shared =
		 * new SharedCardPanel();
		 * 
		 * container.add(playset, BorderLayout.CENTER);
		 * 
		 * JLabel empty = new JLabel(" Test Label "); container.add(toppane,
		 * BorderLayout.PAGE_START); container.add(shared,
		 * BorderLayout.PAGE_END); container.add(pocket,
		 * BorderLayout.LINE_START); container.add(empty,
		 * BorderLayout.LINE_END);
		 */
	}

}

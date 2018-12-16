/**
 * @author nramanarayana
 * @revision Sep 4, 2008
 * @fileid GameDonePanel.java
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

import rummy.Rummy;

import maker.Card;

/**
 * class GameDonePanel
 * 
 */
public class GameDoneWindow extends JFrame {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008090419;
	
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

	/**
	 * @param arg0
	 */
	public GameDoneWindow() {
		super();
		this.setName("Game Done Panel");
		playset = new PlaySetPanel();
	}
	
	/**
	 * 
	 */
	public void display(Card[] cs, String title) {
		// Create Main Frame
		JFrame.setDefaultLookAndFeelDecorated(false);
			this.setResizable(false);
		
		playset.showPanel(cs);
		
		this.setVisible(true);
		this.container = this.getContentPane();
		this.container.setLayout(new BorderLayout());
		container.add(playset, BorderLayout.CENTER);
		
		this.setSize(3 * width / 6, 3 * height / 6);
		this.setLocationRelativeTo(Rummy.gamepanel);
		this.setVisible(true);
		this.setTitle(title);
		
		this.setAlwaysOnTop(true);
		this.setFocusable(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Rummy.gamepanel.setEnabled(true);
			}
		});
	}

}

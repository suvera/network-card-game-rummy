/**
 * @author nramanarayana
 * @revision Sep 4, 2008
 * @fileid Alert.java
 * 
 */
package util;

import javax.swing.JOptionPane;

import rummy.Rummy;

/**
 * class Alert
 * 
 */
public class Alert extends JOptionPane {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008090411;

	/**
	 * 
	 */
	public Alert() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param msg
	 * @param title
	 */
	public static void error(String msg, String title) {
		showMessageDialog(Rummy.gamepanel, msg, title, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * @param msg
	 * @param title
	 */
	public static void warning(String msg, String title) {
		showMessageDialog(Rummy.gamepanel, msg, title, JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * @param msg
	 * @param title
	 */
	public static void plain(String msg, String title) {
		showMessageDialog(Rummy.gamepanel, msg, title, JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * @param msg
	 * @param title
	 */
	public static void info(String msg, String title) {
		showMessageDialog(Rummy.gamepanel, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * @param msg
	 * @param title
	 */
	public static void question(String msg, String title) {
		showMessageDialog(Rummy.gamepanel, msg, title, JOptionPane.QUESTION_MESSAGE);
	}
}

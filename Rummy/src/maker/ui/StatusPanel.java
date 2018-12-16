/**
 * @author nramanarayana
 * @revision Sep 7, 2008
 * @fileid StatusPanel.java
 * 
 */
package maker.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * class StatusPanel
 * 
 */
public class StatusPanel extends JPanel {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008090712;
	
	private JEditorPane status;
	private SimpleAttributeSet styles;
	private JScrollPane editorScrollPane;

	/**
	 * constructor
	 */
	public StatusPanel() {
		super(new BorderLayout());
		
		status = new JEditorPane("text/html", "<html></html>");
		status.setContentType("text/html");
		
		status.setEditable(false);
		editorScrollPane = new JScrollPane(status);
		//editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setPreferredSize(new Dimension(300, 80));
		editorScrollPane.setMinimumSize(new Dimension(10, 10));
		editorScrollPane.setAutoscrolls(true);
		
		styles = new SimpleAttributeSet();
		
		this.add(editorScrollPane, BorderLayout.PAGE_START);
	}
	
	/**
	 * add status
	 */
	public void showStatus(String DAT) {
		try {
			StyleConstants.setFontFamily(styles, "courier new");
			StyleConstants.setForeground(styles, new Color(0,0,255));
			StyleConstants.setItalic(styles, true);
			
			status.getDocument().insertString(status.getDocument().getLength(), "" + DAT + "\n", styles);
			status.setCaretPosition(status.getDocument().getLength());
		}
		catch (BadLocationException ex) {}
	}
	
	/**
	 * cleanup to start a new game
	 */
	public void cleanup() {
		this.status.setText("");
	}
}

/**
 * @author nramanarayana
 * @revision Aug 23, 2008
 * @fileid SharedCardPanel.java
 * 
 */
package maker.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

/**
 * class SharedCardPanel
 * 
 */
public class TopButtonPanel extends PanelBase implements ActionListener {
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008082311;
	
	//private 
	private JButton threw;
	private JButton done;
	private JLabel status;
		
	/**
	 * @param
	 */
	public TopButtonPanel() {
		super(new SpringLayout());
		this.setName("Top Button Panel");
		
		this.threw = new JButton("Throw");
		this.done = new JButton("Game Done");
		this.status = new JLabel("Hey, have a great game!");
		
		this.threw.setActionCommand("threw");
		this.done.setActionCommand("done");
		this.done.setEnabled(false);
		//this.threw.setEnabled(false);
		
		this.add(this.status);
		this.add(this.threw);
		this.add(this.done);
		
		SpringUtilities.makeCompactGrid(this,
                1, this.getComponentCount(), //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad
		
		threw.addActionListener(this);
		done.addActionListener(this);
	}
	
	/**
	 * cleanup to start a new game
	 */
	public void cleanup() {
		this.status.setText("Starting new game");
		this.done.setEnabled(false);
		this.threw.setEnabled(true);
	}
	
	/**
	 * @param msg
	 */
	public void setStatusLabel(String msg) {
		this.status.setText(msg);
	}
	
	/**
	 * @param flag
	 */
	public void setEnableDoneButton(boolean flag) {
		this.done.setEnabled(flag);
	}
	
	/**
	 * @param flag
	 */
	public void setEnableThrowButton(boolean flag) {
		this.threw.setEnabled(flag);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e != null && e.getActionCommand().equals("threw")) {
			InterfaceUtil.throwACard();
		} else if( e != null && e.getActionCommand().equals("done")) {
			
		} else {
			
		}
	}

}

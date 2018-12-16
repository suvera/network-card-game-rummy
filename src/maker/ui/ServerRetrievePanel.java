/**
 * @author nramanarayana
 * @revision Aug 3, 2008
 * @fileid ServerRetrievePanel.java
 * 
 */
package maker.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import rummy.Rummy;
import util.Util;

/**
 * class ServerRetrievePanel
 * 
 */
public class ServerRetrievePanel extends JFrame {
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008080313;
	
	/*
	 * Screen Resolution Constants
	
	 */
	/*
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screensize = toolkit.getScreenSize();
	private int width = screensize.width, height = screensize.height;
	*/
	/**
	 * Container container
	 */
	private Container container;
	
	private JButton join;
	private JButton startServer;
	private JButton startGame;
	private JComboBox serverList;
	private JEditorPane status;
	private SimpleAttributeSet styles;
	private JScrollPane editorScrollPane;
	
	private String[] serverListArr = {"-- Select --"};
	

	/**
	 * @throws HeadlessException
	 */
	public ServerRetrievePanel() throws HeadlessException {
		super();
		
		join = new JButton("Join");
		join.setActionCommand("join");
		
		startServer = new JButton("Start Server");
		startServer.setActionCommand("startserver");
		
		startGame = new JButton("Start Game");
		startGame.setActionCommand("startgame");
		
		serverList = new JComboBox(serverListArr);
		
		status = new JEditorPane("text/html", "<html></html>");
		status.setContentType("text/html");
		
		status.setEditable(false);
		editorScrollPane = new JScrollPane(status);
		editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setPreferredSize(new Dimension(300, 60));
		editorScrollPane.setMinimumSize(new Dimension(10, 10));
		
		styles = new SimpleAttributeSet();
				
		//Set Enabled
		startGame.setEnabled(false);
		join.setEnabled(false);
		
		//Add Action Listeners
		serverList.addActionListener(new ComboListener());
		join.addActionListener(new ButtonListener());
		startServer.addActionListener(new ButtonListener());
		startGame.addActionListener(new ButtonListener());
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
	 * add a new server . i.e to Combobox
	 */
	public void includeServer(String ns) {
		serverList.addItem(ns);
	}
	
	/**
	 * remove an item from Combobox
	 */
	public void excludeServer(String ns) {
		serverList.removeItem(ns);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Window#dispose()
	 */
	public void dispose() {
		Rummy.isGameStarted = true;
		super.dispose();
	}
	
	/**
	 * @throws Exception
	 */
	public void displayWindow() throws Exception {
		// Create Main Frame
		JFrame.setDefaultLookAndFeelDecorated(false);
		this.setVisible(true);
		container = this.getContentPane();
		
		GroupLayout layout = new GroupLayout(container);
		container.setLayout(layout);
		
		JLabel or = new JLabel("OR");
		JLabel empty = new JLabel("");
		JLabel sel1 = new JLabel("Select a Server from the list");
		JLabel sel2 = new JLabel("Start server, so that others can join");
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
		   layout.createSequentialGroup()
		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			      .addComponent(sel1)
			      .addComponent(empty)
			      .addComponent(sel2)
			      .addComponent(editorScrollPane)
			   )
		   	  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			      .addComponent(serverList)
			      .addComponent(or)
			      .addComponent(startServer)
			      .addComponent(empty)
			   )
			   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				   .addComponent(join)
				   .addComponent(empty)
				   .addComponent(empty)
			       .addComponent(startGame)
			   )
		);
		
		layout.setVerticalGroup(
		   layout.createSequentialGroup()
		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    	   .addComponent(sel1)
		    	   .addComponent(serverList)
		           .addComponent(join)
		      )
		      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		  .addComponent(empty)
		    		  .addComponent(or)
		              .addComponent(empty)
		      )
		      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    		  .addComponent(sel2)
		    		  .addComponent(startServer)
		              .addComponent(empty)
		      )
		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		           .addComponent(editorScrollPane)
		           .addComponent(empty)
		           .addComponent(startGame)
		      )
		);

		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(container,
						"Are you sure you want to quit Game ?",
						"Quit Game", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					System.exit(0);
				}
			}
		});
		this.setSize(550, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Rummy - Card Game (Getting server list)");
	}
	
	//Inner class
	class ComboListener implements ActionListener {
		public ComboListener() {
		}
		
		public void actionPerformed(ActionEvent e) {
	        JComboBox cb = (JComboBox)e.getSource();
	        String name = (String)cb.getSelectedItem();
	        if(name.equals("-- Select --")) {
	        	join.setEnabled(false);
	        	//startGame.setEnabled(true);
	        	startServer.setEnabled(true);
	        } else {
	        	join.setEnabled(true);
	        	startGame.setEnabled(false);
	        	startServer.setEnabled(false);
	        }
	    }
	}
	
	//Inner class
	class ButtonListener implements ActionListener {
		
		public ButtonListener() {
		}
		
		public void actionPerformed(ActionEvent e) {
			JButton cb = (JButton)e.getSource();
	        String name = cb.getActionCommand();
	        if(name.equals("join")) {
	        	Rummy.IamJoinee = true;
	        	join.setText("Please wait...");
	        } else if(name.equals("startserver")) {
	        	try {
		        	//startServer.setText("Stop");
		        	//startServer.setActionCommand("stop");
	        		Rummy.isServerStarted = true;
	        		Rummy.config.setServer(true);
	        		Rummy.config.setServer(Rummy.config.getLocalip());
		        		
	        		startServer.setEnabled(false);
	        		serverList.setEnabled(false);
		        	startGame.setEnabled(true);
	        	} catch(Exception ex) {
	        		Util.de("Unable process your request:" + ex);
	        	}
	        } else if(name.equals("stop")) {
	        	try {
		        	startServer.setText("Start Server");
		        	startServer.setActionCommand("startserver");
		        	startGame.setEnabled(false);
		        	Rummy.isServerStarted = false;
	        	} catch(Exception ex) {
	        		Util.de("Unable process your request:" + ex);
	        	}
	        } else if(name.equals("startgame")) {
	        	Rummy.serverpanel.dispose();
	        	Rummy.showGamePanel();
		        Rummy.config.setJoniees(Rummy.server.getJoineeString());
	        	
	        	Rummy.newGame(false);
	        }
	    }
	}
}

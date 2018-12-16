/**
 * @author nramanarayana
 * @revision Aug 15, 2008
 * @fileid PackedSetPanel.java
 * 
 */
package maker.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.BorderFactory;

import rummy.Rummy;

import maker.Card;
import maker.CardUI;

/**
 * class PackedSetPanel
 * 
 */
public class PackedSetPanel extends PanelBase {
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008081511;
	
	/**
	 * Stack cards
	 */
	public Stack<CardUI> stack;
	
	/**
	 * CardUI current
	 */
	public CardUI current;
	
	static int left = 30;
	static int top = 30;
	
	/**
	 * constructor
	 */
	public PackedSetPanel() {
		//Set the default properties
		super(null); //new BorderLayout()
		this.setName("Packed Cards Panel");
		this.setPreferredSize(new Dimension(120, 500));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.stack = new Stack<CardUI>();
	}
	
	/**
	 * @param cs
	 */
	public void showPanel(Card[] cs) {
		//Add cards to Panel
		for(int i=cs.length-1; i>=0; i--) {
			CardUI tmp = cs[i].getUI();
			
			tmp.turnIt();
			tmp.setBounds(left, top, CardUI.width, CardUI.height);
			tmp.pos = i;
			
			this.add(tmp);
			stack.push(tmp);
		}
	}
	
	/**
	 * cleanup to start a new game
	 */
	public void cleanup() {
		this.stack.removeAllElements();
		this.removeAll();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		if(this.current != null && Rummy.config.isMyTurn()) {
			this.current.turnIt();
			InterfaceUtil.selectCardFromPocket();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		this.current = this.getCardObjectAt(e.getX(), e.getY());
	}
		
	/**
	 * @return
	 */
	public CardUI popCard() {
		CardUI card = this.stack.pop();
		
		this.remove(card); //this.current
		return card;
	}
}

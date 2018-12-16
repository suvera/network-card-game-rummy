/**
 * @author nramanarayana
 * @revision Aug 23, 2008
 * @fileid SharedCardPanel.java
 * 
 */
package maker.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Stack;

import javax.swing.BorderFactory;

import util.Util;

import maker.CardUI;

/**
 * class SharedCardPanel
 * 
 */
public class SharedCardPanel extends PanelBase {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008082312;
	
	/**
	 * Stack cards
	 */
	public Stack<CardUI> stack;
	
	/**
	 * CardUI top
	 */
	public CardUI top;
	
	/**
	 * Random generator
	 */
	private Random generator;
	
	/**
	 * @param arg0
	 */
	public SharedCardPanel() {
		super(null);
		this.setName("Shared Crads Panel");
		this.setPreferredSize(new Dimension(150, 500));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.stack = new Stack<CardUI>();
		this.generator = new Random( 618 );
	}
	
	/**
	 * cleanup to start a new game
	 */
	public void cleanup() {
		this.stack.removeAllElements();
		this.removeAll();
	}
	
	/**
	 * @return CardUI
	 */
	public CardUI popCard() throws Exception {
		if(this.top != null ) {
			this.top = null;
			return this.stack.pop();
		}
		
		throw new Exception("Top Shared card is empty");
	}
	
	/**
	 * @return CardUI
	 */
	public CardUI justPopACard() {
		try {
			this.top = null;
			return this.stack.pop();
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * @return CardUI
	 */
	public void puchCard(CardUI card) {
		this.stack.push(card);
				
		int x = generator.nextInt(40) + 10;
		int y = generator.nextInt(150) + 10;
		
		card.setBounds(x, y, CardUI.width, CardUI.height);
		this.add(card);
		this.setComponentZOrder(card, 0);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		this.top = this.getCardObjectAt(e.getX(), e.getY());
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		if(this.top != null) {
			InterfaceUtil.selectCardFromShared();
		}
	}
	
	/**
	 * @return CardUI
	 */
	public CardUI getCardObjectAt(int x, int y) {
		Component comp = null;
		try {
			comp = this.getComponentAt(x, y);
		} catch(Exception ex) {
		}
		
		if(comp != null && comp.getName().equals("Card")) {
			int compCutX = comp.getX();
			int compCutY = comp.getY();
			
			CardUI tmp = (CardUI) comp;
						
			tmp.mX = compCutX - x;
			tmp.mY = compCutY - y;
			
			try {
				if(tmp == this.stack.peek())
					return tmp;
			} catch(Exception e) {
				Util.de("" + e);
			}
		}
		
		return null;
	}

}

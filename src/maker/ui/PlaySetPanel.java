/**
 * @author nramanarayana
 * @revision Aug 6, 2008
 * @fileid PlaySetPanel.java
 * 
 */
package maker.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import maker.Card;
import maker.CardUI;

/**
 * class PlaySetPanel
 * 
 */
public class PlaySetPanel extends PanelBase {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008080609;
	
	static int gap = 30;
	static int left = 100;
	static int top = 100;
	
	/**
	 * Card[] cards
	 */
	public Card[] cards;
	
	/**
	 * CardUI current
	 */
	public CardUI current = null;
	
	/**
	 * JButton threw
	 */
	private JLabel status;
	private CardUI curcard;
	
	
	/**
	 * constrcutor
	 */
	public PlaySetPanel() {
		super(null);
		this.setName("13 Cards Panel");
		this.setPreferredSize(new Dimension(500, 180));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.status = new JLabel("Current Card");
		this.curcard = new CardUI("images/0l.png");
		
		this.setOpaque(false);
	}

	/**
	 * constrcutor
	 * @param cs
	 */
	public void showPanel(Card[] cs) {
		//Set the default properties	
		this.cards = cs;
		
		//Add 13 cards to Panel
		for(int i=this.cards.length-1; i>=0; i--) {
			CardUI tmp = this.cards[i].getUI();
			
			tmp.setBounds(left+(i * gap), top, CardUI.width, CardUI.height);
			tmp.pos = i;
			
			this.add(tmp);
		}
		
		this.add(this.status);
		this.add(this.curcard);

		this.curcard.setBounds(2, 2, CardUI.width, CardUI.height);
		this.status.setBounds(CardUI.width + 10, 2, 100, 25);
	}
	
	/**
	 * cleanup to start a new game
	 */
	public void cleanup() {
		this.cards = null;
		this.removeAll();
	}
	
	/**
	 * 
	 */
	public void showCurrent() {
		try {
			if(this.current == null) {
				this.curcard.setCardImage("images/0l.png");
			} else {
				this.current.setBounds(this.current.getX()+1, this.current.getY(), CardUI.width, CardUI.height);
				this.current.setBounds(this.current.getX()-1, this.current.getY(), CardUI.width, CardUI.height);
			}
		} catch(Exception e) {
		}
	}
			
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		if(this.current != null) {
			this.showCurrent();
		}
		saySomething(e, "mouseClicked");

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		this.current = this.getCardObjectAt(e.getX(), e.getY());
		
		if(this.current != null) {
			this.curcard.setCardImage(this.current.getImagePath());
		}
		saySomething(e, "mousePressed");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
		
		if(this.current != null && this.isAllowedToMove(this.current)) {
			//Util.de("Pos: " + this.current.pos);
			this.current.setBounds(e.getX()+this.current.mX, e.getY()+this.current.mY, CardUI.width, CardUI.height);
		}
		saySomething(e, "mouseDragged");
	}
	
	/**
	 * @param card
	 * @return
	 */
	public boolean isAllowedToMove(CardUI card) {
		Rectangle r = this.getBounds();
		Rectangle cr = card.getBounds();
		
		//Util.de("(x, y, w, h): (" + r.x + ", "+ r.y + ", "+ r.width + ", "+ r.height + ")");
		//Util.de("(cx, cy, cw, ch): (" + cr.x + ", "+ cr.y + ", "+ cr.width + ", "+ cr.height + ")");
		if(r.x - 80 >= cr.x) {
			card.setBounds(cr.x+30, cr.y, CardUI.width, CardUI.height);
			return false;
		}
		
		if(r.y - 10 >= cr.y) {
			card.setBounds(cr.x, cr.y+10, CardUI.width, CardUI.height);
			return false;
		}
		
		if(r.width - CardUI.width <= cr.x) {
			card.setBounds(cr.x-1, cr.y, CardUI.width, CardUI.height);
			return false;
		}
		
		if(r.height - CardUI.height <= cr.y) {
			card.setBounds(cr.x, cr.y-1, CardUI.width, CardUI.height);
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param tmp
	 */
	public void pushCard(CardUI tmp) {
		
		tmp.setBounds(left + 50, 50, CardUI.width, CardUI.height);
		tmp.pos = this.cards.length;
		
		this.add(tmp);
		this.setComponentZOrder(tmp, 0);
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public CardUI popSelectedCard() throws Exception {
		if(this.current == null)
			throw new Exception("Current card is empty");
		
		CardUI tmp = this.current;
		
		//this.remove(this.current);
		this.current = null;
		this.curcard.setCardImage("images/0l.png");
		
		return tmp;
	}

}

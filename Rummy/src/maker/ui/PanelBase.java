/**
 * @author nramanarayana
 * @revision Aug 23, 2008
 * @fileid PanelBase.java
 * 
 */
package maker.ui;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import maker.CardUI;

/**
 * class PanelBase
 * 
 */
public class PanelBase extends JPanel implements MouseListener, MouseMotionListener {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008082309;

	/**
	 * constructor
	 * @param arg0
	 */
	public PanelBase(LayoutManager arg0) {
		super(arg0);
		this.setName("Panel Base");
		
		//Add Listeners
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	/**
	 * say something for mouse
	 */
	public void saySomething(MouseEvent e, String m) {
		/*
		Component comp = null;
		try {
			comp = this.getComponentAt(e.getX(), e.getY());
		} catch(Exception ex) {
		}
		if(comp != null) {
			Util.de(m + ": " + comp.getName());
		} else
			Util.de(m);
		*/
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
			
			if(tmp.pos == -1)
				return null;
			
			tmp.mX = compCutX - x;
			tmp.mY = compCutY - y;
			
			this.setComponentZOrder(tmp, 0);
			
			return tmp;
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent arg0) {
		saySomething(arg0, "PanelBase: mouse Exited");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent arg0) {
		saySomething(arg0, "PanelBase: mouseEntered");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent arg0) {
		saySomething(arg0, "PanelBase: mouseExited");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent arg0) {
		saySomething(arg0, "PanelBase: mousePressed");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent arg0) {
		saySomething(arg0, "PanelBase: mouseReleased");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent arg0) {
		saySomething(arg0, "PanelBase: mouseDragged");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent arg0) {
		saySomething(arg0, "PanelBase: mouseMoved");
	}

}

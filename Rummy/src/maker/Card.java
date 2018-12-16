/**
 * @author nramanarayana
 * @revision Jul 18, 2008
 * @fileid Card.java
 * 
 */
package maker;

import java.io.Serializable;

/**
 * class Card
 * 
 */
public class Card implements Serializable {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008091410;
	
	/**
	 * char sign
	 */
	public String sign;
	
	/**
	 * integer type
	 * 	0 - Diamond
	 *  1 - Heart
	 *  2 - Spade
	 *  3 - club
	 *  4 - Joker
	 */
	public int type;
	
	
	/**
	 * integer color
	 * 	0 - blue
	 * 	1 - red
	 */
	public int color;
	
	/**
	 * String image
	 */
	public String image;
	
	/**
	 * String backimage
	 */
	public String backimage;
	
	/**
	 * JPanel container
	 */
	protected CardUI ui;
		

	/**
	 * Constructor
	 */
	public Card(String s, int t, int c) {
		this.sign = s;
		this.type = t;
		this.color = c;
		
		this.image = "images/card" + this.type + this.sign + ".png";
		this.backimage = "images/" + this.color + "l.png";
		
		this.ui = new CardUI(this.image);
		this.ui.setBackimage(this.backimage);
		//this.ui.setToolTipText(this.sign + " Card");
	}
	
	/**
	 * @param vars
	 * @return
	 */
	public static Card getCard(String vars) {
		String[] info = vars.split("-");
		return new Card(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]) );
	}
	
	//Testing...
	public void test() {
		System.out.println("Testing....");
	}
	
	/**
	 * @return JLabel
	 */
	public CardUI getUI() {
		return this.ui;
	}
	
	/**
	 * @return
	 */
	public void setPos(int p) {
		this.ui.pos = p;
	}
	
	/**
	 * @return
	 */
	public int getPos() {
		return this.ui.pos;
	}
	
	/**
	 * @return
	 */
	public String getBeanString() {
		return this.sign + "-" + this.type + "-" + this.color;
	}

}
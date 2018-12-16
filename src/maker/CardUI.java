/**
 * @author nramanarayana
 * @revision Aug 6, 2008
 * @fileid CardUI.java
 * 
 */
package maker;

import java.awt.BorderLayout;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Util;

/**
 * class CardUI
 * 
 */
public class CardUI extends JPanel  implements Serializable {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008080611;
	
	// Width Height
	public static int width = 72;
	public static int height = 97;
	
	//Mouse Pointer values
	public int mX;
	public int mY;
	
	/**
	 * int pos
	 */
	public int pos = -1;
	
	/**
	 * String Image
	 */
	private String image;
	
	/**
	 * String back side image
	 */
	private String backimage;
	
	private JLabel holder;

	/**
	 * Constructor
	 */
	public CardUI(String img) {
		
		super(new BorderLayout());
		this.setName("Card");
		
		this.image = img;
		this.holder = new JLabel();
		
		this.add(this.holder, BorderLayout.CENTER);
		this.setCardImage(this.image);
	}
	
	/**
	 * @param bimg
	 */
	public void setBackimage(String bimg) {
		this.backimage = bimg;
	}
	
	/**
	 * get Image path
	 */
	public void turnIt() {
		this.setCardImage(this.backimage);
		
		String tmp = this.image;
		this.image = this.backimage;
		this.backimage = tmp;
	}
	
	/**
	 * 
	 */
	public void setCardImage(String img) {
		try {
			this.holder.setIcon(Util.createImageIcon(img));
		} catch(Exception e) { 
    		Util.de(this.image + "\n" + e);
    	}
	}
	
	/**
	 * get Image path
	 */
	public String getImagePath() {
		return this.image;
	}

}

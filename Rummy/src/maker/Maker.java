/**
 * @author nramanarayana
 * @revision Aug 3, 2008
 * @fileid Maker.java
 * 
 */
package maker;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

/**
 * class Maker
 * 
 */
public class Maker {
	
	/**
	 * integer color
	 * 	0 - blue
	 * 	1 - red
	 */
	public int[] colors = {0, 1};
	
	/**
	 * Card[] cards
	 */
	protected CardSet[] set;
	
	/**
	 * Card[] cards
	 */
	protected Card[] cards;
	
	/**
	 * int numOfsets
	 */
	public int numOfsets;
	public int numOfcards;
	
	/**
	 * Hashtable<Integer,Integer> h
	 */
	private Hashtable<Integer, Integer> h;
	
	/**
	 * int dispatch_num
	 */
	public static int dispatch_count = 13;
	
	private Card[][] dispatched;
	private Card[] packed;

	/**
	 * 
	 */
	public Maker(int num) {
		this.numOfsets = num;
		this.numOfcards = num*CardSet.total;
		this.set = new CardSet[num];
		h = new Hashtable<Integer, Integer>();
		
		for(int i=0; i<num; i++) {
			int clr = i % colors.length;
			this.set[i] = new CardSet(clr);
		}
		
		this.cards = new Card[this.numOfcards];
		
		this.randomize();
		this.dispatch();
	}
	
	/**
	 * @return
	 */
	public Card[][] getDispatched2() {
		return this.dispatched;
	}
	
	/**
	 * @return
	 */
	public String[][] getDispatchedString() {
		String[][] tmp = new String[this.numOfsets][dispatch_count];
		for(int i=0; i<this.dispatched.length; i++) {
			for(int j=0; j<this.dispatched[i].length; j++) {
				tmp[i][j] = this.dispatched[i][j].getBeanString();
			}
		}
		
		return tmp;
	}
	
	/**
	 * @return
	 */
	public Card[] getDispatchedByPlayer(int i) {
		return this.dispatched[i];
	}
	
	/**
	 * @return
	 */
	public String[] getDispatchedByPlayerString(int i) {
		String[] tmp = new String[dispatch_count];
		for(int j=0; j<this.dispatched[i].length; j++) {
			tmp[j] = this.dispatched[i][j].getBeanString();
		}
		
		return tmp;
	}
	
	/**
	 * @return
	 */
	public Card[] getPacked() {
		return this.packed;
	}
	
	/**
	 * @return
	 */
	public String[] getPackedString() {
		String[] tmp = new String[this.packed.length];
		
		for(int j=0; j<this.packed.length; j++) {
			tmp[j] = this.packed[j].getBeanString();
		}
		
		return tmp;
	}
	
	/**
	 * 
	 */
	public void randomize() {
		Random rand = new Random();
		
		for(int i=0; i<this.numOfcards; i++) {
			//Integer key = new Integer(i);
			//Integer val = new Integer(rand.nextInt(this.numOfcards));
			int val = rand.nextInt(this.numOfcards);
			
			while(h.containsValue(val)) {
				val = new Integer(rand.nextInt(this.numOfcards));
			}
			h.put(i, val);
		}
		
		int i = 0;
		int s = 0;
		int k = 0;
		for (Enumeration<Integer> e = h.elements(); e.hasMoreElements();) {
		    //System.out.println(""+e.nextElement());
			k = (int) e.nextElement();
			s = (int) (k / CardSet.total);
			this.cards[i++] = this.set[s].getCard( k-(s*CardSet.total) );
		}
	}
	
	/**
	 * 
	 */
	public void dispatch() {
		int pack = this.numOfcards - this.numOfsets * dispatch_count;
		
		this.dispatched = new Card[this.numOfsets][dispatch_count];
		this.packed = new Card[pack];
		
		int k = 0;
		for(int i=0; i<dispatch_count; i++) {
			for(int j=0; j<this.numOfsets; j++) {
				this.dispatched[j][i] = this.cards[k++];
			}
		}
		
		for(int j=0; j<pack; j++) {
			this.packed[j] = this.cards[k++];
		}
	}

}

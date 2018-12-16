/**
 * @author nramanarayana
 * @revision Jul 18, 2008
 * @fileid CardSet.java
 * 
 */
package maker;

/**
 * class CardSet
 * 
 */
public class CardSet {
	
	/**
	 * integer color
	 * 	0 - blue
	 * 	1 - red
	 */
	public int color;
	
	/**
	 * Card[] cards
	 */
	protected Card[] cards;
	
	/**
	 * String[] sings
	 */
	protected String[] sings = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	/**
	 * int total
	 */
	public static int total = 53;
	

	/**
	 * Constructor
	 */
	public CardSet(int c) {
		this.color = c;
		this.cards = new Card[total];
		this.generate();
	}
	
	/**
	 * @param i
	 * @return Card at position i
	 */
	public Card getCard(int i) {
		return this.cards[i];
	}
	
	/**
	 * generate a card set of 52
	 */
	public void generate() {
		for(int t=0; t<4; t++) {
			this.generate_type(t);
		}
		
		//Joker Card
		this.cards[52] = this.generate_joker();
	}
	
	/**
	 * generate_type card set of 13
	 */
	protected void generate_type(int t) {
		for(int i=0; i<this.sings.length; i++) {
			int number = (t * this.sings.length) + i;
			// System.out.println(""+number);
			this.cards[number] = this.getCardObject(this.sings[i], t);
		}
	}
	
	/**
	 * get card Object
	 */
	protected Card getCardObject(String s, int t) {
		return new Card(s, t, this.color);
	}
	
	/**
	 * generate joker
	 */
	protected Card generate_joker() {
		return new Card("Joker", 4, this.color);
	}

}

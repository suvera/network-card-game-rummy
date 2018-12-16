/**
 * @author nramanarayana
 * @revision Sep 3, 2008
 * @fileid CardDispatch.java
 * 
 */
package rummy.msg;

import java.util.Vector;

import rummy.Rummy;

import maker.Card;
import net.Message;

/**
 * class CardDispatch
 * 
 */
public class DispatchMessage extends MessageBase {

	/**
	 * constructor
	 */
	public DispatchMessage() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#run()
	 */
	@Override
	public boolean run() {
		//System.out.println("I am at: " + this.message.getName());
		try {
			if( this.message.getSrc().equals(Rummy.config.getLocalip())) {
				return true;
			}
			Vector<?> data = this.message.getData();
			
			Card[] cs = new Card[data.size()];
			for(int i=0; i<data.size(); i++) {
				cs[i] = Card.getCard((String) data.elementAt(i) );
			}
			
			Rummy.gamepanel.setPlaySet(cs);
		} catch (Exception e) {
			System.out.println("executing recieved message " + this.message.getName() + e);
			e.printStackTrace();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("DispatchMessage");
		msg.setTitle("Dispatching cards");
		
		return msg;
	}

}

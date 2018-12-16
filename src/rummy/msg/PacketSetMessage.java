/**
 * @author nramanarayana
 * @revision Sep 3, 2008
 * @fileid PacketSetMessage.java
 * 
 */
package rummy.msg;

import java.util.Vector;

import rummy.Rummy;
import maker.Card;
import net.Message;

/**
 * class PacketSetMessage
 * 
 */
public class PacketSetMessage extends MessageBase {

	/**
	 * 
	 */
	public PacketSetMessage() {
		super();
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("PacketSetMessage");
		msg.setTitle("Packet Set of Cards Message");
		
		return msg;
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
			
			Rummy.gamepanel.setPackedSet(cs);
		} catch (Exception e) {
		}
		return true;
	}

}

/**
 * @author nramanarayana
 * @revision Sep 4, 2008
 * @fileid TakenFromPacketMessage.java
 * 
 */
package rummy.msg;

import rummy.Rummy;
import net.Message;

/**
 * class TakenFromPacketMessage
 * 
 */
public class TakenFromPacketMessage extends MessageBase {

	/**
	 * 
	 */
	public TakenFromPacketMessage() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("TakenFromPacketMessage");
		msg.setTitle("A Card has been Taken From Pocket");
		
		return msg;
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#run()
	 */
	@Override
	public boolean run() {
		//System.out.println("I am at: " + this.message.getName());
		try {
			if(!this.message.getSrc().equals(Rummy.config.getLocalip())) {
				Rummy.gamepanel.pocket.popCard();
			}
		} catch (Exception e) {
			System.out.println("executing recieved message " + this.message.getName() + e);
			e.printStackTrace();
		}
		return true;
	}

}

/**
 * @author nramanarayana
 * @revision Sep 3, 2008
 * @fileid InitialUserMessage.java
 * 
 */
package rummy.msg;

import rummy.Rummy;
import net.Message;

/**
 * class InitialUserMessage
 * 
 */
public class InitialUserMessage extends MessageBase {

	/**
	 * 
	 */
	public InitialUserMessage() {
		super();
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("InitialUserMessage");
		msg.setTitle("Initial User Message");
		
		return msg;
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#run()
	 */
	@Override
	public boolean run() {
		//System.out.println("I am at: " + this.message.getName());
		try {
			if(this.message.getDest().equals(Rummy.config.getLocalip())) {
				Rummy.config.setMyTurn(true);
				Rummy.gamepanel.showStatus("<html><font color='#FF000'>Your Turn!</font></html>");
				Rummy.gamepanel.setAlwaysOnTop(true);
			}
		} catch (Exception e) {
		}
		return true;
	}

}

/**
 * @author nramanarayana
 * @revision Sep 6, 2008
 * @fileid NewGameMessage.java
 * 
 */
package rummy.msg;

import rummy.Rummy;
import net.Message;

/**
 * class NewGameMessage
 * 
 */
public class NewGameMessage extends MessageBase {

	/**
	 * 
	 */
	public NewGameMessage() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("NewGameMessage");
		msg.setTitle("New Game Message");
		
		return msg;
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#run()
	 */
	@Override
	public boolean run() {
		//System.out.println("I am at: " + this.message.getName());
		try {
			if(this.message.getSrc().toString().equals(Rummy.config.getLocalip().toString())) {
				Rummy.newGame(true);
				Rummy.gamepanel.setAlwaysOnTop(true);
			}
		} catch (Exception e) {
		}
		return true;
	}

}

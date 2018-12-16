/**
 * @author nramanarayana
 * @revision Sep 7, 2008
 * @fileid ServerMessage.java
 * 
 */
package rummy.msg;

import net.Message;

/**
 * class ServerMessage
 * 
 */
public class ServerMessage extends MessageBase {

	/**
	 * 
	 */
	public ServerMessage() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("ServerMessage");
		msg.setTitle("Server Added Message");
		
		return msg;
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#run()
	 */
	@Override
	public boolean run() {
		//System.out.println("I am at: " + this.message.getName());
		try {
		} catch (Exception e) {
		}
		return true;
	}

}

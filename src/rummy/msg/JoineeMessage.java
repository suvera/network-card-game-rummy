/**
 * @author nramanarayana
 * @revision Sep 7, 2008
 * @fileid JoineeMessage.java
 * 
 */
package rummy.msg;

import net.Message;

/**
 * class JoineeMessage
 * 
 */
public class JoineeMessage extends MessageBase {

	/**
	 * 
	 */
	public JoineeMessage() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("JoineeMessage");
		msg.setTitle("Joinee Message");
		
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

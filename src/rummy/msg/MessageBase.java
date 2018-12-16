/**
 * @author nramanarayana
 * @revision Sep 3, 2008
 * @fileid MessageBase.java
 * 
 */
package rummy.msg;

import net.Message;

/**
 * class MessageBase
 * 
 * dispatch 
 * packetSet 
 * InitialUser
 * Thrown 
 * TakenFromPacket 
 * TakenFromThrewSet 
 * GameDone
 * GameDoneSet
 * 
 */
public abstract class MessageBase {

	//Message message
    public Message message;

    /**
     * constructor
     */
    public MessageBase() {
    	//TODO Auto-generated constructor stub
    }

    public abstract boolean run();
    
    public abstract Message getMessage();
    
    /**
     * @return
     */
    public Message getDefaultMessage() {
    	Message msg = new Message();
		
		msg.setId(1);		
		return msg;
    }
}
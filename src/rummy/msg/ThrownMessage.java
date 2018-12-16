/**
 * @author nramanarayana
 * @revision Sep 3, 2008
 * @fileid ThrownMessage.java
 * 
 */
package rummy.msg;

import java.util.Vector;

import rummy.Rummy;
import maker.CardUI;
import net.Message;

/**
 * class ThrownMessage
 * 
 */
public class ThrownMessage extends MessageBase {

	/**
	 * 
	 */
	public ThrownMessage() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("ThrownMessage");
		msg.setTitle("A Card has been thrown");
		msg.setDest(Rummy.config.getUserNextToMe());
		
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
				Vector<?> data = this.message.getData();
				CardUI card = (CardUI) data.elementAt(0);
				Rummy.gamepanel.shared.puchCard(card);
			}
			
			if(this.message.getDest().equals(Rummy.config.getLocalip())) {
				Rummy.config.setMyTurn(true);
				Rummy.gamepanel.showStatus("<html><font color='#FF000'>Your Turn!</font></html>");
				Rummy.gamepanel.setAlwaysOnTop(true);
			}
			
		} catch (Exception e) {
			System.out.println("ThrownMessage: " + e);
		}
		return true;
	}

}

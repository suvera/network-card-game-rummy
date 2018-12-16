/**
 * @author nramanarayana
 * @revision Sep 6, 2008
 * @fileid StartGameMessage.java
 * 
 */
package rummy.msg;

import rummy.Rummy;
import net.Message;

/**
 * class StartGameMessage
 * 
 */
public class StartGameMessage extends MessageBase {

	/**
	 * 
	 */
	public StartGameMessage() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("StartGameMessage");
		msg.setTitle("Start Game Message");
		
		return msg;
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#run()
	 */
	@Override
	public boolean run() {
		//System.out.println("I am at: " + this.message.getName() + ":" + this.message.getSrc() + " = " + Rummy.config.getLocalip());
		try {
			if(!this.message.getSrc().toString().equals(Rummy.config.getLocalip().toString())) {
				Rummy.serverpanel.dispose();
				Rummy.showGamePanel();
				Rummy.newGame(false);
				Rummy.gamepanel.setAlwaysOnTop(true);
				
				Rummy.config.setServer(this.message.getSrc());
				
				String[] list = new String[this.message.getData().size()]; 
				for(int i=0; i<this.message.getData().size(); i++) {
					list[i] = this.message.getData().elementAt(i).toString();
				}
				Rummy.config.setJoniees(list);
			}
		} catch (Exception e) {
		}
		return true;
	}

}

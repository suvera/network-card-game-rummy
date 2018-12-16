/**
 * @author nramanarayana
 * @revision Sep 4, 2008
 * @fileid GameDoneMessage.java
 * 
 */
package rummy.msg;

import java.util.Vector;

import rummy.Rummy;

import util.Alert;
import maker.Card;
import maker.ui.GameDoneWindow;
import net.Message;

/**
 * class GameDoneMessage
 * 
 */
public class GameDoneMessage extends MessageBase {

	/**
	 * 
	 */
	public GameDoneMessage() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see rummy.msg.MessageBase#getMessage()
	 */
	@Override
	public Message getMessage() {
		Message msg = this.getDefaultMessage();
		
		msg.setId(1);
		msg.setName("GameDoneMessage");
		msg.setTitle("Game Done");
		
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
				Alert.info(this.message.getSrc() + " Says Game Done, Click OK to see his Cards", "Game Done");
				try {
					Vector<?> data = this.message.getData();
					
					Card[] cs = new Card[data.size()];
					for(int i=0; i<data.size(); i++) {
						cs[i] = Card.getCard((String) data.elementAt(i) );
					}
					Rummy.gamepanel.setEnabled(false);
					GameDoneWindow gdw = new GameDoneWindow();
					gdw.display(cs, this.message.getSrc() + " Says Game Done");

				} catch (Exception e) {
					System.out.println("GameDoneMessage inner: " + e);
				}
			}
		} catch (Exception e) {
			System.out.println("executing recieved message " + this.message.getName() + e);
			e.printStackTrace();
		}
		return true;
	}

}

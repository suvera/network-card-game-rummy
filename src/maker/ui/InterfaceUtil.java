/**
 * @author nramanarayana
 * @revision Aug 15, 2008
 * @fileid InterfaceUtil.java
 * 
 */
package maker.ui;

import java.util.Vector;

import net.Message;
import maker.CardUI;
import rummy.MessageExecutor;
import rummy.Rummy;
import util.Util;

/**
 * class InterfaceUtil
 * 
 */
public class InterfaceUtil {

	/**
	 * 
	 */
	public InterfaceUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public static void selectCardFromPocket() {
		
		if(!Rummy.config.isMyTurn()) return;
		
		CardUI card = Rummy.gamepanel.pocket.popCard();
		card.turnIt();
		Rummy.gamepanel.playset.pushCard(card);
		
		Message tmpMsg = MessageExecutor.getMessage("TakenFromPacketMessage", null);
		Rummy.client.sendMessage(tmpMsg);
	}
	
	/**
	 * 
	 */
	public static void selectCardFromShared() {
		try {
			if(!Rummy.config.isMyTurn()) return;
			
			CardUI card = Rummy.gamepanel.shared.popCard();
			Rummy.gamepanel.playset.pushCard(card);
			
			Message tmpMsg = MessageExecutor.getMessage("TakenFromThrewSetMessage", null);
			Rummy.client.sendMessage(tmpMsg);
		} catch(Exception e) {
			Util.de("" + e);
		}
	}
	
	/**
	 * 
	 */
	public static void throwACard() {
		//get the selected card from the play set
		try {
			if(!Rummy.config.isMyTurn()) return;
			
			CardUI card = Rummy.gamepanel.playset.popSelectedCard();
			Rummy.gamepanel.shared.puchCard(card);
			
			Vector<CardUI> v = new Vector<CardUI>();
			v.add(card);
			Message tmpMsg = MessageExecutor.getMessage("ThrownMessage", v);
			Rummy.client.sendMessage(tmpMsg);
			
		} catch(Exception e) {
			Util.de("throwACard " + e);
		}
	}

}

/**
 * @author nramanarayana
 * @revision Jul 18, 2008
 * @fileid UnitTest.java
 * 
 */
import java.util.Arrays;
import java.util.Vector;

import net.Message;
import rummy.*;
import maker.*;
import util.*;

/**
 * class UnitTest
 * 
 */
public class UnitTest {

	/**
	 * 
	 */
	public UnitTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnitTest u = new UnitTest();
		
		//Tests starts here
		//u.CardTest();
		//u.panelTest();
		//u.MakerTest();
		u.msgTest();
	}
	
	void MakerTest() {
		Maker m = new Maker(3);
		//m.randomize();
		m.dispatch();
		Util.de("Total " + m.numOfcards);
	}
	
	/*
	 * 
	 */
	void msgTest() {
		Maker maker = new Maker(3);

		Vector<?> v = new Vector<Card>(Arrays.asList(maker.getDispatchedByPlayer(0)));
		Message m = MessageExecutor.getMessage("DispatchMessage", v);
		MessageExecutor.execute(m);
		
		
		Vector<?> v2 = new Vector<Card>(Arrays.asList(maker.getPacked()));
		Message m2 = MessageExecutor.getMessage("PacketSetMessage", v2);
		MessageExecutor.execute(m2);
		
		Rummy.showGamePanel();
		
		Rummy.gamepanel.showLog("Test\nTest\nTest\n");
		//Message m3 = MessageExecutor.getMessage("GameDoneMessage", v);
		//Util.de(""+m3.getSrc());
		//MessageExecutor.execute(m3);
	}
	
	/**
	 * @param m
	 */
	public void pln(String m) {
		System.out.println(m);
	}
	
	/**
	 * 
	 */
	void CardTest() {
		CardSet cs = new CardSet(0);
		for(int i=0; i<53; i++) {
			this.pln(cs.getCard(i).sign + "-" + cs.getCard(i).type + "-" + cs.getCard(i).color);
			this.pln(""+cs.getCard(i).getUI());
		}
	}
	
	/*
	 * 
	 */
	void panelTest() {
		Rummy r = new Rummy();
		r.start();
		//r.showGamePanel();
	}

}

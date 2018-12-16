package rummy;
/**
 * @author nramanarayana
 * @revision Jul 19, 2008
 * @fileid Rummy.java
 * 
 */

import java.util.Arrays;
import java.util.Vector;

//import net.BroadCastServer;
import net.Message;
import net.RmClient;
import net.RmServer;

import maker.Maker;
import maker.ui.GamePanel;
import maker.ui.ServerRetrievePanel;
import util.*;

/**
 * class Rummy
 * 
 */
public class Rummy {
	//---- Static Variables -----
	public static Config config = null;
	public static ServerRetrievePanel serverpanel = null;
	public static GamePanel gamepanel = null;
	
	public static RmClient client = null;
	public static RmServer server = null;
	public static Thread serverThread = null;
	public static Thread clientThread = null;
	
	//is game started
    public static boolean isGameStarted = false;

    //is server started
    public static boolean isServerStarted = false;
    public static boolean IamJoinee = false;
    
    //is this server has been stpped
    public static boolean stopped = false;
	

	/**
	 * Constructor
	 */
	public Rummy() {
		config = new Config();
		gamepanel = new GamePanel();
		serverpanel = new ServerRetrievePanel();
		client = new RmClient();
		server = new RmServer();
	}
			
	/**
	 * start the Game now
	 */
	public void start() {
		getServer();
		startClient();
		startServer();
	}
	
	/**
	 * get the server
	 */
	public static void getServer() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					serverpanel.setAlwaysOnTop(true);
					serverpanel.displayWindow();
				} catch (Exception e) {
				}
			}
		});
	}
	
	/**
	 * show Game Panel
	 */
	public static void showGamePanel() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					gamepanel.setAlwaysOnTop(true);
					gamepanel.displayWindow();
				} catch (Exception e) {
				}
			}
		});
	}
	
	/**
	 * start NEW Game
	 */
	public static void newGame(boolean isNew) {
		gamepanel.cleanup();
		config.setMyTurn(false);
		
		if(config.isServer()) {
			try {
				Message tmpMsg; 
				
				Maker maker = new Maker(config.getNumPlayers());
				gamepanel.setPlaySet(maker.getDispatchedByPlayer(config.getMyIndex()));
				gamepanel.setPackedSet(maker.getPacked());
				
				if(isNew) {
					tmpMsg = MessageExecutor.getMessage("NewGameMessage", null);
					client.sendMessage(tmpMsg);
				} else {
					tmpMsg = MessageExecutor.getMessage("StartGameMessage", Rummy.server.getJoineeVector() );
		        	Rummy.client.sendMessage(tmpMsg);
				}
				
				Vector<?> v = new Vector<String>(Arrays.asList(maker.getDispatchedByPlayerString(config.getMyIndex())));
				tmpMsg = MessageExecutor.getMessage("DispatchMessage", v);
				client.sendMessage(tmpMsg);
				
				v = new Vector<String>(Arrays.asList(maker.getPackedString()));
				tmpMsg = MessageExecutor.getMessage("PacketSetMessage", v);
				client.sendMessage(tmpMsg);
				
				tmpMsg = MessageExecutor.getMessage("InitialUserMessage", null);
				tmpMsg.setDest(config.getRandomUser());
				client.sendMessage(tmpMsg);
			} catch(Exception e) {
				Util.de("Unable to start new game: " + e);
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * start the Server now
	 */
	public static void startServer() {
		try {
			serverThread = new Thread(server);
			serverThread.start();
		} catch(Exception e) {
    		Util.de("Unable to start server:" + e);
    	}
	}
	
	/**
	 * start the Client now
	 */
	public static void startClient() {
		try {
			clientThread = new Thread(client);
			clientThread.start();
		} catch(Exception e) {
    		Util.de("Unable to start Client:" + e);
    		e.printStackTrace();
    	}
	}
	
	
	
	/**
	 * stop the Server now
	 */
	public static void stopServer() {
		try {
			serverThread = null;
			clientThread = null;
			Rummy.stopped = true;
		} catch(Exception e) {
    		Util.de("Unable STOP server:" + e);
    	}
	}

}

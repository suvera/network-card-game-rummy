/**
 * @author nramanarayana
 * @revision Aug 3, 2008
 * @fileid Config.java
 * 
 */
package util;

import java.net.InetAddress;

/**
 * class Config
 * 
 */
public class Config {
	
	/**
	 * String server
	 */
	private String server;
	
	/**
	 * String localip
	 */
	private String localip;
	
	/**
	 * int port
	 */
	private int port;
	
	/**
	 * String status
	 */
	private String status;
	
	/**
	 * boolean is_my_turn
	 */
	private boolean myTurn = false;
	
	/**
	 * int num_players
	 */
	private int numPlayers = 0;
	
	/**
	 * int myIndex
	 */
	private int myIndex = -1;
	
	/**
	 * boolean isServer
	 */
	private boolean isServer = false;
	
	/**
	 * String[] joniees
	 */
	private String[] joniees;
	

	/**
	 * 
	 */
	public Config() {
		try {
			this.localip = InetAddress.getLocalHost().toString();
		} catch (Exception e) {
		}
	}
	
	/**
	 * @return a joniee
	 */
	public String getJoniee(int index) {
		try {
			return joniees[index];
		} catch(Exception e) {
			System.out.println("no joinee found: " + e);
			return null;
		}
	}
	
	/**
	 * @return a joniee
	 */
	public String getUserNextToMe() {
		return joniees[this.getUserIndexNextToMe()];
	}
	
	/**
	 * @return a joniee
	 */
	public String getUserPrevToMe() {
		return joniees[this.getUserIndexPrevToMe()];
	}
	
	/**
	 * @return a joniee
	 */
	public String getRandomUser() {
		int i = new java.util.Random().nextInt(joniees.length);
		return joniees[i];
	}
	
	/**
	 * @return user index
	 */
	public int getUserIndexNextToMe() {
		if(getMyIndex()+1 >= joniees.length) {
			return 0;
		} else {
			return getMyIndex()+1;
		}
	}
	
	/**
	 * @return user index
	 */
	public int getUserIndexPrevToMe() {
		if(getMyIndex()-1 <= 0) {
			return joniees.length;
		} else {
			return getMyIndex()-1;
		}
	}

	/**
	 * @return the server
	 */
	public String getServer() {
		return server;
	}


	/**
	 * @param server the server to set
	 */
	public void setServer(String server) {
		this.server = server;
	}


	/**
	 * @return the localip
	 */
	public String getLocalip() {
		return localip;
	}


	/**
	 * @param localip the localip to set
	 */
	public void setLocalip(String localip) {
		this.localip = localip;
	}


	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}


	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @return the my_turn
	 */
	public boolean isMyTurn() {
		return myTurn;
	}


	/**
	 * @param my_turn the my_turn to set
	 */
	public void setMyTurn(boolean my_turn) {
		this.myTurn = my_turn;
	}


	/**
	 * @return the num_players
	 */
	public int getNumPlayers() {
		return numPlayers;
	}


	/**
	 * @param num_players the num_players to set
	 */
	public void setNumPlayers(int num_players) {
		this.numPlayers = num_players;
	}


	/**
	 * @return the myIndex
	 */
	public int getMyIndex() {
		if(myIndex == -1) {
			for(int i=0; i<this.joniees.length; i++) {
				if(localip.equals(this.joniees[i])) {
					myIndex = i;
					break;
				}
			}
		}
		return myIndex;
	}


	/**
	 * @param myIndex the myIndex to set
	 */
	public void setMyIndex(int myIndex) {
		this.myIndex = myIndex;
	}


	/**
	 * @return the isServer
	 */
	public boolean isServer() {
		return isServer;
	}


	/**
	 * @param isServer the isServer to set
	 */
	public void setServer(boolean isServer) {
		this.isServer = isServer;
	}


	/**
	 * @return the joniees
	 */
	public String[] getJoniees() {
		return joniees;
	}

	/**
	 * @param joniees the joniees to set
	 */
	public void setJoniees(String[] joniees) {
		this.joniees = joniees;
		this.setNumPlayers(joniees.length);
	}

}

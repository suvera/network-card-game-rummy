/**
 * @author nramanarayana
 * @revision Sep 6, 2008
 * @fileid RmServer.java
 * 
 */
package net;

import rummy.Rummy;

/**
 * class RmServer
 * 
 */
public class RmServer extends BroadCastServer implements Runnable {

	/**
	 * 
	 */
	public RmServer() {
		super();
		this.open();
	}
	
	/**
    * Thread start
    */
    public void run() {
        while (!Rummy.stopped) {
            try {
            	//System.out.println("RmServer: isGameStarted? " + Rummy.isGameStarted);
            	Message m = this.receiveMessage();
 
                this.processReceivedMessage(m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

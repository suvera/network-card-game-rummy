/**
 * @author nramanarayana
 * @revision Sep 6, 2008
 * @fileid RmClient.java
 * 
 */
package net;

import rummy.MessageExecutor;
import rummy.Rummy;

/**
 * class RmClient
 * 
 */
public class RmClient extends BroadCastServer implements Runnable {
	
	private long FIVE_SECONDS = 5000;
	
	/**
	 * 
	 */
	public RmClient() {
		super();
		this.open();
	}
	
	/**
    * Thread start
    */
    public void run() {
   	
        while (!Rummy.stopped) {
            try {
            	if(!Rummy.isGameStarted) {
            		//System.out.println("RmClient: " + Rummy.isServerStarted + " g:" + Rummy.isGameStarted);
	                if(Rummy.isServerStarted) {
	                    this.sendMessage(MessageExecutor.getMessage("ServerMessage", null));
	                } else if(Rummy.IamJoinee) {
	                	this.sendMessage(MessageExecutor.getMessage("JoineeMessage", null));
	                }
            	}
            	try {
                    Thread.sleep((long)Math.random() * FIVE_SECONDS);
                } catch (InterruptedException e) { }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	

}

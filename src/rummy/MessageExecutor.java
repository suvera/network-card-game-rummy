/**
 * @author nramanarayana
 * @revision Sep 3, 2008
 * @fileid MessageExecutor.java
 * 
 */
package rummy;

import java.util.Vector;

import net.Message;

/**
 * class MessageExecutor
 * 
 */
public class MessageExecutor {

	/**
     * @param msg
     * @return
     */
    public static boolean execute(Message msg) {
	    try {
	        Class<?> toRun = Class.forName("rummy.msg." + msg.getName());
	        Object obj = toRun.newInstance();
	
	        //Assign Message bean to here
	        toRun.getField("message").set(obj, msg);
	
	        //Call Run method of MessageBase
	        toRun.getMethod("run").invoke(obj);
	        Rummy.gamepanel.showLog("Src:" + msg.getSrc() + " Dest:" + msg.getDest()+ ", " + msg.getTitle());
	    } catch(Exception e) {
	        System.out.println("Method invocation failed: " + msg.getName() + " -> " + e);
	        e.printStackTrace();
	        return false;
	    }
	    return true;
    }
    
    /**
     * @param bean
     * @param data
     * 
     * @return Message
     */
    public static Message getMessage(String bean, Vector<?> data) {
    	Message msg = null;
	    try {
	        Class<?> toRun = Class.forName("rummy.msg." + bean);
	        Object obj = toRun.newInstance();

	        //Call getMessage method of MessageBase
	        msg = (Message) toRun.getMethod("getMessage").invoke(obj);
	        msg.setData(data);
	        
	    } catch(Exception e) {
	        System.out.println("Get Messge Bean failed: " + e);
	        return null;
	    }
	    return msg;
    }

}

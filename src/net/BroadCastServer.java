package net;
/**
* @author nramanarayana
* @date July 21, 2008
*
* Creates boradcast server socket, listens to connections and
* runs server thread for further communication 
* for each new connection.
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;


import rummy.MessageExecutor;
import rummy.Rummy;
import util.Util;


public class BroadCastServer {
    //client socket variable
    protected MulticastSocket bsocket;

    //Net group
    protected InetAddress group;

    //port number to send a request
    protected int port = 4941;

    //received message ip address
    protected InetAddress receivedIP;

    //server list
    protected Hashtable<String, Boolean> serverList;
    
    //joinees list
    protected Hashtable<String, Boolean> joineeList;

    /**
    * constructor
    */
    public BroadCastServer() {
        try {
            this.group = InetAddress.getByName("230.0.0.1");
            this.serverList = new Hashtable<String, Boolean>();
            this.joineeList = new Hashtable<String, Boolean>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * Thread start
    */
    public void run() {
    	System.out.println("Error: BroadCastServer::run called, This should be overridden!!");
    }

    /**
    *
    */
    public void open() {
        try {
            this.bsocket = new MulticastSocket(this.port);
            this.bsocket.setReuseAddress(true);
            this.bsocket.joinGroup(this.group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    *
    */
    public void close() {
        try {
            this.bsocket.leaveGroup(this.group);
            this.bsocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    *
    */
    public String receive() {
        try {
            DatagramPacket packet = null;
            byte[] buf = new byte[255];

            packet = new DatagramPacket(buf, buf.length);
            this.bsocket.receive(packet);
            
            this.receivedIP = packet.getAddress();

            return new String(packet.getData());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
    *
    */
    public void send(String dString) {    
        try {
            byte[] buf = new byte[256];

            buf = dString.getBytes();          
            this.bsocket.send(new DatagramPacket(buf, buf.length, this.group, this.port));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    *
    */
    public Message receiveMessage() {
    	try {
    		DatagramPacket packet = null;
    		byte[] b = new byte[65535];
    		
    		packet = new DatagramPacket(b, b.length);
    		this.bsocket.receive(packet); // blocks
    		
    		this.receivedIP = packet.getAddress();
    		Message m = (Message) new ObjectInputStream(new ByteArrayInputStream(b)).readObject();
    		
    		return m;
    	} catch (Exception e) {
            e.printStackTrace();
        }
    	return null;
    }
    
    /**
    *
    */
    public void sendMessage(Message m) {    
        try {
        	Util.de("Message Sent: " + m.getName());
        	m.setSrc(InetAddress.getLocalHost().toString());
        	
        	ByteArrayOutputStream b_out = new ByteArrayOutputStream();
        	ObjectOutputStream o_out = new ObjectOutputStream(b_out);

        	o_out.writeObject(m);
        	
        	byte[] b = b_out.toByteArray();

        	this.bsocket.send(new DatagramPacket(b, b.length, this.group, this.port));
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param msg
     */
    public void processReceivedMessage(Message msg) {
        //System.out.println("Comand " + cmd);
        
        if(msg.getName().equals("ServerMessage")) {
            
        	if(!this.serverList.containsKey(msg.getSrc()) ) {
                this.serverList.put(msg.getSrc(), true);
                Rummy.serverpanel.includeServer(msg.getSrc().toString());
                Rummy.serverpanel.showStatus("Server Added " + msg.getSrc());
            }
            
            if(!this.joineeList.containsKey(msg.getSrc()) ) {
                this.joineeList.put(msg.getSrc(), true);
                Rummy.serverpanel.showStatus("joineeList Added " + msg.getSrc());
            }
            
        } else if(msg.getName().equals("JoineeMessage")) {
            
        	if(!this.joineeList.containsKey(msg.getSrc()) ) {
                this.joineeList.put(msg.getSrc(), true);
                Rummy.serverpanel.showStatus("joineeList Added " + msg.getSrc());
            }
            
        } else {
        	MessageExecutor.execute(msg);
        	//Rummy.serverpanel.showStatus("joineeList Added " + this.receivedIP);
        }
    }

    /**
    *
    */
    public Hashtable<String, Boolean> getServerList() {
        return this.serverList;
    }

    /**
    *
    */
    public Hashtable<String, Boolean> getJoineeList() {
        return this.joineeList;
    }
    
    /**
    *
    */
    public Vector<String> getJoineeVector() {
    	Vector<String> v = new Vector<String>();
    	for (Enumeration<String> e = this.joineeList.keys(); e.hasMoreElements();)
    		v.add(e.nextElement().toString());

        return v;
    }
    
    /**
    *
    */
    public String[] getJoineeString() {
    	String[] v = new String[this.joineeList.size()];
    	int i =0;
    	Rummy.gamepanel.showLog("Joinee Len: "+ this.joineeList.size());
    	for (Enumeration<String> e = this.joineeList.keys(); e.hasMoreElements();)
    		v[i++] = e.nextElement().toString();

        return v;
    }
    
    /**
     * do finalization here
     */
    protected void finalize() throws Throwable {
    	this.clone();
    	super.finalize(); //not necessary if extending Object.
    } 
}
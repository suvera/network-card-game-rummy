/**
 * @author nramanarayana
 * @revision Aug 4, 2008
 * @fileid Message.java
 * 
 */
package net;

import java.io.Serializable;
import java.util.Vector;

/**
 * class Message
 * 
 */
public class Message implements Serializable {
	
	/**
	 * long serialVersionUID
	 */
	final static long serialVersionUID = 2008090704;
	
	/**
	 * int id
	 */
	private int id;
	
	/**
	 * String name
	 */
	private String name;
	
	/**
	 * String title
	 */
	private String title;
	
	/**
	 * String desc
	 */
	private String desc;
	
	/**
	 * String src
	 */
	private String src;
	
	/**
	 * String dest
	 */
	private String dest;
	
	/**
	 * Vector<?> data
	 */
	private Vector<?> data;
	
	
	/**
	 * 
	 */
	public Message() {
		//TODO
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}

	/**
	 * @return the dest
	 */
	public String getDest() {
		return dest;
	}

	/**
	 * @param dest the dest to set
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the data
	 */
	public Vector<?> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Vector<?> data) {
		this.data = data;
	}

}

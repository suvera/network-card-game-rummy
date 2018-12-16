package util;

/**
 * @author nramanarayana
 *
 */
import java.util.UUID;
import javax.swing.ImageIcon;


/**
 * class Util
 * 
 */
public class Util {
	
	/**
	 * @return
	 */
	public static String getRandomId() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * @param msg
	 */
	public static void de(String msg) {
		System.out.println(msg);
	}
		
	/** Returns an ImageIcon, or null if the path was invalid. */
	public static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ClassLoader.getSystemClassLoader().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}	
}


package candybox.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

/**
 * logger for CandyBox project by "singleton" pattern
 * @author head4max
 *
 */
public class Log4CandyBox {
	private static Log4CandyBox instanceLog4CandyBox = null;
	private static ReentrantLock lock = new ReentrantLock();
	
	private final static String fileName = "src" + File.separator + "candybox" + File.separator + "logger" + File.separator + "log.txt";
	
	/**
	 * deny access to constructor
	 */
	private Log4CandyBox(){
	}
	
	/**
	 * public static {@link Log4CandyBox} getInstance({@link String}, {@link String})
	 * @param initClass - handler of an event
	 * @param event - action with handler of event
	 * @return reference to a single object of this class
	 */
	public static Log4CandyBox getInstance(String initClass, String event){
		
		lock.lock();
		
		if(instanceLog4CandyBox == null){
			instanceLog4CandyBox = new Log4CandyBox();
		}
		
		instanceLog4CandyBox.logging(initClass + "|" + event);
		lock.unlock();
		
		return instanceLog4CandyBox;
	}
	
	/**
	 * 
	 * @param logMessage - message write into a log file with date+time
	 */
	private void logging(String logMessage){
		
		FileWriter fw;
		
		try {
			fw = new FileWriter(fileName, true);
			fw.write(logMessage + "|" + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US).format(new Date()) + "\r\n");
			fw.close();
		} catch (IOException e) {
		}
	}
	
}

package candybox.scannercontrol;

/**
 * include methods for changing language of a menu item and get formated time and date
 * @author head4max
 *
 */
interface Localable {
	
	/**
	 *  change language and format of date and time
	 */
	void setLocale();
	
	/**
	 * 
	 * @return {@link String} - time and date for current locale
	 */
	String getTimeDate();
}

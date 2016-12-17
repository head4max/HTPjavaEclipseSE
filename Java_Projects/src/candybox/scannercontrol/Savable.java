package candybox.scannercontrol;

/**
 * include a serialized method {@link Savable#save()}
 * @author head4max
 * @version 1.0
 */
interface Savable {
	
	/**
	 * use for serializing {@link candybox.CandyBox} inside {@link BoxMenu}
	 */
	void save();
}

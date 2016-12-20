package candybox;

import candybox.scannercontrol.BoxMenu;

public class SweetBoxMain {

	public static void main(String[] args) {
		try {
			new BoxMenu().getBoxMenu();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
	}

}

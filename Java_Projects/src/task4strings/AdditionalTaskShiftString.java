package task4strings;

/**
 * 
 * @author head4max
 *
 */
public class AdditionalTaskShiftString {
	
	/**
	 * private static boolean isSubstring({@link String} , {@link String})<br>
	 * <br>
	 * 
	 * @param str - string
	 * @param shiftstr - shift string
	 * @return true if first string contains second
	 */
	private static boolean isSubstring(String str, String shiftstr){
		
		if(str.indexOf(shiftstr) >= 0)
			return true;
		else
			return false;
	}
	
	/**
	 * public static void isShiftString({@link String}, {@link String})<br>
	 * <br>
	 * out check result
	 * @param str - string
	 * @param shiftstr - shift string
	 */
	public static void isShiftString(String str, String shiftstr){
		
		/*  алгоритм такой:берем 1ую строку -> разрезаем её примерно на две части -> делаем новую строку, которая
		    состоит из 2ой части искомой строки + самой строки + 1ой части искомой строки -> вызываем метод
		    isSubstring() для удлиненной строки и 2ой потенциально циклической строки. Т е мы создали строку,
		    включающую в себя все циклические сдвиги 1ой строки, а значит в ней должна содержаться 2ая строка.
		    При этом длинны строк должны совпадать. */
		
		if(str.length() == shiftstr.length() && isSubstring((str.substring(str.length()/2) + 
				str + str.substring(0, str.length()/2)),shiftstr))
			System.out.println("строки:" + str + " и " + shiftstr + " являются циклическими");
		else
			System.out.println("строки:" + str + " и " + shiftstr + " не являются циклическими");
	}
}

package task4strings;

/**
 * 
 * @author head4max
 *
 */
public class LetterSpaceOnly {
	
	/**
	 * public static void deleteNoLetterNoSpace({@link StringBuffer})<br>
	 * <br>
	 * Delete all symbols are not letter or whitespace. Out result string.
	 * @param sb - entry string
	 */
	public static void deleteNoLetterNoSpace(StringBuffer sb){
		for(int i = 0;i<sb.length();i++){
			if(!Character.isWhitespace(sb.charAt(i)) && !Character.isLetter(sb.charAt(i))){
				sb.deleteCharAt(i);
				i--;
			}
		}
		System.out.println(sb);
	}
}

package task4strings;

/**
 * 
 * @author head4max
 *
 */
public class WordWithFirstConsonant {
	
	/**
	 * public void deleteWordDirectLength({@link StringBuffer}, int )<br>
	 * <br>
	 * Delete all words(direct length) starts with consonant
	 * @param sb - entry string
	 * @param length - size of the string to delete
	 */
	public static void deleteWordDirectLength(StringBuffer sb, int length){
		int startIndex = 0;
		if(length <= 0 || length > sb.length()){
			return;
		}

		sb.append(' ');
		for(int i = 0;i < sb.length();i++){
			if(!Character.isLetter(sb.charAt(i))){
				if((i - startIndex) == length){
					if(!(isVowelChar(Character.toLowerCase(sb.charAt(startIndex))))){
						sb.delete(startIndex, i);
						i -= length;
						startIndex = i;
					}
				}
				startIndex = i+1;
			}
		}
		sb.deleteCharAt(sb.length()-1);
	}
	
	/**
	 * private static boolean isVowelChar( char )<br>
	 * <br>
	 * verify symbol for entry in a vowel group symbols
	 * @param s - symbol
	 * @return true if symbol is not a vowel
	 */
	private static boolean isVowelChar(char s){
		switch(s){
			case 'a':return true;
			case 'e':return true;
			case 'y':return true;
			case 'u':return true;
			case 'i':return true;
			case 'o':return true;
			default :return false;
		}
	}
}

package task4strings;

/**
 * 
 * @author head4max
 *
 */
public class LetterToCode {
	
	/**
	 * public static void replaceLetterToCode({@link StringBuffer})<br>
	 * <br>
	 * out two line. In the first line all letter prints with two space before it. Second line contains code of the letters instead their self
	 * @param sb - entry string
	 */
	public static void replaceLetterToCode(StringBuffer sb){
		for(char s:sb.toString().toCharArray()){
			if(Character.isLetter(s)){
				System.out.printf("%1$3s", s);
			}else{
				System.out.print(s);
			}
		}
		System.out.println();
		for(char s:sb.toString().toCharArray()){
			if(Character.isLetter(s)){
				System.out.printf("%3d",((int)Character.toLowerCase(s)-96));
			}else{
				System.out.print(" ");
			}
		}
	}
}

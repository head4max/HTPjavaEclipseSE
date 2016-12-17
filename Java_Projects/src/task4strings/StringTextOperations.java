package task4strings;


import java.lang.StringBuffer;

/**
 * 
 * @author head4max
 *
 */
public class StringTextOperations{
	
	/**
	 * public static String getArchive({@link StringBuffer})<br>
	 * <br>
	 * zip string if it could
	 * @param sb - entry string
	 * @return archive string
	 */
	public static String getArchive(StringBuffer sb){
		
		String returnString = "";
		int repeatSymb = 1;
		
		for(int i = 0;i<sb.length()-1;i++){
			if(sb.charAt(i) == sb.charAt(i+1)){
				repeatSymb++;
			}else{
				returnString += Character.toString(sb.charAt(i)) + repeatSymb;
				repeatSymb = 1;
			}
		}
		returnString += Character.toString(sb.charAt(sb.length()-1)) + repeatSymb;
		
		if(returnString.length() < sb.length()){
			return returnString;
		} else{
			return sb.toString();
		}
	}
}

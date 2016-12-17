package task4strings;

/**
 * 
 * @author head4max
 *
 */
public class UnicSymbols {
	
	/**
	 * public static boolean isUnicSymbols({@link StringBuffer})<br>
	 * <br>
	 * verify unicity of the symbols of the string 
	 * @param sb - entry string
	 * @return false if even one symbol of the string meets double
	 */
	public static boolean isUnicSymbols(StringBuffer sb){

		for(int i = 0;i < sb.length()-1;i++){
			if(sb.substring(i+1).toLowerCase().indexOf(Character.toLowerCase(sb.charAt(i))) > -1){
				return false;
			}
		}
		return true;
	}
}

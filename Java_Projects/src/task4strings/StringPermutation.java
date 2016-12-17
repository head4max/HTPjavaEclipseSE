package task4strings;

/**
 * 
 * @author head4max
 *
 */
public class StringPermutation {
	
	/**
	 * public static boolean isPermutationStrings({@link String}, {@link String})<br>
	 * <br>
	 *  check strings for permutation
	 * @param firstStr - first string
	 * @param secondStr - second string
	 * @return true only if char sets both string are the same
	 */
	public static boolean isPermutationStrings(String firstStr, String secondStr){

		if(firstStr.length() != secondStr.length()){
			return false;
		}
		StringBuffer tempStr = new StringBuffer(secondStr);
		
		for(int i = 0;i<firstStr.length();i++){
			int indexSameSubstring = tempStr.indexOf(Character.toString(firstStr.charAt(i)));
			
			if(indexSameSubstring >= 0){
				tempStr.deleteCharAt(indexSameSubstring);
			}else{
				return false;
			}
		}
		if(tempStr.length() == 0){
			return true;
		}else{
			return false;
		}
	}
}

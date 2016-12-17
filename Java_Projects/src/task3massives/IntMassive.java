package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class IntMassive {
	
	/**
	 * public static void getOutMassive({@link int[]} , {@link String} )<br>
	 * <br>
	 * formated console out for massive of int values
	 * @param intMassive - massive of int values
	 * @param addedString - message added to head of the outline
	 */
	public static void getOutMassive(int[] intMassive, String addedString){

		System.out.println("          элементы массива  " + addedString + ":");
		
		for(int i = 0;i<intMassive.length;i++){
			System.out.printf("%3d",intMassive[i]);
		}
		
		System.out.println();
	}
}

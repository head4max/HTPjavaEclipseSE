package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class MinValueIndexes {
	
	/**
	 * public static void getMinIndex( int , int[] )<br>
	 * <br>
	 * out all indexes with min value
	 * @param minInMassive - min value of intMassive
	 * @param intMassive - massive of int values
	 */
	public static void getMinIndex(int minInMassive, int[] intMassive){

		System.out.print("          минимальному значению " + minInMassive
					+ " среди элементов массива соответствуют слудующие индексы:");
			
		boolean firstComma = false;
			
		for(int i = 0;i < intMassive.length;i++){
			if(intMassive[i] == minInMassive){
				if(!firstComma){
					firstComma = true;
				} else {
					System.out.print(", ");
				}
				System.out.print(i);
			}
		}

	}
}

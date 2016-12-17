package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class CountMinusElements {
	
	/**
	 * public static void getCountMinusElem( int[] )<br>
	 * <br>
	 * get count negative elements of the massive
	 * @param intMassive - massive of int values
	 */
	public static void getCountMinusElem(int[] intMassive){
		
		int countMinusE = 0;
		for(int i = 0;i < intMassive.length;i++){
			if(intMassive[i] < 0){
				countMinusE++;
			}
		}
		if(countMinusE == 0){
			System.out.println("          в массиве нет ни одного отрицательного элемента");
		}else{
			System.out.println("          количество отрицательных элементов = " + countMinusE);
		}
	}
}

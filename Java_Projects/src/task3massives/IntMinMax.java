package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class IntMinMax {
	
	/**
	 * public static int[] getMinMax( int[] )<br>
	 * <br>
	 * find min and max value of the massive
	 * @param intMassive - massive of int values
	 * @return massive with two elements({min, max} if they're different and only one element if the same
	 */
	public static int[] getMinMax(int[] intMassive){

			int minValue =intMassive[0];
			int maxValue = intMassive[0];
			
			for(int i = 1;i<intMassive.length;i++){
				if(intMassive[i] < minValue){
					minValue = intMassive[i];
				}
				if(intMassive[i] > maxValue){
					maxValue = intMassive[i];
				}
			}

			if(minValue == maxValue){
				System.out.println("All massive elements equal.");
				System.out.println("min value = max value = " + minValue);
				return new int[]{minValue};
			}else {
				System.out.println("          min value = " + minValue);
				System.out.println("          max value = " + maxValue);
				return new int[]{minValue, maxValue};
			}
		}
}

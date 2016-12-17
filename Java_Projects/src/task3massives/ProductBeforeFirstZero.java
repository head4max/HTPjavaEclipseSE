package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class ProductBeforeFirstZero {
	
	/**
	 * public static void getProductBeforeFirstZero( int[] )<br>
	 * <br>
	 * divide product first elements before zero
	 * @param intMassive - massive of int values
	 */
	public static void getProductBeforeFirstZero(int[] intMassive){
		
	    int product = 0;
	    for(int i = 0;i < intMassive.length;i++){
	    	if(intMassive[i] == 0){
	    		break;
	    	}else if(product == 0){
	    		product = intMassive[i];
	    	}else{
	    		product *= intMassive[i];
	    	}
	    }
	    
	    if(product == 0){
	    	System.out.println("          1ый элемент массива равен нулю");
	    }else{
	    	System.out.println("          произведение элементов до 1го нуля = " + product);
	    }
	}
}

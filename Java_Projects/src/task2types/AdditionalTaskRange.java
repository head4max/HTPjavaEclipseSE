package task2types;

import java.util.Scanner;

/**
 * 
 * @author head4max
 *
 */
public class AdditionalTaskRange {
	
	/**
	 * public static void outSummRangeAndFactorial({@link Scanner})<br>
	 * <br>
	 * out factorial(n!) and sum of the current range with n elements, where "n" get from console
	 * @param StringScanner - scanner from main method
	 */
	public static void outSummRangeAndFactorial(Scanner StringScanner){
		
		String rangeString ="";

		while(true){
			System.out.println("Введите целое число от 1 до 999 или \"q\" чтобы выйти в меню");
			System.out.println("");

			rangeString = StringScanner.nextLine();
			
			if(rangeString.matches("[\\d]{1,5}")){
				long rangeNumber = Long.valueOf(rangeString);
				double summRange = 0;
				long factorialRange = 1;
				long summRangeN=0;
				
				System.out.println();
				
				for(int index = 1;index <= rangeNumber;index++){
					summRange +=(1/(double)index);
					if(summRange < 0){
						System.out.println("сумма ряда 1,1/2,1/3,..,1/n превышает размерность типа double");
						break;
						
					}
				}
				if(summRange > 0){
					System.out.println("сумма ряда 1,1/2,1/3,..,1/n = " + summRange);
				}
				System.out.println();
				for(int index = 1;index <= rangeNumber;index++){
					factorialRange *= index;
					if(factorialRange < 0){
						System.out.println(rangeString + "! превышает размерность типа long");
						break;
					}
				}
				if(factorialRange > 0){
					System.out.println(rangeString + "! = " + factorialRange);
				}
				System.out.println();
				for(int index = 1;index <= rangeNumber;index++){
					summRangeN +=index;
					if(summRangeN < 0){
						System.out.println("сумма ряда 1,2,..,n-1,n превышает размерность типа long");
						break;
						
					}
				}
				if(summRangeN > 0){
					System.out.println("сумма ряда 1,2,..,n-1,n = " + summRangeN);
				}
				System.out.println();
			}else if(rangeString.matches("^[q]$")){
				return;
			}else{
				System.out.println("Вы ввели некорректную строку, попробуйте снова!");
				System.out.println();
			}
		}
	}
}

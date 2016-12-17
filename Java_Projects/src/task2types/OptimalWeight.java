package task2types;

import java.util.Scanner;

/**
 * 
 * @author head4max
 *
 */
public class OptimalWeight {
	
	/**
	 * public static void recommendation({@link Scanner})<br>
	 * <br>
	 * out recommendation about your entered weight
	 * @param StringScanner - scanner from main method
	 */
	public static void recommendation(Scanner StringScanner){
		
		String numbersString ="";
		String[] massNumbers;
		
		short weight = 0;
		short height = 0;

		while(true){
			System.out.println("Введите ваши рост(целое в см) и вес(целое в кг) через пробел или \"q\" чтобы выйти в меню:");
			System.out.println("");

			numbersString = StringScanner.nextLine();
			if(numbersString.matches("^[\\d]{2,3}[\\s]+[\\d]{1,3}$")){
				massNumbers = numbersString.split("[\\s]+");
				height = Short.valueOf(massNumbers[0]);
				weight = Short.valueOf(massNumbers[1]);
				
				if(height - weight > 100){
					System.out.println("вам нужно потолстеть");
				} else if(height - weight < 100){
					System.out.println("вам нужно похудеть");
				} else{
					System.out.println("у вас идеальное соотношение роста и веса");
				}
			} else if(numbersString.matches("^[q]$")){
				return;
			} else{
				System.out.println("Вы ввели некорректную строку с числами, попробуйте снова");
				System.out.println();
			}
			System.out.println();
		}
	}
}

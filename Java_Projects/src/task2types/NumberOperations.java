package task2types;

import java.util.Scanner;

/**
 * 
 * @author head4max
 *
 */
public class NumberOperations {
	
	/**
	 * public static void operationTwoNumbers({@link Scanner})<br>
	 * <br>
	 * wait for enter two numbers, then out sum and division in console
	 * @param splitStringScanner - scanner from main method 
	 */
	public static void operationTwoNumbers(Scanner splitStringScanner){
		
		String numbersString ="";
		String[] massNumbers;
		
		double numOneDouble = 0;
		double numTwoDouble = 0;

		while(true){
			System.out.println("Введите два целых либо долбных числа через пробел или \"q\" чтобы выйти в меню:");
			System.out.println("");

			numbersString = splitStringScanner.nextLine();
			if(numbersString.matches("^([\\d]+([\\.][\\d]+)?)[\\s]+([\\d]+([\\.][\\d]+)?)$")){
				massNumbers = numbersString.split("[\\s]+");
				numOneDouble = Double.valueOf(massNumbers[0]);
				numTwoDouble = Double.valueOf(massNumbers[1]);
				
				if(numOneDouble > numTwoDouble){
					System.out.println("1ое число больше 2го");
				} else if(numOneDouble < numTwoDouble){
					System.out.println("1ое число меньше 2го");
				} else{
					System.out.println("числа равны");
				}
				
				if(numTwoDouble != 0){
					System.out.println("деление 1го числа на 2ое равно: " + numOneDouble/numTwoDouble);
				} else{
					System.out.println("2ое число равно нулю, результат деления не определён");
				}
			} else if(numbersString.matches("^[q]$")){
				return;
			} else{
				System.out.println("Вы ввели некорректную строку с числами, попробуйте снова");
				System.out.println();
			}
		}
	}
}

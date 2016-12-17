package task2types;

import java.util.Scanner;

/**
 * 
 * @author head4max
 *
 */
public class Calculator {
	
	/**
	 * public static void calculate({@link Scanner})<br>
	 * <br>
	 * get two numbers with sign operation "+ or /" and out result for correct enter
	 * @param StringScanner - scanner from main method
	 */
	public static void calculate(Scanner StringScanner){
		while(true){
			System.out.println("Введите два числа со знаком операции(+ или /) между ними или \"q\" чтобы выйти в меню");
			System.out.println("");

			String[] operationNumber = new String[2];

			String expresionString;
			expresionString = StringScanner.nextLine();
			expresionString.replaceAll(" ", "");
			
			if(expresionString.matches("[-]?[\\d]+([\\.][\\d]+)?[\\+][-]?[\\d]+([\\.][\\d]+)?")){
				operationNumber = expresionString.split("[\\+]", 2);
				System.out.println("сумма чисел =" + (Double.valueOf(operationNumber[0]) + Double.valueOf(operationNumber[1])));
			}else if(expresionString.matches("[-]?[\\d]+([\\.][\\d]+)?[/][-]?[\\d]+([\\.][\\d]+)?")){
				operationNumber = expresionString.split("[/]", 2);
				if(Double.valueOf(operationNumber[1]) != 0){
					System.out.println("частное чисел =" + Double.valueOf(operationNumber[0]) / Double.valueOf(operationNumber[1]));
				}else{
					System.out.println("результат деления на 0 не определен");
				}
			} else if(expresionString.matches("^[q]$")){
				return;
			}else{
				System.out.println("Вы ввели некорректную строку, попробуйте снова!");
			}
			System.out.println();
			System.out.println();
		}
	}
}

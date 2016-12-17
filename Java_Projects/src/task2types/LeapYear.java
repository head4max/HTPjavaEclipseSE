package task2types;

import java.util.Scanner;

/**
 * 
 * @author head4max
 *
 */
public class LeapYear {
	
	/**
	 * public static void isLeapYear({@link Scanner})<br>
	 * <br>
	 * check entered year for "leap year"
	 * @param splitStringScanner - scanner from main method
	 */
	public static void isLeapYear(Scanner splitStringScanner){
		
		String yearString ="";

		while(true){
			System.out.println("Введите год(целое число) или \"q\" чтобы выйти в меню");
			System.out.println("");

			yearString = splitStringScanner.nextLine();
			
			if(yearString.matches("[\\d]+")){
				System.out.println();
				if(Integer.valueOf(yearString)%4 == 0){
					if(Integer.valueOf(yearString)%100 == 0){
						if(Integer.valueOf(yearString)%400 == 0){
							System.out.println("год " + yearString + " - высокосный");
						} else{
							System.out.println("год " + yearString + "не является высокосным");
						}
					} else{
						System.out.println("год " + yearString + " - высокосный");
					}
				}else{
					System.out.println("год " + yearString + "не является высокосным");
				}
				System.out.println();
			}else if(yearString.matches("^[q]$")){
				return;
			}else{
				System.out.println("Вы ввели некорректную строку, попробуйте снова!");
				System.out.println();
			}
		}
	}
}

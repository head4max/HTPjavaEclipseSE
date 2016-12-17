package task2types;

import java.util.Scanner;

/**
 * 
 * @author head4max
 *
 */
public class SplitString {
	
	/**
	 * public static void splitting({@link Scanner})<br>
	 * <br>
	 * split entered string by half and out parts in console
	 * @param splitStringScanner - scanner from main method
	 */
	public static void splitting(Scanner splitStringScanner){
		
		String splitString ="";

		while(true){
			System.out.println("Введите строку, состоящую хотя бы из двух символов или \"q\" чтобы выйти в меню");
			System.out.println("");

			splitString = splitStringScanner.nextLine();
			
			if(splitString.length() >= 2){
				System.out.println();
				System.out.println("1ая часть строки: " + splitString.substring(0, splitString.length()/2));
				System.out.println("2ая часть строки: " + splitString.substring(splitString.length()/2));
			}else if(splitString.matches("^[q]$")){
				return;
			}else{
				System.out.println("Вы ввели строку не достаточной длинны, попробуйте снова!");
				System.out.println();
			}
		}
	}
}

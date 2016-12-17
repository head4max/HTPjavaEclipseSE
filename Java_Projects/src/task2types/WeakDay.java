package task2types;

import java.util.Scanner;

/**
 * 
 * @author head4max
 *
 */
public class WeakDay {
	
	/**
	 * public static void outDay({@link Scanner})<br>
	 * <br>
	 * out day of weak appropriate entered count
	 * @param StringScanner - scanner from main method
	 */
	public static void outDay(Scanner StringScanner){
		
		String weakDayString ="";

		while(true){
			System.out.println("Введите целое положительное число или \"q\" чтобы выйти в меню");
			System.out.println("");

			weakDayString = StringScanner.nextLine();
			
			if(weakDayString.matches("[\\d]{1,5}")){
				int weakDayNumber = Integer.valueOf(weakDayString);
				
				System.out.println();
				switch(weakDayNumber){
					case 1: 	System.out.println("введённому числу соответствует понедельник");
								break;
					case 2: 	System.out.println("введённому числу соответствует вторник");
								break;
					case 3: 	System.out.println("введённому числу соответствует среда");
								break;
					case 4: 	System.out.println("введённому числу соответствует четверг");
								break;
					case 5: 	System.out.println("введённому числу соответствует пятница");
								break;
					case 6: 	System.out.println("введённому числу соответствует суббота");
								break;
					case 7: 	System.out.println("введённому числу соответствует воскресенье");
								break;
					default:	System.out.println("Такого дня недели не существует");
								break;
					}
				System.out.println();
			}else if(weakDayString.matches("^[q]$")){
				return;
			}else{
				System.out.println("Вы ввели некорректную строку, попробуйте снова!");
				System.out.println();
			}
		}
	}
}

package task2types;

import java.util.Scanner;

/**
 * 
 * @author head4max
 *
 */
public class EndRub {
	
	/**
	 * public static void outFormatRub({@link Scanner})<br>
	 * <br>
	 * out with right end of the word "рубль" independence of its count
	 * @param StringScanner - scanner from main method
	 */
	public static void outFormatRub(Scanner StringScanner){
		
		String priceString ="";

		while(true){
			System.out.println("Введите целое число от 1 до 999 или \"q\" чтобы выйти в меню");
			System.out.println("");

			priceString = StringScanner.nextLine();
			
			if(priceString.matches("[\\d]{1,3}")){
				int rest = Integer.valueOf(priceString);
				if(priceString.length() == 3){
					rest = rest %100;
				}
				System.out.println();
				if(rest/10 != 1){
					rest = rest % 10;
					switch(rest){
						case 1: 	System.out.println("у вас  " + priceString + " рубль");
									break;
						case 2: 	System.out.println("у вас " + priceString + " рубля");
									break;
						case 3: 	System.out.println("у вас " + priceString + " рубля");
									break;
						case 4: 	System.out.println("у вас " + priceString + " рубля");
									break;
						default:	System.out.println("у вас " + priceString + " рублей");
									break;
					}
				}else{
					System.out.println("у вас " + priceString + " рублей");
				}
				System.out.println();
			}else if(priceString.matches("^[q]$")){
				return;
			}else{
				System.out.println("Вы ввели некорректную строку, попробуйте снова!");
				System.out.println();
			}
		}
	}
}

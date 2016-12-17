package task2types;

import java.util.Scanner;

/**
 * class contains method main()
 * @author head4max
 * 
 */

public class TypeVariables {

	/**
	 * public static void main
	 * @param  args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner systemScanner;
		systemScanner = new Scanner(System.in,"Cp1251");

		do{
			System.out.println("Выберите задачу:");
			System.out.println("Введите \"1\" чтобы выбрать задачу деления строки пополам");
			System.out.println("Введите \"2\" чтобы выбрать сравнение и деление двух чисел");
			System.out.println("Введите \"3\" чтобы выбрать задачу о високосном годе");
			System.out.println("Введите \"4\" чтобы выбрать задачу об оптимальном весе");
			System.out.println("Введите \"5\" чтобы выбрать задачу о грамматически верной цене в рублях");
			System.out.println("Введите \"6\" чтобы выбрать задачу о дне недели");
			System.out.println("Введите \"7\" чтобы выбрать дополнительные задачи о суммах рядов и вычислении факториала");
			System.out.println("Введите \"8\" чтобы выбрать дополнительные задачи о таблице квадратов и квадратной функции");
			System.out.println("Введите \"9\" для входа в калькулятор");
			System.out.println("Введите \"q\" чтобы выйти из программы");
			System.out.println();
			
			byte indexMenu = 0;

			String lineScanner = systemScanner.nextLine();
			if(lineScanner.matches("^[1-9]$")){
				indexMenu = Byte.valueOf(lineScanner);
			}else if(lineScanner.matches("^[q]$")){
				System.out.println();
				System.out.println("программа завершила работу");
				systemScanner.close();
				return;
			}
			else{
				System.out.println("");
				System.out.println("Вы ввели некорректный символ, попробуйте еще раз...");
				System.out.println("");
			}
			
			switch(indexMenu){
			case 1: SplitString.splitting(systemScanner);;
					break;
			case 2: NumberOperations.operationTwoNumbers(systemScanner);
					break;
			case 3: LeapYear.isLeapYear(systemScanner);
					break;
			case 4: OptimalWeight.recommendation(systemScanner);
					break;
			case 5: EndRub.outFormatRub(systemScanner);
					break;
			case 6: WeakDay.outDay(systemScanner);
					break;
			case 7: AdditionalTaskRange.outSummRangeAndFactorial(systemScanner);
					break;
			case 8: AdditionalTaskMatrixAndFunction.getFormattedMatrixAndFunction();
					break;
			case 9: Calculator.calculate(systemScanner);
					break;
			default:
					break;
			}
			
		}while(true);
	}

}

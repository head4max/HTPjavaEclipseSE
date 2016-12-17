package task1helloworld;

import java.util.*;

public class HelloWorld{
    public static void main(String[] args){

        System.out.println("Привет, World!");
	System.out.println();
	System.out.println();
	System.out.println();

	System.out.println("система жаждет узнать ваше имя: ");

	Scanner systemScanner = new Scanner(System.in,"Cp1251");
	String paternScanner = "[А-ЯЁ][а-яё]*";

	System.out.println("проверка по маске: " + paternScanner + "(win1251)");

	while(!systemScanner.hasNext(paternScanner)){
		System.out.println("имя должно состоять из букв кириллицы и начинаться с заглавной, подумала система...");
		systemScanner.nextLine();
	}
	
	String username = systemScanner.nextLine();
	systemScanner.close();
 	System.out.println("Привет, " + username + "!");
	System.out.println();
    }
}
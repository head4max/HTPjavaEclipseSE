package task1helloworld;

import java.util.*;

public class HelloWorld{
    public static void main(String[] args){

        System.out.println("������, World!");
	System.out.println();
	System.out.println();
	System.out.println();

	System.out.println("������� ������ ������ ���� ���: ");

	Scanner systemScanner = new Scanner(System.in,"Cp1251");
	String paternScanner = "[�-ߨ][�-��]*";

	System.out.println("�������� �� �����: " + paternScanner + "(win1251)");

	while(!systemScanner.hasNext(paternScanner)){
		System.out.println("��� ������ �������� �� ���� ��������� � ���������� � ���������, �������� �������...");
		systemScanner.nextLine();
	}
	
	String username = systemScanner.nextLine();
	systemScanner.close();
 	System.out.println("������, " + username + "!");
	System.out.println();
    }
}
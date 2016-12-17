package task14threads;

import java.util.Scanner;

/**
 * class with main method for create and monipulating threads
 * @author head4max
 *
 */
public class ThreadsMain {

	public static void main(String[] args) {
		
		LineOutNumbersThread lonThread1 = new LineOutNumbersThread(10, 1, 100);
		LineOutNumbersThread lonThread2 = new LineOutNumbersThread(9, 1, 90);
		
		lonThread1.setName("t1");
		lonThread2.setName("t2");
		
		System.out.println("введите \"start\" чтобы запустить потоки");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNext("^start$")){
			sc.next();
		}
		
		sc.close();
		
		lonThread1.start();
		lonThread2.start();
		
		try {
			lonThread1.join();
			lonThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("finished program");
	}

}

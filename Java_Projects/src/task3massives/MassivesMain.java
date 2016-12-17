package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class MassivesMain {

	/**
	 * public static void main({@link String[]})<br>
	 * <br>
	 * entry point Task3
	 * @param args - one or more arguments get from command line while run
	 */
	public static void main(String[] args) {
		
		System.out.println("Часть 1ая: элементы сгенерированного массива типа float");
		System.out.println("");
		new FloatMassive().getFloatMassive(3);
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("");
		
		int[] intMassive = new int[]{3,4,10,0,7,1,0,0,8,5,0,15,0,1,9};
		
		IntMassive.getOutMassive(intMassive, "");
		System.out.println();
		System.out.println("Часть 2: нахождение максимального и минимального значения среди элементов массива");
		int minInMassive = IntMinMax.getMinMax(intMassive)[0];
		
		System.out.println();
		System.out.println("Часть 3: нахождение минимального значения среди элементов массива и "
				+ "индексов соответствующих этому значению");
		MinValueIndexes.getMinIndex(minInMassive, intMassive);
		
		System.out.println();
		System.out.println();
		System.out.println("Часть 4: нахождение количества отрицательных элементов массива");
		CountMinusElements.getCountMinusElem(intMassive);
		
		System.out.println();
		System.out.println("Часть 5: нахождение произведения элементов массива до 1го нуля");
		ProductBeforeFirstZero.getProductBeforeFirstZero(intMassive);
		
		System.out.println();
		System.out.println("Часть 6: перестановка нулевых элементов массива в конец");
		MassivePermutationWithZero.getPermutationZero(intMassive);
		
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Дополнительные задания: матрицы");
		
		AdditionalPartMatrix myM = new AdditionalPartMatrix(4);
		
		System.out.println("Часть 7: отобразить последовательность элементов главной и побочной диагонали");
		myM.getDiagonals();
		
		System.out.println("Часть 8: разместить столбцы так, чтобы элементы на главной диагонали были расположены "
				+ "по возрастанию. Если это невозможно - выдать сообщение");
		if(myM.getSortMatrix(0))
			myM.getOutMatrix(" после сортировки главной диагонали");
		else
			System.out.println("не возможно отсортировать");
	}

}

package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class MassivePermutationWithZero {
	
	/**
	 * public static void getPermutationZero( int[] )<br>
	 * <br>
	 * out massive with zero elements in the end of the massive
	 * 
	 * @param intMassive - massive of int values
	 */
	public static void getPermutationZero(int[] intMassive){
		 //этот метод использует рекурсивный метод isPermutationArrya с начальными параметрами,
		 //соответствующими всем элементам массива. И в зависимости от полученного значения
		 //либо выводит массив либо говорит об отсутствии изменений

		IntMassive.getOutMassive(intMassive, "");
		
		if(isPermutationArrya(0,intMassive.length-1,intMassive)){
			IntMassive.getOutMassive(intMassive, "после перестановок");
		}else{
			System.out.println("          массив не изменился");
		}
	}
	
	/**
	 * private static boolean isPermutationArrya( int , int , int[] )<br>
	 * <br>
	 * recursive method. Swap zero element with non-zero
	 * @param startIndex - column index of the start permutation
	 * @param EndIndex - last index of the permutation
	 * @param massPermutation 
	 * @return true if swap is possible
	 */
	private static boolean isPermutationArrya(int startIndex, int EndIndex, int[] massPermutation){
		 //алгоритим: в цикле бежим по элементам массива и как только встречаем нулевой, сравниваем
		 //его со следующим. Если следующий элемент не нулевой то меняем их местами и уходим на новую иттерацию.
		 //Если же следующий элемент тоже нулевой, то запускаем рекурсивный метод со стартовым индексом равным
		 //индексу 2го нулевого элемента, т е 1ый ноль ожидает пока рекурсивный метод переставит на следующую позицию
		 //не нулевой элемент, чтобы в последствии поменять их. Переменная isPA помогает понять, когда все 
		 //последующие элементы равны нулю 
		
		boolean isPA = false;
		
		for(int i = startIndex;i < EndIndex;i++){
			if(massPermutation[i] == 0){
				if(massPermutation[i+1] != 0 || isPermutationArrya(i+1, EndIndex, massPermutation)){
					massPermutation[i] = massPermutation[i+1];
					massPermutation[i+1] = 0;
					isPA = true;
				}
			}
		}
		return isPA;
	}
}

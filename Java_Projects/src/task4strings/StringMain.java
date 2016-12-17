package task4strings;

/**
 * 
 * @author head4max
 *
 */
public class StringMain {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("исходная строка:");
		System.out.println();

		StringBuffer sb = new StringBuffer("34fg #!6k9F0c");
		System.out.println(sb);
		System.out.println();
		
		System.out.println("Часть 1: в английском тексте каждую букву заменить ее порядковым номером в алфавите");
		System.out.println();
		LetterToCode.replaceLetterToCode(sb);
		System.out.println();
		System.out.println();
		
		System.out.println("Часть 2: удалить все символы, кроме пробелов, не являющиеся буквами");
		System.out.println();
		LetterSpaceOnly.deleteNoLetterNoSpace(sb);
		System.out.println();
		
		System.out.println("Часть 3: удалить все слова заданной длины, начинающиеся на согласную букву");
		System.out.println();
		WordWithFirstConsonant.deleteWordDirectLength(sb, 2);
		System.out.println(sb);
		System.out.println();

		System.out.println("Часть 4: проверить все ли символы в строке встречаются один раз");
		System.out.println();
		if(UnicSymbols.isUnicSymbols(sb)){
			System.out.println("символы строки - уникальны");
		}else{
			System.out.println("в строке есть повторяющиеся символы");
		}
		System.out.println();
		
		System.out.println("Часть 5: определите, является ли одна строка перестановкой другой");
		System.out.println();
		String permutStr = "AsaF ";
		if(StringPermutation.isPermutationStrings(sb.toString(), permutStr)){
			System.out.println("строка:" + permutStr + "является перестановкой строки:" + sb);
		}else{
			System.out.println("строки имееют разные наборы символов");
		}
		System.out.println();

//		создаем строку под задачу 6
		sb = new StringBuffer("aaaAffBBbyyyyyu");
		
		System.out.println("Часть 6: Реализуйте метод, осуществляющий "
				+ "сжатие строки, на основе счетчика повторяющихся символов");
		System.out.println();
		System.out.println(sb + " -> " + StringTextOperations.getArchive(sb));
		System.out.println();
		
		System.out.println("Часть 7: для всех элементов, обнулить строку и столбец матрицы MxN, если элемент равен нулю");
		System.out.println();
		AdditionalTaskZeroMatrix myMatrix = new AdditionalTaskZeroMatrix(5,7);
		myMatrix.addZeroAt(1, 3);
		myMatrix.addZeroAt(3, 4);
		myMatrix.getOutMatrix("");
		myMatrix.getMatrixZeroRowColumn();
		
		System.out.println("Часть 8: напишите код проверки, получена ли одна строка циклическим сдвигом другой,"
				+ " используя только один вызов метода isSubstring()");
		System.out.println();
		AdditionalTaskShiftString.isShiftString("teramisu", "misutera");
	}

}

package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class AdditionalPartMatrix {
	private int[][] matrix;
	
	/**
	 * public AdditionalPartMatrix(int , int... )<br>
	 * <br>
	 *  matrix constructor
	 * @param n - matrix range
	 * @param args - matrix will be initialized those values. If values do not enough, last values will be generated by random
	 */
	public AdditionalPartMatrix(int n, int...args){
		 //конструктор квадратной матрицы, принимающий 1ым элементом(обязательно) размерность, остальные же
		 //параметры воспринимаются как элементы матрицы. Если параметров, последующих за 1ым, не хватает, то
		 //остальные элементы матрицы заполнятся рандомными числами в диопазоне [0;99]
		
		int index = 0;
		
		matrix = new int[n][n];
		
		for(int i = 0;i < n;i++){
			for(int j = 0;j<n;j++){
				if(index < args.length){
					matrix[i][j] = args[index];
					index++;
				}else{
					matrix[i][j] = (int)(Math.random()*100);
				}
			}
		}
		this.getOutMatrix("");
	}
	
	/**
	 * public void getDiagonals()<br>
	 * <br>
	 * out direct and indirect diagonals of the matrix
	 */
	public void getDiagonals(){
		System.out.println("элементы главной диагонали матрицы =");
		for(int i =0;i<this.matrix.length;i++){
			System.out.printf("%4d",matrix[i][i]);
		}
		System.out.println();
		System.out.println("элементы побочной диагонали матрицы =");
		for(int i =0;i<this.matrix.length;i++){
			System.out.printf("%4d",matrix[i][this.matrix.length-1-i]);
		}
		System.out.println();
		System.out.println();
	}
	
	/**
	 * public boolean getSortMatrix( int )<br>
	 * <br>
	 * recursive method. Replace the columns for get sorted diagonal
	 * @param startcolumn - column index of the start permutation
	 * @return true if one or more column has been replaced, false - no one replace
	 */
	public boolean getSortMatrix(int startcolumn){

		 /* этот рекурсивный метод опишу по шагам: 1ый if проверяет стартовый столбец на границу размерности, т е 
		    не находимся ли мы на последнем элементе главной диагонали). Если этот элемент больше(либо равен) предыдущего 
		    элемента главной диагонали, то возвращаем значение метода true, а значит досрочно покидаем метод.
		    Если же значение оказалось меньшим, то рапортуем через return, что переставить дальше не удастся.
		    Далее устанавливаем значение предыдущего зафиксированного элемента главной диагонали и заходим в цикл,
		    который бежит по элементам строки начиная со startcolumn элемента. Если элемент зафиксированного элемента
		    больше(либо равен) значения предыдущего элемента главной диагонали, то меняем местами элементы столбцов
		    (текущего и startcolumn) и запускаем рекурсивный метод, начинающийся с (startcolumn+1)го столбца. Если 
		    рекурсивный метод вернет true, то это означает, что перестановка закончена и у нас есть решение. В таком
		    случае мы рекурсивно выйдем из всех методов. Если же вернет false, то возвращаем столбцы в прежнее состояние
		    и уходим на следующую иттерацию */
		
		if(startcolumn == this.matrix.length-1){
			if(this.matrix[this.matrix.length-2][this.matrix.length-2] <= this.matrix[this.matrix.length-1][this.matrix.length-1]){
				return true;
			}else
				return false;
		}
		
		int previusValue = 0;

		if(startcolumn > 0)
			previusValue = matrix[startcolumn-1][startcolumn-1];
		
		for(int j = startcolumn;j<this.matrix.length;j++){
			if(startcolumn == 0)
				previusValue = matrix[0][j];

			if(matrix[startcolumn][j] >= previusValue){
				this.changeColumn(j, startcolumn);
				if(this.getSortMatrix(startcolumn+1)){
					return true;
				}else{
					this.changeColumn(startcolumn, j);
				}
			}
		}
		
		return false;
	}
	
	/**
	 * public void changeColumn( int , int )<br>
	 * <br>
	 * swap two columns
	 * @param firstColumn - column of the matrix
	 * @param secondColumn - column of the matrix
	 */
	public void changeColumn(int firstColumn, int secondColumn){
		// метод который меняет местами элементы 2ух разных столбцов матрицы
		
		if(firstColumn != secondColumn){
			int tempColumn;
			for(int i = 0;i<this.matrix.length;i++){
				tempColumn = this.matrix[i][firstColumn];
				this.matrix[i][firstColumn] = this.matrix[i][secondColumn];
				this.matrix[i][secondColumn] = tempColumn;
			}
			// если разкомментить следующую строку, то можно вывести матрицы на каждой перестановке столбцов
//			this.getOutMatrix("при перестановке " +firstColumn + " и " +secondColumn + " столбцов");
		}
	}
	
	/**
	 * public void getOutMatrix({@link String})<br>
	 * <br>
	 * formated out of the matrix
	 * @param addedString - additional message
	 */
	public void getOutMatrix(String addedString){

		System.out.println("          элементы матрицы " + addedString + ":");
		for(int i = 0;i < this.matrix.length;i++){
			for(int j = 0;j<this.matrix.length;j++){
				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
}

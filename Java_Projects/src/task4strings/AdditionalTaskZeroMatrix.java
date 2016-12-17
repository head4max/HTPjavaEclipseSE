package task4strings;

/**
 * 
 * @author head4max
 *
 */
public class AdditionalTaskZeroMatrix {
private int[][] matrix;
	
	/**
	 * public AdditionalTaskZeroMatrix( int, int)<br>
	 * <br>
	 * matrix constructor. Generate random value for elements of the matrix
	 * @param m - count of the rows
	 * @param n - count of the columns
	 */
	public AdditionalTaskZeroMatrix(int m, int n){
		
		matrix = new int[m][n];
		
		for(int i = 0;i < m;i++){
			for(int j = 0;j<n;j++){
				matrix[i][j] = (int)(Math.random()*100);
			}
		}
		this.getOutMatrix("");
	}
	
	/**
	 * public void addZeroAt( int, int)<br>
	 * <br>
	 * add zero in cell(row, column) of the matrix
	 * @param row - index of row
	 * @param column - index of column
	 */
	public void addZeroAt(int row, int column){
		if(row < this.matrix.length && row >= 0 && column < this.matrix[0].length && column >= 0)
			this.matrix[row][column] = 0;
	}
	
	/**
	 * public void getMatrixZeroRowColumn()<br>
	 * <br>
	 * remember unic indexes of the row and column contains zero elements, then null all elements with remembered indexes
	 */
	public void getMatrixZeroRowColumn(){
		StringBuffer isZeroRow = new StringBuffer("");
		StringBuffer isZeroColumn = new StringBuffer("");
		
		for(int i = 0;i < this.matrix.length;i++){
			for(int j = 0;j<this.matrix[0].length;j++){
				if(matrix[i][j] == 0){
					int indexZeroRow = isZeroRow.indexOf(i + " ");
					int indexZeroColumn = isZeroColumn.indexOf(j + " ");
					if(indexZeroRow == -1){
						isZeroRow.append(i + " ");
					}
					if(indexZeroColumn == -1){
						isZeroColumn.append(j + " ");
					}
				}
			}
		}
		
		for(String row:isZeroRow.toString().split(" ")){
			if(row.length() > 0){
				this.setZeroRow(Integer.valueOf(row));
			}
		}
		
		for(String column:isZeroColumn.toString().split(" ")){
			if(column.length() > 0){
				this.setZeroColumn(Integer.valueOf(column));
			}
		}
		
		this.getOutMatrix("после обнуления строк и столбцов");
	}
	
	/**
	 * public void setZeroRow( int )<br>
	 * <br>
	 * null elements with direct row
	 * @param row - row of the matrix
	 */
	public void setZeroRow(int row){
		for(int j = 0;j<this.matrix[row].length;j++){
			this.matrix[row][j] = 0;
		}
	}
	
	/**
	 * public void setZeroColumn( int )<br>
	 * <br>
	 * null elements with direct column
	 * @param column - column of the matrix
	 */
	public void setZeroColumn(int column){
		for(int i = 0;i < this.matrix.length;i++){
			this.matrix[i][column] = 0;
		}
	}
	
	/**
	 * public void getOutMatrix( {@link String} )<br>
	 * <br>
	 * out matrix
	 * @param addedString - additional string
	 */
	public void getOutMatrix(String addedString){

		System.out.println("          элементы матрицы " + addedString + ":");
		for(int i = 0;i < this.matrix.length;i++){
			for(int j = 0;j<this.matrix[i].length;j++){
				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

package task2types;

/**
 * 
 * @author head4max
 *
 */
public class AdditionalTaskMatrixAndFunction {
	
	/**
	 * public static void getFormattedMatrixAndFunction()<br>
	 * <br>
	 * create matrix with elements follow formula:i*j and out its with {@link System.out.printf},<br>
	 * also out value of the function 2x^2-5x-8 in [{@link startArgument};{@link endArgument}] with step={@link functionStep}
	 */
	public static void getFormattedMatrixAndFunction(){
		int n = 10;
		int[][] matrixSqr = new int[n][n];
	
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrixSqr[i][j]= i*j;
				System.out.printf("%4d", matrixSqr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		double functionStep = 0.5;
		double startArgument = -4;
		double endArgument = 4;
		System.out.println("функция 2x^2-5x-8 на промежутке [" +startArgument + ";" + endArgument + "] принимает следующие значения:");
		for(double index = startArgument;index <= endArgument;index+=functionStep){
			System.out.printf("%.3f", 2*index*index -5*index - 8);
			System.out.print("  ");
		}
		System.out.println();
		System.out.println();
	}
}

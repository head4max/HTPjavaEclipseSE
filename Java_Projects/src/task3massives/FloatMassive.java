package task3massives;

/**
 * 
 * @author head4max
 *
 */
public class FloatMassive {
	private int lengthMassive = 10;
	private float[] fMassive;
	
	/**
	 * public FloatMassive()<br>
	 * <br>
	 * constructor without arguments
	 */
	public FloatMassive(){
		fMassive = new float[lengthMassive];
		for(int i=0;i<lengthMassive;i++){
			fMassive[i]=(float)(Math.random()*50-24);
		}
	}
	
    /**
     * public void getFloatMassive( int )<br>
     * <br>
     *  formated out massive of the float values
     * @param countAfterDotNumb
     */
	public void getFloatMassive(int countAfterDotNumb){

		 // countAfterDotNumb - number of decimal places using in printf
		 
		for(int i = 0;i<(fMassive.length-1);i++){
			System.out.printf("%." + countAfterDotNumb + "f", fMassive[i]);
			System.out.print("|");
		}
		System.out.printf("%." + countAfterDotNumb + "f", fMassive[fMassive.length-1]);
		System.out.println();
	}
}

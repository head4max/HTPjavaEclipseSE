package task14threads;

public class LineOutNumbersThread extends Thread{
	
	static Object EntrySyncBlock ="";
	
	private StringBuilder lineOut;
	private int countOfLineSymb;
	private int stratNumb;
	private int endNumb;
	
	public LineOutNumbersThread(int countOfLineSymb, int stratNumb, int endNumb){
		
		this.countOfLineSymb = countOfLineSymb;
		this.stratNumb = stratNumb;
		this.endNumb = endNumb;
	}
	
	public void run(){
		
		System.out.println("go-go " + this.getName());
		int count = this.stratNumb;
		
		while(count < this.endNumb){
			
			//synchronized(EntrySyncBlock){
				
				
				
				getLineNumbers(count);
				
				//notify();
				
			//}
			count += this.countOfLineSymb;
		}
		
		System.out.println();
		System.out.println(this.getName() + " done");
	}
	
	
	synchronized private void getLineNumbers(int count){
		
		this.lineOut = new StringBuilder("");
		this.lineOut.append(this.getName() + ":");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	
		for(int i = count; i < (count + this.countOfLineSymb); i++){
		
			if(i > 99){
				this.lineOut.append(" " + i);
			} else if(i > 9){
				this.lineOut.append("  " + i);
			} else {
				this.lineOut.append("   " + i);
			}
		}
			
		System.out.println(this.lineOut);
		
		notify();
		
	}
}

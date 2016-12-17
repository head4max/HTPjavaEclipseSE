package task15executorservice;

public class Shopper extends Thread{
	
	private String[] purchases;
//	private int money;

	Shopper(String...purchases){
		this.purchases = purchases;
	}

	@Override
	public void run() {
		
		System.out.println(this.getName() + " подошел к кассе");
		
		try {
			sleep((int)(Math.random()*3000 + 200));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		StringBuilder str = new StringBuilder();
		str.append(this.getClass().getName());
		
		for(int i = 0;i < (purchases.length - 1); i++){
			str.append(purchases[i] + ", ");
		}
		str.append(purchases[purchases.length - 1]);
		
		System.out.println(this.getName() + " купил " +str);
		
	}
}

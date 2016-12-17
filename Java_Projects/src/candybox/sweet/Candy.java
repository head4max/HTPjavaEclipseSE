package candybox.sweet;

import java.util.HashSet;

import candybox.sweetable.Unwrapable;

public abstract class Candy extends Sweetness implements Unwrapable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 17211L;
	protected boolean cover; 
	protected HashSet<String> stuffing;
	
	public Candy(int sugar, int weight, String name){
		super(sugar, weight, name);
		this.cover = true;
	}
	
	/**
	 * @param cover
	 * @param stuffing
	 */
	public Candy(int sugar, int weight, String name, String...stuffing) {
		
		super(sugar, weight, name);
		this.cover = true;
		
		this.stuffing = new HashSet<String>();
		
		for(String s: stuffing){
			this.stuffing.add(s);
		}
	}
	
	@Override
	public void unwrap() {
		if(this.cover){
			System.out.println("обертка " + this.getName() + " шелестит в руках");
			cover = false;
		} else {
			System.out.println("обертки и так нет...");
		}		
	}
	
}

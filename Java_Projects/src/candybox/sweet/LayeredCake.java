package candybox.sweet;

import java.util.ArrayList;

import candybox.sweetable.Sizable;
import candybox.sweetexception.SweetnessWasEatenException;

public class LayeredCake extends Cake<ArrayList<String>> implements Sizable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 17341L;

	
	public LayeredCake(int sugar, int weight, String name, String...args){
		super(sugar, weight, name);

		this.stuffing = new ArrayList<String>();
		
		for(String s: args){
			this.stuffing.add(s);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LayeredCake [" + (stuffing != null ? "stuffing=" + stuffing + ", " : "") + "sugar=" + this.getSugar() + ", "
				+ (this.getName() != null ? "name=" + this.getName() + ", " : "") + "weight=" + this.getWeight() + "]";
	}

	@Override
	public void eat() throws SweetnessWasEatenException {
		if(this.getWeight() > 50){
			this.decreaseWeight(50);
			System.out.println("какое замечательное слоёное пирожное");
		} else {
			this.decreaseWeight(this.getWeight());
			System.out.println("вы облизываете остатки крема на руках...");
			throw new SweetnessWasEatenException();
		}
	}

	@Override
	public void sizeUp() {
		this.increaseWeight(100);		
	}

	@Override
	public void sizeDown() {
		this.decreaseWeight(this.getWeight()/2);
		
	}
	
}

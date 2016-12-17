package candybox.sweet;

import java.io.Serializable;

import candybox.sweetable.Eatable;

public abstract class Sweetness implements Eatable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 17L;
	private int sugar;
	private String name;
	private int weight;
	
	protected Sweetness(int sugar, int weight, String name){
		this.sugar = sugar;
		this.weight = weight;
		this.name = name;
	}
	
	public int getWeight(){
		return this.weight;
	}
	
	public int getSugar(){
		return this.sugar;
	}
	
	public String getName(){
		return this.name;
	}
	
	protected void decreaseWeight(int decrease){
		this.weight -= decrease;
	}
	
	protected void increaseWeight(int increase){
		this.decreaseWeight(-increase);
	}
}

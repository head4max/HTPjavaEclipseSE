package task18pattern;

import java.util.ArrayList;
import java.util.List;

public class Lunch {
	private String firstDish;
	private List<String> secondDish;
	private List<String> thirdDish;
	
	public Lunch(String firstDish, String[] secondDish, String[] thirdDish){
		this.firstDish = firstDish;
		
		this.secondDish = new ArrayList<String>(secondDish.length);
		for(String dish:secondDish){
			this.secondDish.add(dish);
		}
		
		this.thirdDish = new ArrayList<String>(thirdDish.length);
		for(String dish:thirdDish){
			this.thirdDish.add(dish);
		}
	}
	
	public String getFirstDish(){
		return this.firstDish;
	}
	
	public String[] getSecondDish(){
		return this.secondDish.toArray(new String[this.secondDish.size()]);
	}
	
	public String[] getThirdDish(){
		return this.thirdDish.toArray(new String[this.thirdDish.size()]);
	}
}

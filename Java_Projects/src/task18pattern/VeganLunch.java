package task18pattern;

public class VeganLunch implements LunchBuilder {

	private String firstDish = "kale";
	private String[] secondDish = {"kari", "fruitsalad"};
	private String[] thirdDish = {"birchen juice"};
	
	@Override
	public Lunch getLunch() {
		return new Lunch(this.firstDish, this.secondDish, this.thirdDish);
	}
}

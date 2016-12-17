package task18pattern;

public class FishLunchBuilder implements LunchBuilder {

	private String firstDish = "fish soap";
	private String[] secondDish = {"mash", "baked carp"};
	private String[] thirdDish = {"black tee"};
	
	@Override
	public Lunch getLunch() {
		return new Lunch(this.firstDish, this.secondDish, this.thirdDish);
	}
}

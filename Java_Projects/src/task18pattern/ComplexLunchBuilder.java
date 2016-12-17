package task18pattern;

public class ComplexLunchBuilder implements LunchBuilder {
	
	private String firstDish = "schi";
	private String[] secondDish = {"chip", "gamburger"};
	private String[] thirdDish = {"pepsi"};
	
	@Override
	public Lunch getLunch() {
		return new Lunch(this.firstDish, this.secondDish, this.thirdDish);
	}
}

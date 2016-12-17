package task18pattern;

public class VIPLunchBuilder implements LunchBuilder{

	private String firstDish = "julienne";
	private String[] secondDish = {"steak Turedo with vegetables, fungal mash and Fua-Gra"};
	private String[] thirdDish = {"white vine"};
	
	@Override
	public Lunch getLunch() {
		return new Lunch(this.firstDish, this.secondDish, this.thirdDish);
	}
}

package task18pattern;

public class Garcon {
	public static enum Order {COMPLEX_LUNCH, FISH_LUNCH, VEGAN_LUNCH, VIP_LUNCH};
	private LunchBuilder lunchBuilder;
	
	public Garcon(Order order){
		switch(order){
		case COMPLEX_LUNCH:
			lunchBuilder = new ComplexLunchBuilder();
			break;
		case FISH_LUNCH:
			lunchBuilder = new FishLunchBuilder();
			break;
		case VEGAN_LUNCH:
			lunchBuilder = new VeganLunch();
			break;
		case VIP_LUNCH:
			lunchBuilder = new VIPLunchBuilder();
			break;
		}
	}
	
	public Lunch getLunch(){
		return lunchBuilder.getLunch();
	}
}

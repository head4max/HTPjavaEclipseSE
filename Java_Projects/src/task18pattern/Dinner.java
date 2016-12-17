package task18pattern;

public class Dinner {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Lunch firstTableOrder = new Garcon(Garcon.Order.COMPLEX_LUNCH).getLunch();
		Lunch seconfTableOrder = new Garcon(Garcon.Order.VIP_LUNCH).getLunch();
	}

}

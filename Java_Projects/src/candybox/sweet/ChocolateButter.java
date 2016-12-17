package candybox.sweet;

import candybox.sweetable.Butterable;
import candybox.sweetexception.SweetnessWasEatenException;

public class ChocolateButter extends Chocolate implements Butterable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 17361L;
	
	public ChocolateButter(int sugar, int cacao, int weight, String name){
		super(sugar, weight, name, cacao, "без формы");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChocolateButter [cacao=" + this.getCacao() + ", " + "sugar=" + this.getSugar()
				+ ", " + (this.getName() != null ? "name=" + this.getName() + ", " : "") + "weight=" + this.getWeight() + "]";
	}

	@Override
	public void butter() throws SweetnessWasEatenException {
		if(this.getWeight() > 25){
			this.decreaseWeight(25);
			System.out.println("взяв ломоть хлеба вы медленно намазываете масло, а затем кладете его в рот");
		} else {
			this.decreaseWeight(this.getWeight());
			System.out.println("на дне пусто...эээх");
			throw new SweetnessWasEatenException();
		}
	}
	
	@Override
	public void eat(){
		System.out.println("попробовав самую малость вы понимаете, что без хлеба есть шокладное масло было бы кощунством");
	}
}

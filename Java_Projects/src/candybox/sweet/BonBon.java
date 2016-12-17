package candybox.sweet;

import candybox.sweetable.Lickable;
import candybox.sweetexception.SweetnessWasEatenException;

public class BonBon extends Candy implements Lickable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 17311L;
	private String caramelType;
	
	/**
	 * @param caramelType
	 */
	public BonBon(String caramelType, int sugar, int weight, String name, String ingrs) {
		
		super(sugar, weight, name, ingrs);

		this.caramelType = caramelType;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BonBon [" + (caramelType != null ? "caramelType=" + caramelType + ", " : "") + "sugar=" + this.getSugar() + ", "
				+ (this.getName() != null ? "name=" + this.getName() + ", " : "") + "weight=" + this.getWeight() + "]";
	}

	@Override
	public void eat() {
		if(!this.cover){
			System.out.println("леденец кажется вам достаточно твердым, чтобы его просто раскусить" + this.getName());
		} else {
			System.out.println("вы чувствуете зубами обертку леденца...для начала лучше развернуть");
		}		
	}

	@Override
	public void lick() throws SweetnessWasEatenException {
		if(!this.cover){
			this.decreaseWeight(this.getWeight());
			System.out.println("леденец быстро тает у вас во рту...");
			throw new SweetnessWasEatenException();
		} else {
			System.out.println("вы чувствуете зубами обертку леденца...для начала лучше развернуть");
		}		
	}

}

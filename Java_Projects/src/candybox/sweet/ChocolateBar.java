package candybox.sweet;

import candybox.sweetable.Crushable;
import candybox.sweetable.Unwrapable;
import candybox.sweetexception.SweetnessWasEatenException;

public class ChocolateBar extends Chocolate implements Crushable, Unwrapable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 17351L;
	private boolean cover;
	private int count;
	
	public ChocolateBar(int sugar, int weight, String name, int cacao, int count){
		super(sugar, weight, name, cacao, "BAR");
		this.count = count;
		this.cover = true;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChocolateBar [cover=" + cover + ", count=" + count + ", cacao=" + this.getCacao() + ", "
				+ (this.getForm() != null ? "form=" + this.getForm() + ", " : "") + "sugar=" + this.getSugar() + ", "
				+ (this.getName() != null ? "name=" + this.getName() + ", " : "") + "weight=" + this.getWeight() + "]";
	}

	@Override
	public Object crush() {
		if(this.count > 4){
			this.count -= 4;
			return (Object)(new ChocolateBar(this.getSugar(), this.getCacao(), this.getName(), this.getWeight() * 4 / (this.count + 4), 4));
		} else {
			this.decreaseWeight(this.getWeight());
			return (Object)(new ChocolateBar(this.getSugar(), this.getWeight(), this.getName(), this.getCacao(), this.count));
		}
	}
	
	@Override
	public void eat() throws SweetnessWasEatenException {
		if(!this.cover){
			if(this.count > 4){
				this.count -= 4;
				this.decreaseWeight(this.getWeight()*4/(this.count+4));
			} else {
				this.count = 0;
				this.decreaseWeight(this.getWeight());
				System.out.println("это были последние кусочки замечательного шоколада " + this.getName());
				throw new SweetnessWasEatenException();
			}
		} else {
			System.out.println("фальга в обертке мешают вам полакомиться шоколадом");
		}
	}

	@Override
	public void unwrap() {
		if(this.cover){
			System.out.println("обертка " + this.getName() + " шелестит в руках");
			cover = false;
		} else {
			System.out.println("обертка скомкана до середины...кто-то её уже вскрыл");
		}
	}
}

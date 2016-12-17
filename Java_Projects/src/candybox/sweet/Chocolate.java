package candybox.sweet;

import candybox.sweetable.Formable;
import candybox.sweetable.Sizable;
import candybox.sweetexception.SweetnessWasEatenException;

public class Chocolate extends Sweetness implements Formable, Sizable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 17231L;
	
	private int cacao;
	private String form;
	
	public Chocolate(int sugar, int weight, String name, int cacao, String form){
		super(sugar, weight, name);
		this.cacao = cacao;
		this.form = form;
	}
	
	/**
	 * @return the cacao
	 */
	public int getCacao() {
		return cacao;
	}

	/**
	 * @return the form
	 */
	public String getForm() {
		return form;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Chocolate [cacao=" + cacao + ", " + (form != null ? "form=" + form + ", " : "") + "sugar=" + this.getSugar()
				+ ", " + (this.getName() != null ? "name=" + this.getName() + ", " : "") + "weight=" + this.getWeight() + "]";
	}

	@Override
	public void eat() throws SweetnessWasEatenException {
		
		if(this.getWeight() > 50){
			this.decreaseWeight(50);
			System.out.println("ням-ням, вкусный шоколад");
		} else {
			this.decreaseWeight(this.getWeight());
			System.out.println("последние кусочки шоколада тают у вас на глазах");
			throw new SweetnessWasEatenException();
		}
	}

	@Override
	public void morf(String form) {
		
		if(this.form == null){
			this.form = form;
			System.out.println("вы придали шоколаду форму " + this.form);
		} else {
			System.out.println("у шоколада уже есть форма " + this.form);
		}
	}

	@Override
	public void sizeUp() {
		this.increaseWeight(200);		
	}

	@Override
	public void sizeDown() {
		this.decreaseWeight(this.getWeight()/5);		
	}
}

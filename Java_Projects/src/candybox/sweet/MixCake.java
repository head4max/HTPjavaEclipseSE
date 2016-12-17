package candybox.sweet;

import java.util.HashSet;

import candybox.sweetable.Formable;
import candybox.sweetexception.SweetnessWasEatenException;

public class MixCake extends Cake<HashSet<String>> implements Formable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 17331L;
	private String form;

	
	public MixCake(int sugar, int weight, String name, String form,  String...args){
		
		super(sugar, weight, name);
		this.form = form;

		this.stuffing = new HashSet<String>();
		
		for(String s: args){
			this.stuffing.add(s);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MixCake [" + (form != null ? "form=" + form + ", " : "") + "sugar=" + this.getSugar() + ", "
				+ (this.getName() != null ? "name=" + this.getName() + ", " : "") + "weight=" + this.getWeight() + "]";
	}

	@Override
	public void eat() throws SweetnessWasEatenException {
		if(this.getWeight() > 50){
			this.decreaseWeight(50);
			System.out.println("какое замечательное пирожное");
		} else {
			this.decreaseWeight(getWeight());
			System.out.println("остались только крошки на ваших руках...");
			throw new SweetnessWasEatenException();
		}
		
	}

	@Override
	public void morf(String form) {
		if(this.form == null){
			this.form = form;
			System.out.println("вы придали пирожному форму " + this.form);
		} else {
			System.out.println("у пирожного уже есть форма " + this.form);
		}
	}

}

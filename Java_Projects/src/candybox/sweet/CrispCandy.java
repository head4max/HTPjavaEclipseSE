package candybox.sweet;

import candybox.sweetexception.SweetnessWasEatenException;

public class CrispCandy extends Candy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 17321L;
	private String glaze;
	
	public CrispCandy(String glaze, int sugar, int weight, String name, String...ingrs){
		
		super(sugar, weight, name, ingrs);
		
		this.glaze = glaze;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CrispCandy [" + (glaze != null ? "glaze=" + glaze + ", " : "") + "sugar=" + this.getSugar() + ", "
				+ (this.getName() != null ? "name=" + this.getName() + ", " : "") + "weight=" + this.getWeight() + "]";
	}

	@Override
	public void eat() throws SweetnessWasEatenException {
		
		if(!this.cover){
			if(this.getWeight() > 4){
				this.decreaseWeight(4);
			} else {
				this.decreaseWeight(this.getWeight());
				System.out.println("вкусная конфета...подумали вы");
				throw new SweetnessWasEatenException();
			}
		} else {
			System.out.println("блестящая обертка намекат на то, что лучше бы её развернуть");
		}
	}

}

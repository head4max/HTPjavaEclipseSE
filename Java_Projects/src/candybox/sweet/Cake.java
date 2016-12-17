package candybox.sweet;

import java.util.Collection;

public abstract class Cake<T extends Collection<?>> extends Sweetness {
	
	private static final long serialVersionUID = 17221L;
	protected T stuffing;
	
	protected Cake(int sugar, int weight, String name) {
		super(sugar, weight, name);
	}
}

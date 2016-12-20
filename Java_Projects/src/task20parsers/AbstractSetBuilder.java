package task20parsers;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSetBuilder<T> implements SetInit{
	private Set<T> objectSet;
	protected String fileName = "objects.xml";
	
	public AbstractSetBuilder(){
		this.objectSet = new HashSet<T>();
		setInit();
	}
	
	public AbstractSetBuilder(Set<T> objectSet){
		this.objectSet = objectSet;
	}
	
	public Set<T> getSet(){
		return this.objectSet;
	}
}

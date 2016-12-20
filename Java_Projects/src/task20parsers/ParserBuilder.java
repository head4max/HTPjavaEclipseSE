package task20parsers;

import java.util.Set;

public class ParserBuilder {
	public static enum Parser{DOM,SAX,STAX};
	
	private ParserBuilder(){
	}
	
	public static <T> Set<T> getSet(Parser parser){
		switch(parser){
		case DOM:
			return new DOMSetBuilder<T>().getSet();
		case SAX:
			return new SAXSetBuilder<T>().getSet();
		case STAX:
			return new STaXSetBuilder<T>().getSet();
		default:
			return new DOMSetBuilder<T>().getSet();
		}
	}
}

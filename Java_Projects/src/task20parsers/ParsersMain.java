package task20parsers;

import java.util.Set;

import task20parsers.ParserBuilder.Parser;

public class ParsersMain {

	public static void main(String[] args) {
		
		Set<?> hsObject  = ParserBuilder.getSet(Parser.SAX);
		System.out.println(hsObject);
	}

}

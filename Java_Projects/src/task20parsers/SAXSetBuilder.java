/**
 * 
 */
package task20parsers;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author head4max
 *
 */
public class SAXSetBuilder<T> extends AbstractSetBuilder<T> {
	
	private DefaultHandler objectHandler;
	private XMLReader reader;

	/* (non-Javadoc)
	 * @see task20parsers.SetInit#setInit()
	 */
	@Override
	public void setInit() {
		
		// создание SAX-анализатора
		objectHandler = new DefaultHandler() {
			//override handler method
		};
		try {
		// создание объекта-обработчика
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(objectHandler);
		} catch (SAXException e) {
			System.err.print("ошибка SAX парсера: " + e);
		}
	}

}

/**
 * 
 */
package task20parsers;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author head4max
 *
 */
public class DOMSetBuilder<T> extends AbstractSetBuilder<T> {

	private Document doc = null;
	private DocumentBuilder docBuilder;
	
	@Override
	public void setInit() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			docBuilder = factory.newDocumentBuilder();
		
		// parsing XML-документа и создание древовидной структуры
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
		// получение списка дочерних элементов <student>
			@SuppressWarnings("unused")
			NodeList studentsList = root.getElementsByTagName("T");
				

		}catch(IOException e) {
			System.err.println("File error or I/O error: " + e);
		}catch(SAXException e) {
			System.err.println("Parsing failure: " + e);
		}catch(ParserConfigurationException e) {
			System.err.println("Ошибка конфигурации парсера: " + e);
		}
	}

}

/**
 * 
 */
package task20parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author head4max
 *
 */
public class STaXSetBuilder<T> extends AbstractSetBuilder<T> {

	private XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	/* (non-Javadoc)
	 * @see task20parsers.SetInit#setInit()
	 */
	@Override
	public void setInit() {
		
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;

		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			// StAX parsing
			while (reader.hasNext()) {
				//set objects from .xml file into set
			}
		} catch (XMLStreamException ex) {
			System.err.println("StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			System.err.println("File " + fileName + " not found! " + ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				System.err.println("Impossible close file " + fileName + " : " + e);
			}
		}

	}

}

package xmlclasswork;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TestXSDXSLMain {

	public static void main(String[] args) {
		
		String filename = "src/xmlclasswork/students.xml";
		String schemaName = "src/xmlclasswork/students.xsd";

		try {

			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parser.parse(new File(filename));
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source schemaFile = new StreamSource(new File(schemaName));
			Schema schema = factory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(new DOMSource(document));
			
			System.out.println(filename + " is valid");
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.out.println(filename + " is invalid");
		}
		
		String fileNameXSL = "src/xmlclasswork/students.xsl";
		String fileNameXML = "src/xmlclasswork/students.xml";
		String fileNameHTML = "src/xmlclasswork/stud.html";
		
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer(new StreamSource(fileNameXSL));
			transformer.transform(new StreamSource(fileNameXML), new StreamResult(fileNameHTML));
			System.out.println("Transform " + " complete");
			
		} catch (TransformerException e) {
			System.err.println("Impossible transform file " + " : " + e);
		}

	}

}

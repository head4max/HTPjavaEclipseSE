package module2finaltask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
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

import module2finaltask.Plant.Multiplying;
import module2finaltask.Plant.Soil;

public class utilXmlXsdXslMain {

	public static void main(String[] args) {
		
		String filename = "src/module2finaltask/Orangery.xml";
		String schemaName = "src/module2finaltask/Orangery.xsd";

//		check for valid "filename"(xml)->"schemaName"(xsd)
		try {

			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parser.parse(new File(filename));
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source schemaFile = new StreamSource(new File(schemaName));
			Schema schema = factory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(new DOMSource(document));
			
			System.out.println(filename + " is valid for " + schemaName);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.out.println(filename + " is invalid for " + schemaName);
		}
		
		System.out.println();
		System.out.println();
		
//		parsing by StaX parser
		
		XMLInputFactory f = XMLInputFactory.newInstance();
		XMLStreamReader readerXML;
		List<Plant> orangery = new ArrayList<>();
		try {
			readerXML = f.createXMLStreamReader(new FileInputStream(filename));
			Plant plant = new Plant();
			int[] growingTips = new int[2];
			
			while(readerXML.hasNext()) {
				int event = readerXML.next();
				
				switch(event){
				
		        case XMLStreamConstants.START_ELEMENT:
		        	if(readerXML.getLocalName().equals("Orangery")) {
		        	} else if(readerXML.getLocalName().equals("plant")) {
		        		plant = new Plant();
		        	} else if(readerXML.getLocalName().equals("name")) {
		        		plant.setName(readerXML.getElementText());
		        	} else if(readerXML.getLocalName().equals("soil")) {
		        		switch(readerXML.getElementText().length()) {
		        		case 7:
		        			plant.setSoil(Soil.ENTISOL);
		        			break;
		        		case 11:
		        			plant.setSoil(Soil.FAT_ENTISOL);
		        		}
		        	} else if(readerXML.getLocalName().equals("visualParametr")) {
		        		plant.setVisualParametrs(readerXML.getAttributeValue(0), Integer.valueOf(readerXML.getAttributeValue(1)));
		        		
		        	} else if(readerXML.getLocalName().equals("origin")) {
		        		plant.setOrigin(readerXML.getElementText());
		        		
		        	} else if(readerXML.getLocalName().equals("temperature")) {
		        		growingTips[0] = Integer.valueOf(readerXML.getElementText());
		        		
		        	} else if(readerXML.getLocalName().equals("watering")) {
		        		growingTips[1] = Integer.valueOf(readerXML.getElementText());
		        		
		        	} else if(readerXML.getLocalName().equals("multiplying")) {
		        		if(readerXML.getElementText().equals("shaft")) {
		        			plant.setMultiplying(Multiplying.SHAFT);
		        		}
		        	}
		        	
		          break;
		           
		        case XMLStreamConstants.END_ELEMENT:
		          if(readerXML.getLocalName().equals("plant")) {
		        	  orangery.add(plant);
		          } else if(readerXML.getLocalName().equals("growingTips")) {
		        	  plant.setGrowingTips(growingTips[0], growingTips[1]);
		          }
		          break;
		      }
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		
		Collections.sort(orangery, new Comparator<Plant>(){
			@Override
			public int compare(Plant o1, Plant o2) {
				return o1.getTemperature() > o2.getTemperature() ? 1 : (o1.getTemperature() < o2.getTemperature() ? -1 : 0);
			}
			
		});
		
		System.out.println("orangery collection:");
		for(Plant p:orangery){
			System.out.println(p);
		}
		
		
//		transformation Orangery.xml in OrangeryTable.html by Orangery.xsl
		
		System.out.println();
		System.out.println();
		
		String fileNameXSL = "src/module2finaltask/Orangery.xsl";
		String fileNameXML = "src/module2finaltask/Orangery.xml";
		String fileNameHTML = "src/module2finaltask/OrangeryTable.html";
		
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

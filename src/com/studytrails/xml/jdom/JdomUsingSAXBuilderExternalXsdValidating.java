package com.studytrails.xml.jdom;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderSchemaFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;
import org.xml.sax.SAXException;

public class JdomUsingSAXBuilderExternalXsdValidating {

	private static String file = "commons-dbcp-pom.xml";
	private static String schemaFile = "maven-4.0.0.xsd";

	public static void main(String[] args) throws JDOMException, IOException, SAXException {

		// Define a schema factory and a schema
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File(schemaFile));
		
		//METHOD 1
		
		// create an XMLReaderJDOMFactory by passing the schema
		XMLReaderJDOMFactory factory = new XMLReaderSchemaFactory(schema);
		// create a SAXBuilder using the XMLReaderJDOMFactory
		SAXBuilder sb = new SAXBuilder(factory);
		Document doc = sb.build(new File(file));
		System.out.println(doc.getRootElement().getName());
		
		//METHOD 2
		
		
		File xsd = new File(schemaFile);
		//Create the XMLReaderJDOMFacotory directly using the schema file instead of 'Schema'
		XMLReaderJDOMFactory factory2 = new XMLReaderXSDFactory(schemaFile);
		SAXBuilder sb2 = new SAXBuilder(factory2);
		Document doc2 = sb2.build(new File(file));
		System.out.println(doc2.getRootElement().getName());

	}
}

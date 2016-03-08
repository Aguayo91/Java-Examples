package com.studytrails.xml.jaxp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class JaxpValidationExample5 {
	private static String file1 = "tomcat-web-dtd-bad.xml";
	private static String schemaFile = "maven-4.0.0.xsd";

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
		JaxpValidationExample5 validator = new JaxpValidationExample5();
		// validate the DOM representation of XML against DTD
		validator.validateDTDDom();
		// validate the SAX representation of XML against DTD
		validator.validateDTDSax();

		// there's no validating the StAX representation of XMl using DTD :-(

		// validate the DOM representation of XML using XSD
		validator.validateXSDDom();
		// validate the SAX representation of XML using XSD
		validator.validateXSDSax();
		// validate the StAX representation of XML using XSD
		validator.validateXSDStax();
	}

	private void validateXSDStax() throws XMLStreamException, IOException {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(schemaFile));
			Validator validator = schema.newValidator();
			XMLInputFactory xmlFactory = XMLInputFactory.newFactory();
			XMLEventReader reader = xmlFactory.createXMLEventReader(new FileInputStream(file1));
			validator.validate(new StAXSource(reader));
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

	private void validateXSDSax() throws ParserConfigurationException, IOException {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(schemaFile));
			Validator validator = schema.newValidator();

			validator.validate(new SAXSource(new InputSource(new FileInputStream(new File(file1)))));
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	private void validateXSDDom() throws IOException, ParserConfigurationException {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file1);
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(schemaFile));
			Validator validator = schema.newValidator();

			validator.validate(new DOMSource(doc));
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	public void validateDTDDom() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document bbcDoc = builder.parse(file1);
		// throws error
	}

	public void validateDTDSax() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		saxParserFactory.setValidating(true);
		SAXParser parser = saxParserFactory.newSAXParser();

		parser.parse(file1, new MyDefaultHandler());
	}

	class MyDefaultHandler extends DefaultHandler {
		boolean parsingTitle = false;

		@Override
		public void warning(SAXParseException e) throws SAXException {
			System.out.println(e.getMessage());
		}

		@Override
		public void error(SAXParseException e) throws SAXException {
			System.out.println(e.getMessage());
		}

		@Override
		public void fatalError(SAXParseException e) throws SAXException {
			System.out.println(e.getMessage());
		}

	}
}

package com.studytrails.xml.jaxp;

import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class JaxpSAXExample2 {

	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		JaxpSAXExample2 example = new JaxpSAXExample2();
		example.startParsing();

	}

	void startParsing() throws ParserConfigurationException, SAXException, IOException {
		// create the factory that will create hte parser
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser parser = saxParserFactory.newSAXParser();
		// JAXP provides a default xerces SAX Parser
		System.out.println(parser.getClass());
		// prints class com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl
		// which is the default SAXParser in JAXP.

		XMLReader reader = parser.getXMLReader();
		System.out.println(reader.getClass());

		// MyDefaultHandler extends the DefaultHandler. It contains the business
		// logic that handles the various XML component related events.
		parser.parse(xmlSource, new MyDefaultHandler());

		System.out.println(parser.isNamespaceAware());
		// prints false. The parser is not namespace aware by default

		System.out.println(parser.isValidating());
		// prints false. The parser, by default, does not validate.
	}

	class MyDefaultHandler extends DefaultHandler {
		boolean parsingTitle = false;

		@Override
		public void startDocument() throws SAXException {
			System.out.println("Start parsing the document");
		}

		@Override
		public void startPrefixMapping(String prefix, String uri) throws SAXException {
			System.out.println("start::" + prefix);
			System.out.println(uri);
		}

		@Override
		public void endPrefixMapping(String prefix) throws SAXException {
			System.out.println("end::" + prefix);
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if ("title".equals(qName))
				parsingTitle = true;
			else
				parsingTitle = false;
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			if (parsingTitle) {
				System.out.println(Arrays.copyOfRange(ch, start, start + length));
				// System.out.println(start);
				// System.out.println(length);
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if ("title".equals(qName))
				parsingTitle = false;
		}

	}
}

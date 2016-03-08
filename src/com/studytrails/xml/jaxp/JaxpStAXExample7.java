package com.studytrails.xml.jaxp;

import java.io.IOException;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class JaxpStAXExample7 {
	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws XMLStreamException, IOException { 
		//create the input factory
		XMLInputFactory factory = XMLInputFactory.newFactory();
		URL url = new URL(xmlSource);
		// obtain a stream reader
		XMLStreamReader streamReader = factory.createXMLStreamReader(url.openStream());
		//keep moving the cursor forward
		while (streamReader.hasNext()) {
			int event = streamReader.next();
			// check if the element that the cursor is currently pointing to is a start element
			if (event == XMLEvent.START_ELEMENT) {
				// if the cursor is pointing to a start element then get its name
				String name = streamReader.getName().getLocalPart();
				if ("Rss".equals(name)) {
					handleRSSElement(streamReader);
				} else if ("channel".equals(name))
					handleChannel(streamReader);
			}
		}
	}

	private static void handleChannel(XMLStreamReader streamReader) throws XMLStreamException {
		while (streamReader.hasNext()){
			int nextEventType = streamReader.next();
			if (nextEventType==XMLEvent.START_ELEMENT){
				String name = streamReader.getName().getLocalPart();
				if ("title".equals(name)){
					// move the cursor one position forward to read the text
					streamReader.next();
					System.out.println(streamReader.getText());
				}
			}
		}
		
	}

	private static void handleRSSElement(XMLStreamReader streamReader) {
		int noOfNamespaces = streamReader.getNamespaceCount();
		for (int i = 0; i < noOfNamespaces; i++) {
			System.out.println(streamReader.getNamespacePrefix(i));
			System.out.println(streamReader.getNamespaceURI(i));
		}

	}
}

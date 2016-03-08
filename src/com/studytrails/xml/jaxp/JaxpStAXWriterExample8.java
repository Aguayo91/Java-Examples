package com.studytrails.xml.jaxp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class JaxpStAXWriterExample8 {
	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws XMLStreamException, IOException {
		JaxpStAXWriterExample8 writer = new JaxpStAXWriterExample8();
		writer.writeUsingEventWriter();
	}

	public void writeUsingEventWriter() throws XMLStreamException, IOException {
		// create the input factory for obtaining the event reader
		XMLInputFactory factory = XMLInputFactory.newFactory();
		// create the output factory for obtainin the event writer
		XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
		URL url = new URL(xmlSource);

		// create the event reader
		XMLEventReader reader = factory.createXMLEventReader(url.openStream());
		// creae the event writer
		XMLEventWriter writer = outputFactory.createXMLEventWriter(new FileOutputStream(new File("modified.xml")));

		// the xmlEventFactory can be used to create new XMLEvents of any
		// specific type.
		XMLEventFactory xmlEventFactory = XMLEventFactory.newFactory();
		while (reader.hasNext()) {
			XMLEvent nextEvent = reader.nextEvent();
			if (nextEvent.getEventType() == XMLEvent.START_ELEMENT) {
				StartElement startElement = nextEvent.asStartElement();
				writer.add(startElement);
				if ("title".equals(startElement.getName().getLocalPart())) {
					XMLEvent titleTextEvent = reader.nextEvent();
					String titleText = titleTextEvent.asCharacters().getData();
					// modify the title text
					titleText = "StudyTrails:" + titleText;
					// create a new character event using the modified text and
					// add the new title instead of the existing one
					XMLEvent newTitleTextEvent = xmlEventFactory.createCharacters(titleText);
					writer.add(newTitleTextEvent);
				}
			} else {
				writer.add(nextEvent);
			}
		}
		writer.flush();
		writer.close();
		reader.close();
	}
}

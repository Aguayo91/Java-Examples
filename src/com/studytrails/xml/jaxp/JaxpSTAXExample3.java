package com.studytrails.xml.jaxp;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class JaxpSTAXExample3 {

	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws XMLStreamException, IOException {
		// the XMLInputfactory helps in creating the reader for the XML document
		XMLInputFactory factory = XMLInputFactory.newFactory();
		URL url = new URL(xmlSource);
		// the reader is the main interface that wraps the parser.
		XMLEventReader reader = factory.createXMLEventReader(url.openStream());
		System.out.println(reader.getClass());

		// continue iterating through the reader events till they are available.
		while (reader.hasNext()) {
			// peek at the next event without actually retrieving it
			XMLEvent event = reader.peek();
			// the type of event can be identified
			if (event.getEventType() == XMLEvent.START_ELEMENT) {
				event = reader.nextEvent();
				StartElement startElement = event.asStartElement();
				// System.out.println(startElement.getName().getLocalPart());
				if ("Rss".equals(startElement.getName().getLocalPart()))
					handleRSSElement(startElement);
				if ("channel".equals(startElement.getName().getLocalPart()))
					handleChannel(reader);

			}
			if (reader.hasNext())
				reader.next();
		}

	}

	private static void handleChannel(XMLEventReader reader) throws XMLStreamException {
		while (reader.hasNext()) {
			XMLEvent event = reader.peek();
			if (event.isStartElement()) {
				StartElement startElement = reader.nextEvent().asStartElement();
				if ("title".equals(startElement.getName().getLocalPart())) {
					// System.out.println(reader.nextEvent().asCharacters().getData());
				} else if ("image".equals(startElement.getName().getLocalPart())) {
					// create an image object from an image element. This also demonstrates a very basic way of XML-POJO binding.
					Image image = getImage(reader);
					System.out.println("url::" + image.getUrl());
				}
			} else
				reader.next();
		}
	}

	// bind the Image4 POJO to the XML 'image' element.
	private static Image getImage(XMLEventReader reader) throws XMLStreamException {
		Image image = new Image();
		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if (event.isStartElement()) {
				String name = event.asStartElement().getName().getLocalPart().trim();
				if (name.equals("url"))
					image.url = reader.nextEvent().asCharacters().getData();
				else if (name.equals("title"))
					image.title = reader.nextEvent().asCharacters().getData();
				else if (name.equals("link"))
					image.link = reader.nextEvent().asCharacters().getData();
				else if (name.equals("width"))
					image.width = reader.nextEvent().asCharacters().getData();
				else if (name.equals("height"))
					image.height = reader.nextEvent().asCharacters().getData();

			} else if (event.isEndElement()) {
				String name = event.asEndElement().getName().getLocalPart().trim();
				if (name.equals("image"))
					break;

			}
		}
		return image;
	}

	private static void handleRSSElement(StartElement startElement) throws XMLStreamException {
		// find out the namespaces in an element
		Iterator<Namespace> namespaces = startElement.getNamespaces();
		while (namespaces.hasNext()) {
			Namespace namespace = namespaces.next();
			System.out.println(namespace.getPrefix());
			System.out.println(namespace.getNamespaceURI());
		}

	}

	static class Image {
		static String url;
		static String title;
		static String link;
		static String width;
		static String height;

		public static String getUrl() {
			return url;
		}

	}
}

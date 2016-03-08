package com.studytrails.xml.jdom;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.StAXEventBuilder;

public class JdomUsingXMLEventReader {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException, JDOMException {
		XMLInputFactory factory = XMLInputFactory.newFactory();

		XMLEventReader reader = factory.createXMLEventReader(new FileReader("bbc.xml"));

		StAXEventBuilder builder = new StAXEventBuilder();
		Document jdomDoc = builder.build(reader);
		System.out.println(jdomDoc.getRootElement().getName()); // prints "Rss"
		System.out.println(jdomDoc.getRootElement().getNamespacesIntroduced().get(1).getURI()); // prints "http://search.yahoo.com/mrss/"

	}
}

package com.studytrails.xml.jdom;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.StAXStreamBuilder;

public class JdomUsingXMLStreamReader {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException, JDOMException {
		XMLInputFactory factory = XMLInputFactory.newFactory();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("bbc.xml"));

		StAXStreamBuilder builder = new StAXStreamBuilder();
		Document jdomDoc = builder.build(reader);
		System.out.println(jdomDoc.getRootElement().getName());  // prints "Rss"
		System.out.println(jdomDoc.getRootElement().getNamespacesIntroduced().get(1).getURI());// prints "http://search.yahoo.com/mrss/"
	}
}

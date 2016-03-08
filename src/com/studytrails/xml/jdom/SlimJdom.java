package com.studytrails.xml.jdom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.SlimJDOMFactory;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

public class SlimJdom {
	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder dombuilder = factory.newDocumentBuilder();
		org.w3c.dom.Document w3cDocument = dombuilder.parse(xmlSource);
		
		System.out.println(Runtime.getRuntime().freeMemory());
		
		DOMBuilder jdomBuilder = new DOMBuilder();
		jdomBuilder.setFactory(new SlimJDOMFactory());
		Document jdomDocument = jdomBuilder.build(w3cDocument);
		System.out.println(Runtime.getRuntime().freeMemory());
		
		DOMBuilder jdomBuilder2 = new DOMBuilder();
		Document jdomDocument2 = jdomBuilder2.build(w3cDocument);
		System.out.println(Runtime.getRuntime().freeMemory());
		
		
		
		
		
	}
}

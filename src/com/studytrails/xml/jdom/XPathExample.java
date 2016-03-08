package com.studytrails.xml.jdom;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.input.DOMBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.xml.sax.SAXException;

public class XPathExample {
	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// read the xml into a JDOM2 document.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder dombuilder = factory.newDocumentBuilder();

		org.w3c.dom.Document w3cDocument = dombuilder.parse(xmlSource);
		DOMBuilder jdomBuilder = new DOMBuilder();
		Document jdomDocument = jdomBuilder.build(w3cDocument);

		// use the default implementation
		XPathFactory xFactory = XPathFactory.instance();
		// System.out.println(xFactory.getClass());

		// select all links
		XPathExpression expr = xFactory.compile("//link");
		List links = expr.evaluate(jdomDocument);
		for (Object link : links) {
			if (link instanceof Element) {
				Element linkElement = (Element) link;
				System.out.println(linkElement.getValue());
			}
		}

		// select all links in image element
		expr = xFactory.compile("//image/link");
		List links2 = expr.evaluate(jdomDocument);
		for (Object link : links2) {
			if (link instanceof Element) {
				Element linkElement = (Element) link;
				System.out.println(linkElement.getValue());
			}
		}

		// get the media namespace
		Namespace media = jdomDocument.getRootElement().getNamespace("media");
		// find all thumbnail elements from the media namespace where the
		// attribute widht has a value > 60
		expr = xFactory.compile("//media:thumbnail[@width>60.00]", Filters.fpassthrough(), null, media);
		System.out.println(((Element)
		// find the first element in the document and get its attribute named
		// 'url'
				expr.evaluateFirst(jdomDocument)).getAttributeValue("url"));

		// find the child element of channel whose name is title. find the
		// descendant of item with name title.
		Element firstTitle = (Element) xFactory.compile("//channel/child::item/descendant::title").evaluateFirst(jdomDocument);
		System.out.println(firstTitle.getValue());

	}

}

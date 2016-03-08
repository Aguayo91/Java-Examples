package com.studytrails.xml.jaxp;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JaxpXpathExample6 {
	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		// create the DOM Document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document bbcDoc = builder.parse(xmlSource);

		// create the JAXP XPath evaluation environment.
		XPath xpath = XPathFactory.newInstance().newXPath();

		// creat an xpath expression. This example select all nodes with the
		// name 'link' from the root of the document.
		String expression = "//link";
		// get a list of nodes using the xpath environment, DOM Document and the
		// XPath expression. Specify the type of node that is retrived (in this
		// case its a NODESET which is a list of nodes)
		NodeList linkNodes = (NodeList) xpath.evaluate(expression, bbcDoc, XPathConstants.NODESET);
		for (int i = 0; i < linkNodes.getLength(); i++) {
			// System.out.println(linkNodes.item(i).getTextContent());
		}

		// get the element with name item from parent with name 'channel' whose
		// parent is an element with name 'Rss'
		expression = "/Rss/channel/item";
		NodeList itemNodes = (NodeList) xpath.evaluate(expression, bbcDoc, XPathConstants.NODESET);
		for (int i = 0; i < itemNodes.getLength(); i++) {
			String expression2 = "title";
			// the resulting node of an XPath evaluation can also be the source
			// of another XPath query. In this case we query for all 'title'
			// elements under '/Rss/channel/item'
			Node titleInItemNode = (Node) xpath.evaluate(expression2, itemNodes.item(i), XPathConstants.NODE);
			// System.out.println(titleInItemNode.getTextContent());
		}

		// another way to find the title of all item elements
		expression = "//channel/child::item/descendant::title";
		NodeList someNodes = (NodeList) xpath.evaluate(expression, bbcDoc, XPathConstants.NODESET);
		for (int i = 0; i < someNodes.getLength(); i++) {
			System.out.println(someNodes.item(i).getTextContent());
		}

	}
}

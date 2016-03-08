package com.studytrails.xml.jaxp;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JaxpDOMExample1 {

	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		JaxpDOMExample1 example = new JaxpDOMExample1();
		example.startParsing();

	}

	void startParsing() throws ParserConfigurationException, SAXException, IOException {

		// create the factory for the DocumentBuilder. JAXP ships with a xerces
		// as the default DOM parser.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		System.out.println(factory.getClass());
		// prints class
		// com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl
		// we want the factory to be namespace aware. This is important if the
		// XML declares and uses additional namespaces
		factory.setNamespaceAware(true);
		// the actual builder or parser
		DocumentBuilder builder = factory.newDocumentBuilder();

		// the Document that represents the XML
		Document bbcDoc = builder.parse(xmlSource);

		// the root element.
		Element rootElement = bbcDoc.getDocumentElement();
		System.out.println(rootElement.getNodeName());
		// prints Rss

		// search for an element using the name
		NodeList list = rootElement.getElementsByTagName("channel");
		// get the first item in the list
		Node channel = list.item(0);
		// get the child nodes
		NodeList channelChildren = channel.getChildNodes();
		int length = channelChildren.getLength();
		for (int i = 0; i < length; i++) {
			Node node = channelChildren.item(i);
			// node type 1 is text
			if (1 == node.getNodeType()) {
				if ("title".equals(node.getNodeName()))
					// the text element is the child node
					System.out.println(node.getFirstChild().getTextContent());
			}
		}

		// get all elements with the name 'link'. We just print the first link
		NodeList linkList = rootElement.getElementsByTagName("link");
		System.out.println(linkList.item(0).getFirstChild().getTextContent());
		// <atom:link href="http://feeds.bbci.co.uk/news/technology/Rss.xml"
		// rel="self" type="application/Rss+xml"/>

		// get all elements with the name 'link' and in a specific namespace
		NodeList linkList2 = rootElement.getElementsByTagNameNS("http://www.w3.org/2005/Atom", "link");
		Node atomLink = linkList2.item(0);
		System.out.println(atomLink.hasAttributes()); // prints true
		NamedNodeMap atomLinkAttributes = atomLink.getAttributes();
		for (int i = 0; i < atomLinkAttributes.getLength(); i++) {
			Node atomLinkAttribute = atomLinkAttributes.item(i);
			System.out.println(atomLinkAttribute.getNodeName());
			System.out.println(atomLinkAttribute.getNodeValue());
			/*prints 
			 * href 
			 * http://feeds.bbci.co.uk/news/technology/Rss.xml
			 * rel
			 * self
			 */
		}

		Node firstChildOfRoot = rootElement.getFirstChild();
		System.out.println(firstChildOfRoot.getNodeName());
		// prints #text

		Node siblingOfFirstChild = firstChildOfRoot.getNextSibling();
		System.out.println(siblingOfFirstChild.getNodeName());
		// prints channel

	}

}

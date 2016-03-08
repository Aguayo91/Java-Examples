package com.studytrails.xml.jdom;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.jdom2.util.IteratorIterable;
import org.xml.sax.SAXException;

public class CreateJdomFromDom {

	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// create the w3c DOM document from which JDOM is to be created
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// we are interested in making it namespace aware.
		factory.setNamespaceAware(true);
		DocumentBuilder dombuilder = factory.newDocumentBuilder();

		org.w3c.dom.Document w3cDocument = dombuilder.parse(xmlSource);

		// w3cDocument is the w3c DOM object. we now build the JDOM2 object

		// the DOMBuilder uses the DefaultJDOMFactory to create the JDOM2
		// objects.
		DOMBuilder jdomBuilder = new DOMBuilder();

		// jdomDocument is the JDOM2 Object
		Document jdomDocument = jdomBuilder.build(w3cDocument);

		// The root element is the root of the document. we print its name
		System.out.println(jdomDocument.getRootElement().getName()); // prints
																		// "Rss"

		Element rss = jdomDocument.getRootElement();

		// The Element class extends Content class which is NamespaceAware. We
		// see what namespace this element introduces.
		System.out.println(rss.getNamespacesIntroduced());
		/*
		 * prints [[Namespace: prefix "atom" is mapped to URI
		 * "http://www.w3.org/2005/Atom"], [Namespace: prefix "media" is mapped
		 * to URI "http://search.yahoo.com/mrss/"]]
		 */

		// the getContent method traverses through the document and gets all the
		// contents. We print the CType (an enumeration identifying the Content
		// Type), value and class of the Content. we print only the
		// first two values, since this is only an example.
		List<Content> rssContents = rss.getContent();
		for (int i = 0; i < 2; i++) {
			Content content = rssContents.get(i);
			System.out.println("CType " + content.getCType());
			System.out.println("Class " + content.getClass());
		}

		Element channel = rss.getChild("channel");

		// the getChildren method can be used to obtain the children of the
		// element
		List<Element> channelChildren = channel.getChildren();
		for (int i = 0; i < 2; i++) {
			Element channelChild = channelChildren.get(i);
			System.out.println(channelChild.getName());// prints 'title' and
														// 'link'
		}

		// to directly obtain the child node of type Text
		System.out.println(channel.getChildText("link")); // print the first
															// link

		// It is also possible to specify the namespace while obtaining the
		// child element. In the statement below we
		// obtain the child with name 'link' but we want that child to be from
		// the atom namespace. We further use the getAttributeValue method to
		// get the value of the attribute of the node
		System.out.println(channel.getChild("link", rss.getNamespace("atom")).getAttributeValue("href"));
		// prints http://feeds.bbci.co.uk/news/technology/Rss.xml

		// Instead of getting all the children of a node we may want to get all
		// children with a particular name.
		List<Element> items = channel.getChildren("item");
		for (int i = 0; i < 2; i++) {
			System.out.println(items.get(i).getChildText("title")); // prints
																	// the first
																	// two
																	// titles
		}

		// iterate through all the descendants and get the url of the thumbnails
		// (The thumbnails are declared with namespace media)
		IteratorIterable<Content> descendantsOfChannel = channel.getDescendants();
		for (Content descendant : descendantsOfChannel) {
			if (descendant.getCType().equals(Content.CType.Element)) {
				Element element = (Element) descendant;
				if (element.getNamespace().equals(rss.getNamespace("media"))) {
					// System.out.println(element.getAttributeValue("url")); //
					// prints all urls of all thumbnails within the
					// 'media' namespace
				}
			}
		}
	}
}

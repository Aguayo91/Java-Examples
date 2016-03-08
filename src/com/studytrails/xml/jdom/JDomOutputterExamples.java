package com.studytrails.xml.jdom;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.XMLEventConsumer;

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.DOMOutputter;
import org.jdom2.output.Format;
import org.jdom2.output.SAXOutputter;
import org.jdom2.output.StAXEventOutputter;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JDomOutputterExamples {

	public static void main(String[] args) throws JDOMException, XMLStreamException {

		// create the jdom
		Document jdomDoc = new Document();
		// create root element
		Element rootElement = new Element("Root");
		jdomDoc.setRootElement(rootElement);

		// add a comment
		Comment comment = new Comment("This is a comment");
		rootElement.addContent(comment);

		// add child
		Element child1 = new Element("child");
		child1.addContent("This is child 1");
		
		// add attribute
		Attribute attr1 = new Attribute("key1", "value1");
		child1.setAttribute(attr1);
		rootElement.addContent(child1);

		// Output as XML
		// create XMLOutputter
		XMLOutputter xml = new XMLOutputter();
		// we want to format the xml. This is used only for demonstration. pretty formatting adds extra spaces and is generally not required.
		xml.setFormat(Format.getPrettyFormat());
		System.out.println(xml.outputString(jdomDoc));
		

		// Output the JDOM2 document as a w3c Document
		// create the DOM Outputter
		DOMOutputter domOutputer = new DOMOutputter();
		// create the w3c Document from the JDOM2 Document
		org.w3c.dom.Document dom = domOutputer.output(jdomDoc);
		System.out.println(dom.getNodeName());

		//  we iterate through the w3c Document and print the elements
		org.w3c.dom.Element rootElementDom = dom.getDocumentElement();
		System.out.println(rootElementDom.getNodeName());
		NodeList children = rootElementDom.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			System.out.println("Node Name-->" + child.getNodeName());
			System.out.println("Node value-->" + child.getNodeValue());
			System.out.println("Node Attributes-->" + child.getAttributes());
		}

		// Output the JDOM2 as SAX events. Pass in the ContentHandler that will handle the events.
		SAXOutputter saxOutputer = new SAXOutputter(new myContentHandler());
		saxOutputer.output(jdomDoc);

		// Output as StaxEvents. Pass in a custom XMLEventConsumer.
		StAXEventOutputter staxOutputter = new StAXEventOutputter();
		staxOutputter.output(jdomDoc, new XMLEventConsumer() {

			@Override
			public void add(XMLEvent event) throws XMLStreamException {
				int eventType = event.getEventType();
				if (XMLEvent.COMMENT == eventType) {
					System.out.println(event.toString());
				}
				if (XMLEvent.START_ELEMENT == eventType) {
					System.out.println(event.asStartElement().getName());
				}

			}
		});
	}

	public static class myContentHandler extends DefaultHandler {
		@Override
		public void startDocument() throws SAXException {
			System.out.println("Start Doc");
			super.startDocument();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			System.out.println("Start " + localName);
			super.startElement(uri, localName, qName, attributes);
		}
	}

}

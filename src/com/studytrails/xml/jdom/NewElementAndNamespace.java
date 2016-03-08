package com.studytrails.xml.jdom;

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class NewElementAndNamespace {
	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) {

		Namespace namespace = Namespace.getNamespace("p", "http://namespaceuri");
		// create the jdom
		Document jdomDoc = new Document();
		// create root element
		Element rootElement = new Element("Root", namespace);
		jdomDoc.setRootElement(rootElement);

		// add a comment
		Comment comment = new Comment("This is a comment");
		rootElement.addContent(comment);

		// add child
		Element child1 = new Element("child", namespace);
		child1.addContent("This is child 1");

		// add child 2
		Element child2 = new Element("child");
		child2.addContent("This is child 2");

		// add attribute
		Attribute attr1 = new Attribute("key1", "value1");
		child1.setAttribute(attr1);
		rootElement.addContent(child1);
		rootElement.addContent(child2);

		// Output as XML
		// create XMLOutputter
		XMLOutputter xml = new XMLOutputter();
		// we want to format the xml. This is used only for demonstration.
		// pretty formatting adds extra spaces and is generally not required.
		xml.setFormat(Format.getPrettyFormat());
		System.out.println(xml.outputString(jdomDoc));
	}
}



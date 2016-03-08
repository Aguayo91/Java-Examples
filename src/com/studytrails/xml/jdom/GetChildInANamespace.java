package com.studytrails.xml.jdom;

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

public class GetChildInANamespace {
	private static String xmlTestFile = "test.xml";

	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder jdomBuilder = new SAXBuilder();
		Document jdomDocument = jdomBuilder.build(xmlTestFile);

		// the root element
		Element root = jdomDocument.getRootElement();

		// lets search for a child named child1

		System.out.println(root.getChild("child1"));
		// prints null

		System.out.println(root.getChild("child1", Namespace.getNamespace("p", "http://namespaceuri")));
		// prints [Element: <p:child1 [Namespace: http://namespaceuri]/>]
	}
}

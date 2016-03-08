package com.studytrails.xml.jdom;

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class XpathAndNamespace {
	private static String xmlTestFile = "test2.xml";

	public static void main(String[] args) throws JDOMException, IOException {
		// read the xml into a JDOM2 document.
		SAXBuilder jdomBuilder = new SAXBuilder();
		Document jdomDocument = jdomBuilder.build(xmlTestFile);

		XPathFactory xFactory = XPathFactory.instance();

		XPathExpression<Element> expr = xFactory.compile("//child2", Filters.element());
		Element child2 = expr.evaluateFirst(jdomDocument);
		System.out.println(child2);
		// prints null

		// we create a dummy namespace prefix that points to the default
		// namespace and then access the element using that namespace
		Namespace defaultNs = Namespace.getNamespace("a", "http://nondefaulnamespace");
		XPathExpression<Element> expr2 = xFactory.compile("//a:child2", Filters.element(), null, defaultNs);
		child2 = expr2.evaluateFirst(jdomDocument);
		System.out.println(child2);
		// prints [Element: <child2 [Namespace: http://nondefaulnamespace]/>]

		// search for a child from another namespace
		Namespace anotherNS = Namespace.getNamespace("p", "http//anothernamespace");
		XPathExpression<Element> expr3 = xFactory.compile("//p:child1", Filters.element(), null, anotherNS);
		Element child1 = expr3.evaluateFirst(jdomDocument);
		System.out.println(child1);
		// prints [Element: <p:child1 [Namespace: http//anothernamespace]/>]
	}
}

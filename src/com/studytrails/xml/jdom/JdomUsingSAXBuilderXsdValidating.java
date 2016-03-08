package com.studytrails.xml.jdom;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

public class JdomUsingSAXBuilderXsdValidating {

	private static String file1 = "tomcat-web-xsd-bad.xml";

	private static String file2 = "tomcat-web-xsd.xml";

	public static void main(String[] args) throws JDOMException, IOException {
		// SAXBuilder builder = new SAXBuilder(XMLReaders.XSDVALIDATING);
		// Document jdomDocValidatedFalse = builder.build(new File(file1));
		// throws an error since the XSD validation fails. comment the lines
		// above and rerun the example

		SAXBuilder builder2 = new SAXBuilder(XMLReaders.XSDVALIDATING);
		Document jdomDocValidatedTrue = builder2.build(new File(file2));

		System.out.println(builder2.getSAXHandlerFactory().getClass());
		// prints class org.jdom2.input.sax.DefaultSAXHandlerFactory
		System.out.println(builder2.getJDOMFactory().getClass());
		// class org.jdom2.DefaultJDOMFactory
		System.out.println(builder2.getXMLReaderFactory().getClass());
		// class org.jdom2.input.sax.XMLReaders

	}
}

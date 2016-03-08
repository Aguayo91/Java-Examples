package com.studytrails.xml.jaxp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class JaxpTransformationExample4 {
	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException, XMLStreamException {
		JaxpTransformationExample4 example = new JaxpTransformationExample4();
		// transforming the XML into HTML using a DOM Source
		example.transformDom();
		// transforming the XML into HTML using a SAX Source
		example.transfromSAX();
		// transforming the XML into HTML using a StAX Source
		example.transformStAX();

	}

	public void transformDom() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// create the DOM Source
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document bbcDoc = builder.parse(xmlSource);
		DOMSource source = new DOMSource(bbcDoc);

		// Create an instance of the TransformerFactory
		TransformerFactory transfomerFactory = TransformerFactory.newInstance();
		System.out.println(transfomerFactory.getClass());
		// prints
		// com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl
		// obtain the XSLT transformer. The transformer has instructions for
		// converting the XML to HTML
		Transformer transformer = transfomerFactory.newTransformer(new StreamSource("bbc.xsl"));
		// An object to hold the results. It can be a file. In This example we
		// output to console.
		StreamResult result = new StreamResult(System.out);
		transformer.transform(source, result);
	}

	public void transfromSAX() throws ParserConfigurationException, SAXException, MalformedURLException, IOException, TransformerException {
		// Create a SAXSource from the xml
		SAXSource saxSource = new SAXSource(new InputSource(new URL(xmlSource).openConnection().getInputStream()));
		// Object to hold the result
		StreamResult result = new StreamResult(System.out);
		// the factory that provides the transformer
		TransformerFactory factory = SAXTransformerFactory.newInstance();
		// the transformer that does the transformation
		Transformer transformer = factory.newTransformer(new StreamSource("bbc.xsl"));
		// the actual transformation
		transformer.transform(saxSource, result);

	}

	public void transformStAX() throws XMLStreamException, IOException, TransformerException {
		// obtain the StAX Source
		XMLInputFactory factory = XMLInputFactory.newFactory();
		URL url = new URL(xmlSource);
		XMLEventReader reader = factory.createXMLEventReader(url.openStream());
		StAXSource staxSource = new StAXSource(reader);

		// The factory that produces the transformer
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(new StreamSource("bbc.xsl"));
		// An object to hold the results.
		StreamResult result = new StreamResult(System.out);
		// the transformation
		transformer.transform(staxSource, result);
	}
}

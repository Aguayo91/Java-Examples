package com.studytrails.xml.jdom;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.filter.ContentFilter;
import org.jdom2.filter.Filter;
import org.jdom2.filter.Filters;
import org.jdom2.input.DOMBuilder;
import org.jdom2.util.IteratorIterable;
import org.xml.sax.SAXException;

public class FilterJdom {
	private static String xmlSource = "http://feeds.bbci.co.uk/news/technology/Rss.xml?edition=int";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder dombuilder = factory.newDocumentBuilder();

		org.w3c.dom.Document w3cDocument = dombuilder.parse(xmlSource);
		DOMBuilder jdomBuilder = new DOMBuilder();
		Document jdomDocument = jdomBuilder.build(w3cDocument);

		Element rss = jdomDocument.getRootElement();
		Element channel = rss.getChild("channel");

		Element title = channel.getChild("title");

		// Content Filter
		ContentFilter filter = new ContentFilter(ContentFilter.PI);
		List<Content> cDataContents = jdomDocument.getContent(filter);
		Iterator<Content> cDataIterator = cDataContents.iterator();
		while (cDataIterator.hasNext()) {
			Content cdata = cDataIterator.next();
			// System.out.println(cdata.getCType());
			// System.out.println(cdata.getValue());
		}

		// Text Filter
		Filter<Text> textFilter = Filters.text();
		IteratorIterable<Text> channelTextList = channel.getDescendants(textFilter);
		while (channelTextList.hasNext()) {
			Text channelText = channelTextList.next();
			// System.out.println(channelText.getValue());
		}

		// or filter
		Filter<Element> filters = (Filter<Element>) Filters.element("thumbnail", rss.getNamespace("media")).or(Filters.element("link"));
		IteratorIterable<Element> thumbnailsAndLinks = channel.getDescendants(filters);
		while (thumbnailsAndLinks.hasNext()) {
			Element thumbnailorLink = thumbnailsAndLinks.next();
			// System.out.println(thumbnailorLink.getName());
		}

		// negate filter
		Filter<Element> negateFilter = (Filter<Element>) Filters.element("link").negate().and(Filters.text().negate());
		IteratorIterable<Element> nonLinkElements = channel.getDescendants(negateFilter);
		while (nonLinkElements.hasNext()) {
			Element nonLinkElement = nonLinkElements.next();
			System.out.println(nonLinkElement.getName());
		}

	}
}

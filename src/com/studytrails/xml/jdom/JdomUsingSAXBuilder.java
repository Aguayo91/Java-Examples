package com.studytrails.xml.jdom;

import java.io.File;
import java.io.IOException;

import org.jdom2.Comment;
import org.jdom2.Content;
import org.jdom2.Content.CType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;

public class JdomUsingSAXBuilder {

	private static String file1 = "tomcat-web-dtd.xml";

	public static void main(String[] args) throws JDOMException, IOException {

		// Use a SAX builder
		SAXBuilder builder = new SAXBuilder();
		// build a JDOM2 Document using the SAXBuilder.
		Document jdomDoc = builder.build(new File(file1));

		// get the document type
		System.out.println(jdomDoc.getDocType());

		//get the root element
		Element web_app = jdomDoc.getRootElement();
		System.out.println(web_app.getName());
		
		// get the first child with the name 'servlet'
		Element servlet = web_app.getChild("servlet");

		// iterate through the descendants and print non-Text and non-Comment values
		IteratorIterable<Content> contents = web_app.getDescendants();
		while (contents.hasNext()) {
			Content web_app_content = contents.next();
			if (!web_app_content.getCType().equals(CType.Text) && !web_app_content.getCType().equals(CType.Comment)) {
				System.out.println(web_app_content.toString());
			}
		}

		// get comments using a Comment filter
		IteratorIterable<Comment> comments = web_app.getDescendants(Filters.comment());
		while (comments.hasNext()) {
			Comment comment = comments.next();
			System.out.println(comment);
		}

	}
}

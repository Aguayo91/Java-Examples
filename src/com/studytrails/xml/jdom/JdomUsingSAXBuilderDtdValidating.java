package com.studytrails.xml.jdom;

import java.io.File;
import java.io.IOException;

import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

public class JdomUsingSAXBuilderDtdValidating {
	private static String file1 = "tomcat-web-dtd-bad.xml";
	private static String file2 = "tomcat-web-dtd.xml";

	public static void main(String[] args) throws JDOMException, IOException {

		 SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);
		 Document jdomDocValidatedFalse = builder.build(new File(file1));
		// throws an error since the xml does not validate. We correct it and
		// then run this again. comment the lines above and run this again.

		SAXBuilder builder2 = new SAXBuilder(XMLReaders.DTDVALIDATING);
		Document jdomDocValidatedTrue = builder2.build(new File(file2));

		System.out.println(jdomDocValidatedTrue.hasRootElement()); // prints true
		
		DocType docType = jdomDocValidatedTrue.getDocType();

		System.out.println(docType.getPublicID());
		// prints -//Sun Microsystems, Inc.//DTD Web Application 2.3//EN
		
		System.out.println(docType.getSystemID());
		// prints http://java.sun.com/dtd/web-app_2_3.dtd
		

	}
}

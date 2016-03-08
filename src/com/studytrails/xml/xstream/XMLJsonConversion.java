package com.studytrails.xml.xstream;

import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.binary.BinaryStreamDriver;
import com.thoughtworks.xstream.io.copy.HierarchicalStreamCopier;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class XMLJsonConversion {
	private String bbcUrl = "http://feeds.bbci.co.uk/news/technology/rss.xml?edition=int";
	public static void main(String[] args) throws MalformedURLException {
       XMLJsonConversion converter = new XMLJsonConversion();
		converter.convert();
	}

	private void convert() throws MalformedURLException {
		HierarchicalStreamCopier copier = new HierarchicalStreamCopier();
		HierarchicalStreamDriver jsonDriver = new JettisonMappedXmlDriver();
		HierarchicalStreamDriver binaryDriver = new BinaryStreamDriver();
	    XStream xStream = new XStream();
		HierarchicalStreamReader reader = binaryDriver.createReader(new URL(bbcUrl));
		HierarchicalStreamWriter writer = jsonDriver.createWriter(System.out);
		copier.copy(reader, writer);
		
	}
}

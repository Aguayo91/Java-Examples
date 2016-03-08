package com.studytrails.xml.xstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.thoughtworks.xstream.XStream;

public class ObjectInputStreamExample {
	private String bbcUrl = "http://feeds.bbci.co.uk/news/technology/rss.xml?edition=int";

	public static void main(String[] args) throws MalformedURLException, IOException {
		ObjectInputStreamExample example = new ObjectInputStreamExample();
		example.runExample();
	}

	private void runExample() throws MalformedURLException, IOException {
		XStream xStream = new XStream();
		ObjectInputStream objectInputStream = xStream.createObjectInputStream(new URL(bbcUrl).openStream());
		int a = -1;
		while ((a = objectInputStream.readInt()) != -1) {
             System.out.println(a);
		}

	}
}

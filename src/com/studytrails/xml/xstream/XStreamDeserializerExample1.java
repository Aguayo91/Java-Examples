package com.studytrails.xml.xstream;

import java.net.MalformedURLException;
import java.net.URL;

import com.thoughtworks.xstream.XStream;

public class XStreamDeserializerExample1 {

	private String bbcUrl = "http://feeds.bbci.co.uk/news/technology/rss.xml?edition=int";

	public static void main(String[] args) throws MalformedURLException {
		XStreamDeserializerExample1 serializer = new XStreamDeserializerExample1();
		serializer.basicSerialization();
	}

	private void basicSerialization() throws MalformedURLException {

		XStream xstream = new XStream();
		xstream.alias("rss", Rss.class);
		xstream.aliasField("atom:link", Channel.class, "a_link");
		xstream.alias("item", Item.class);
		
		xstream.aliasAttribute(AtomLink.class, "type", "type");
		xstream.aliasAttribute(AtomLink.class, "href", "href");
		xstream.aliasAttribute(AtomLink.class, "rel", "rel");
		
		xstream.aliasAttribute(MediaThumbnail.class, "width","width");
		xstream.aliasAttribute(MediaThumbnail.class, "height","height");
		xstream.aliasAttribute(MediaThumbnail.class, "url","url");
		
		xstream.addImplicitCollection(Channel.class, "items");
		xstream.addImplicitArray(Item.class, "media_thumbnails", "media:thumbnail");
		Rss bbcFeed = (Rss) xstream.fromXML(new URL(bbcUrl));
		// bbcFeed now contains the Java representation of the BBC RSS
	}
}

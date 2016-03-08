package com.studytrails.xml.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class BBCRSSExample {
	public static void main(String[] args) {
		XStream xStream = new XStream();
		Rss4 bbcRss = new Rss4();
		xStream.alias("rss", Rss4.class);
		Channel4 channel = new Channel4();
		AtomLink4 atomLink = new AtomLink4();
		atomLink.href = "http://feeds.bbci.co.uk/news/technology/rss.xml";
		atomLink.rel = "self";
		atomLink.type = "application/rss+xml";
		channel.a_link = atomLink;
		bbcRss.channel = channel;
		xStream.aliasField("atom:link", Channel4.class, "a_link");
		xStream.aliasAttribute(AtomLink4.class, "type", "type");
		xStream.aliasAttribute(AtomLink4.class, "href", "href");
		xStream.aliasAttribute(AtomLink4.class, "rel", "rel");
		xStream.alias("item", Item4.class);
		xStream.addImplicitCollection(Channel4.class, "items");
		channel.items = new ArrayList<Item4>();
		Item4 item = new Item4();
		item.title = "Item1";
		Item4 item2 = new Item4();
		item2.title = "Item2";
		channel.items.add(item);
		channel.items.add(item2);
		
		xStream.addImplicitArray(Item4.class, "media_thumbnails", "media:thumbnail");
		xStream.aliasAttribute(MediaThumbnail4.class, "width","width");
		xStream.aliasAttribute(MediaThumbnail4.class, "height","height");
		xStream.aliasAttribute(MediaThumbnail4.class, "url","url");
		
		MediaThumbnail4 thumbnail = new MediaThumbnail4();
		thumbnail.height=100;
		thumbnail.width=50;
		thumbnail.url="thumbnail_link";
		MediaThumbnail4 thumbnail2 = new MediaThumbnail4();
		thumbnail2.height=100;
		thumbnail2.width=50;
		thumbnail2.url="thumbnail_link2";
		
		item.media_thumbnails = new MediaThumbnail4[2];
		item.media_thumbnails[0] = thumbnail;
		item.media_thumbnails[1] = thumbnail2;
		
		System.out.println(xStream.toXML(bbcRss));
	}
}

class Rss4 {
	public Channel4 channel;
}

class Channel4 {
	public AtomLink4 a_link;
	public List<Item4> items;
}

class AtomLink4 {
	public String href;
	public String rel;
	public String type;
}

class Item4 {
	public String title;
	public MediaThumbnail4[] media_thumbnails;
}

class MediaThumbnail4 {
	public int width;
	public int height;
	public String url;

}

class Image4 {
	public String url;
	public String title;
	public String link;
	public String width;
	public String height;

}

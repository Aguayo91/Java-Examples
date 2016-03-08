package com.studytrails.xml.xstream;

import java.util.List;

public class Rss {
	public Channel channel;
}

class Channel {
	public String title;
	public String link;
	public String description;
	public String language;
	public String lastBuildDate;
	public String copyright;
	public Image4 image;
	public String ttl;
	public AtomLink a_link;
	public List<Item> items;
}

class AtomLink {
	public String href;
	public String rel;
	public String type;
}

class Item {
	public String title;
	public String description;
	public String link;
	public String guid;
	public String pubDate;
	public MediaThumbnail[] media_thumbnails;
}

class MediaThumbnail {
	public int width;
	public int height;
	public String url;
}

class Image {
	public String url;
	public String title;
	public String link;
	public String width;
	public String height;
}

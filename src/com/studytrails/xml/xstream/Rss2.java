package com.studytrails.xml.xstream;

import java.util.Arrays;
import java.util.List;

public class Rss2 {
	public Channel2 channel;

	@Override
	public String toString() {
		return "Rss [channel=" + channel + "]";
	}

}

class Channel2 {
	public String title;
	public String link;
	public String description;
	public String language;
	public String lastBuildDate;
	public String copyright;
	public Image2 image;
	public String ttl;
	public AtomLink a_link;
	public List<Item2> items;

	public class AtomLink {
		public String href;
		public String rel;
		public String type;

		@Override
		public String toString() {
			return "AtomLink4 [href=" + href + ", rel=" + rel + ", type=" + type + "]";
		}

	}

	@Override
	public String toString() {
		return "Channel [title=" + title + ", link=" + link + ", description=" + description + ", language=" + language + ", lastBuildDate="
				+ lastBuildDate + ", copyright=" + copyright + ", image=" + image + ", ttl=" + ttl + ", a_link=" + a_link + ", items=" + items + "]";
	}

}

class Item2 {
	public String title;
	public String description;
	public String link;
	public String guid;
	public String pubDate;
	public MediaThumbnail[] media_thumbnails;

	@Override
	public String toString() {
		return "Item [title=" + title + ", link=" + link + ", guid=" + guid + ", pubDate=" + pubDate + ", media_thumbnails="
				+ Arrays.toString(media_thumbnails) + "]";
	}

	public class MediaThumbnail {
		public int width;
		public int height;
		public String url;

		@Override
		public String toString() {
			return "MediaThumbnail4 [width=" + width + ", height=" + height + ", url=" + url + "]";
		}

	}

}

class Image2 {
	public String url;
	public String title;
	public String link;
	public String width;
	public String height;

	@Override
	public String toString() {
		return "Image4 [url=" + url + ", title=" + title + ", link=" + link + ", width=" + width + ", height=" + height + "]";
	}

}

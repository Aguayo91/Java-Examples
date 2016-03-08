package com.studytrails.xml.xstream;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class ConverterExample6 {

	static String xml = "<Music><album><name>name1</name><author>author1</author></album></Music>";

	public static void main(String[] args) {
		XStream xStream = new XStream();
		xStream.processAnnotations(Music4.class);
		xStream.alias("name", String.class);
		xStream.alias("author", String.class);
		xStream.alias("album", Entry.class);
		Music4 musicObject = (Music4) xStream.fromXML(xml);

		System.out.println(musicObject);
	}

}

@XStreamAlias("Music")
class Music4 {

	@XStreamImplicit
	Map<String, String> albums = new HashMap<String, String>();

	@Override
	public String toString() {
		return "Music4 [testMap=" + albums + "]";
	}

}
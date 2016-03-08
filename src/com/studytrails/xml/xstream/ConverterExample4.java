package com.studytrails.xml.xstream;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class ConverterExample4 {

	static String xml = "<Music><type>rock</type><type>jazz</type></Music>";

	public static void main(String[] args) {
		XStream xStream = new XStream();
		xStream.processAnnotations(Music2.class);
		Music2 musicObject = (Music2) xStream.fromXML(xml);

		System.out.println(musicObject);
	}

}

@XStreamAlias("Music")
class Music2 {

	@XStreamImplicit
	List<String> type;

	@Override
	public String toString() {
		return "Music2 [type=" + type + "]";
	}

}
package com.studytrails.xml.xstream;

import java.util.Arrays;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class ConverterExample5 {

	String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Music><type>rock</type><type>jazz</type></Music></xml>";

	public static void main(String[] args) {
		ConverterExample5 useConvertersWhileUnMarshallingXML = new ConverterExample5();
		useConvertersWhileUnMarshallingXML.unMarshall();
	}

	private void unMarshall() {
		XStream xStream = new XStream();
		xStream.processAnnotations(Music3.class);
		Music3 musicObject = (Music3) xStream.fromXML(xml);

		System.out.println(musicObject);

	}

}

@XStreamAlias("Music")
class Music3 {
	
	@XStreamImplicit
	String[] type;

	@Override
	public String toString() {
		return "Music3 [type=" + Arrays.toString(type) + "]";
	}

}
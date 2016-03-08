package com.studytrails.xml.xstream;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.basic.DateConverter;

public class ConverterExample7 {
	static String xml = "<Musician><birthdate>04-20-1976 23:00:00</birthdate></Musician>";

	public static void main(String[] args) {
		XStream xStream = new XStream();
		xStream.processAnnotations(Musician.class);
		xStream.registerConverter(new DateConverter("MM-dd-yyyy HH:mm:ss", 
				new String[] {}, TimeZone.getTimeZone("UTC")));
		Musician musician = (Musician) xStream.fromXML(xml);
		System.out.println(musician);
	}

}

@XStreamAlias("Musician")
class Musician {
	private Date birthdate;

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		return "Musician [birthdate=" + format.format(birthdate) + "]";
	}

}

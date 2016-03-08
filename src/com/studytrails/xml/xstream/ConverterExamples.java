package com.studytrails.xml.xstream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.basic.DateConverter;

public class ConverterExamples {
	


	public static void main(String[] args) {
		ConverterExamples converter = new ConverterExamples();
		converter.demoConverters();
	}

	private void demoConverters() {

		ConverterDemo demo = new ConverterDemo();
		demo.setDate(new Date());
		demo.setCalendar(Calendar.getInstance());
		demo.addToRandomObjects("Apple");
		demo.addToRandomObjects(2);
		demo.addToRandomObjects(new String[] {"a","b"});
		demo.addToRandomObjects(new ArrayList().add("test1"));
		
		demo.addToRandomMap("key1", "value1");
		demo.addToRandomMap("key2", demo.randomObjects);
		demo.addToRandomMap("key3", false);
		XStream xStream = new XStream();
		xStream.processAnnotations(ConverterDemo.class);
		xStream.setMode(XStream.ID_REFERENCES);
		xStream.registerLocalConverter(ConverterDemo.class, "date", new DateConverter("MM-dd-YYYY HH:mm:ss Z", new String[]{}));
		System.out.println(xStream.toXML(demo));
	}

}

@XStreamAlias("ConverterDemo")
class ConverterDemo {
	public Date date;
	public Calendar calendar;
	public String allowNull;
	public List randomObjects = new ArrayList();
	public Map<String,Object> randomMap = new HashMap<String, Object>();

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	public void addToRandomObjects(Object a){
		randomObjects.add(a);
	}
	public Map<String, Object> addToRandomMap(String key, Object value){
		randomMap.put(key, value);
		return randomMap;
	}
}

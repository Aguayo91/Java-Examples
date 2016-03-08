package com.studytrails.xml.xstream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;

import com.thoughtworks.xstream.XStream;

public class ConverterExample2 {
	public static void main(String[] args) {
		ConverterExample2 example2 = new ConverterExample2();
		example2.runExample();
	}

	public void runExample() {
		XStream xStream = new XStream();
		CollectionConverterExample classContainingCollection = new CollectionConverterExample();
		classContainingCollection.initialize();
		String xml = xStream.toXML(classContainingCollection);
		System.out.println(xml);
	}
}

class CollectionConverterExample {

	String[] stringArray = new String[] { "StringA", "StringB", "StringC" };
	char[] charArray = new char[] { 'a', 'b', 'c', 'd', 'e' };
	List<String> listA = new ArrayList<String>();
	Map<String, String> mapA = new HashMap<String, String>();
	Properties properties = new Properties();
	List<String> singletonList;
	Map<String, String> singletonMap;

	TreeMap<String, String> treeMap = new TreeMap<String, String>();
	TreeSet<String> treeSet = new TreeSet<String>();
	enum testEnum {testA, testB}
	testEnum testeEnumValue = testEnum.testA;
	EnumMap<testEnum, String> testEnumMap = new EnumMap<CollectionConverterExample.testEnum, String>(testEnum.class);
	EnumSet<testEnum> testEnumSet = EnumSet.range(testEnum.testA, testEnum.testB);

	public void initialize() {
		listA.add("testA");
		mapA.put("keyA", "ValueA");
		properties.put("propertyA", "valueA");
		treeMap.put("treeA", "valueA");
		treeMap.put("treeB", "valueB");
		treeSet.add("treeB");
		treeSet.add("treeA");
		singletonList = Collections.singletonList("singletonListA");
		singletonMap = Collections.singletonMap("key1", "value1");
		
		testEnumMap.put(testEnum.testA, "testEnumMapValue1");
		testEnumMap.put(testEnum.testB, "testEnumMapValue2");

	}
	/*-
	 <com.studytrails.xml.xstream.CollectionConverterExample>
	<stringArray>
		<string>StringA</string>
		<string>StringB</string>
		<string>StringC</string>
	</stringArray>
	<charArray>abcde</charArray>
	<listA>
		<string>testA</string>
	</listA>
	<mapA>
	<entry>
	  <string>keyA</string>
	  <string>ValueA</string>
	</entry>
	</mapA>
	<properties>
		<property name="propertyA" value="valueA"/>
	</properties>
	<singletonList class="singleton-list">
		<string>singletonListA</string>
	</singletonList>
	<singletonMap class="singleton-map">
	<entry>
	  <string>key1</string>
	  <string>value1</string>
	</entry>
	</singletonMap>
	<treeMap>
	<entry>
	  <string>treeA</string>
	  <string>valueA</string>
	</entry>
	<entry>
	  <string>treeB</string>
	  <string>valueB</string>
	</entry>
	</treeMap>
	<treeSet>
		<string>treeA</string>
		<string>treeB</string>
	</treeSet>
	</com.studytrails.xml.xstream.CollectionConverterExample>

	 */

}

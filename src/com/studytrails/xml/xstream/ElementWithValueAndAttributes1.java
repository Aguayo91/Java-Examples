package com.studytrails.xml.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

public class ElementWithValueAndAttributes1 {

	/*-
	  <?xml version="1.0" encoding="UTF-8"?>
	  <Root>
	 		<child1 key1="value1">This is child 1</child1>
	 		<child2>This is child 2</child2>
	  </Root>
	 */
	String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<Root>" + "<child1 key1=\"value1\">This is child 1</child1>"
			+ "<child2>This is child 2</child2>" + "</Root>";

	public static void main(String[] args) {
		ElementWithValueAndAttributes1 converter = new ElementWithValueAndAttributes1();
		converter.XmlToJavaObjects();
	}

	private void XmlToJavaObjects() {
		XStream xStream = new XStream();
		xStream.alias("Root", Root.class);
		xStream.registerConverter(new ToAttributedValueConverter(Child1.class, xStream.getMapper(), xStream.getReflectionProvider(), xStream
				.getConverterLookup(), "value"));
		Root test = (Root) xStream.fromXML(xml);
		System.out.println(test);
		/*- prints Root [child1=Child1 [value=This is child 1, key1=value1],child2=This is child 2] */

	}

	public class Root {
		public Child1 child1;

		public String child2;

		@Override
		public String toString() {
			return "Root [child1=" + child1 + ", child2=" + child2 + "]";
		}

	}

	public class Child1 {
		public String value;
		public String key1;

		@Override
		public String toString() {
			return "Child1 [value=" + value + ", key1=" + key1 + "]";
		}

	}

}

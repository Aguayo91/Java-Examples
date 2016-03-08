package com.studytrails.xml.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;

public class ElementWithAttribute {

	/*-
	  <?xml version="1.0" encoding="UTF-8"?>
	  <Root>
	 		<child1 key1="value1"></child1>
	 		<child2>This is child 2</child2>
	  </Root>
	 */
	private String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<Root>" + "<child1 key1=\"value1\"></child1>"
			+ "<child2>This is child 2</child2>" + "</Root>";

	public static void main(String[] args) {
		ElementWithAttribute unmarshaller = new ElementWithAttribute();
		unmarshaller.XMLToJavaObject();
	}

	public void XMLToJavaObject() {
		XStream xStream = new XStream();
		xStream.useAttributeFor(Child1.class, "key1");
		xStream.registerConverter(new Key1SingleValueConverter());
		xStream.alias("Root", Root.class);
		xStream.alias("child1", Child1.class);
		Root root = (Root) xStream.fromXML(xml);
		System.out.println(root);
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
		public Key1 key1;

		@Override
		public String toString() {
			return "Child1 [key1=" + key1 + "]";
		}

	}

	public class Key1 {
		String value;

		public Key1(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Key1 [value=" + value + "]";
		}

	}

	public class Key1SingleValueConverter implements SingleValueConverter {
		@Override
		public boolean canConvert(Class type) {
			return (type.equals(Key1.class));
		}

		@Override
		public Object fromString(String str) {
			Key1 key = new Key1(str);
			return key;
		}

		@Override
		public String toString(Object obj) {
			return ((Key1) obj).value;
		}
	}
}

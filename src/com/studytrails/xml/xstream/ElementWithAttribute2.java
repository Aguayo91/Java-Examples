package com.studytrails.xml.xstream;

import com.thoughtworks.xstream.XStream;

public class ElementWithAttribute2 {

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
		ElementWithAttribute2 unmarshaller = new ElementWithAttribute2();
		unmarshaller.XMLToJavaObject();
	}

	public void XMLToJavaObject() {
		XStream xStream = new XStream();
		xStream.alias("Root", Root.class);
		xStream.alias("child1", Child1.class);
		xStream.aliasAttribute(Child1.class, "key1", "key1");
		Root root = (Root) xStream.fromXML(xml);
		System.out.println(root);
		//prints Root [child1=Child1 [key1=value1], child2=This is child 2]
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
		public String key1;

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

}

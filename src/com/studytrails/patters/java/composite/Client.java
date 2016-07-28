package com.studytrails.patters.java.composite;

public class Client {

	private static Node root;
	private static TextNode text1;
	private static TextNode b;
	private static Node a;

	public static void main(String[] args) {
		// create the root node
		root = new NodeImpl("root");

		// create another node.
		a = new NodeImpl("a");

		// create text node
		text1 = new TextNode("text1");
		text1.setValue("value1");

		// another text node
		b = new TextNode("text2");
		b.setValue("value2");

		// a is a composite node and is added as a child to the root node
		root.addChild(a);
		// add the text node as child to the "a" node
		a.addChild(text1);

		// add the b node as child of root
		root.addChild(b);

		// prints null since b is a leaf node and not a composite node
		System.out.println(b.addChild(new TextNode("test")));
		// return false
		System.out.println(b.hasChildren());
		// b's parent is root.
		System.out.println(b.getParent().getName());

	}
}

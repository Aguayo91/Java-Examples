package com.studytrails.patters.java.composite;

import java.util.List;

public class TextNode extends NodeImpl {
	String value;

	public TextNode(String name) {
		super(name);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * This is a leaf node and hence it can contain no children.
	 */
	public List<Node> getChildren() {
		return null;
	}

	public boolean isLeaf() {
		return true;
	}

	/**
	 * Return false since this is a leaf node.
	 */
	public boolean hasChildren() {
		return false;
	}

	/**
	 * cannot add child to a leaf node and return null
	 */
	public Node addChild(Node child) {
		return null;
	}
}

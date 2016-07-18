package com.studytrails.patters.java.composite;

import java.util.ArrayList;
import java.util.List;

public class NodeImpl implements Node {

	List<Node> children = new ArrayList<Node>();
	Node parent = null;
	String name = null;
	
	public NodeImpl(String name) {
		this.name = name;
	}

	@Override
	public boolean isLeaf() {
		if (children.size() > 0)
			return false;
		return true;
	}

	@Override
	public boolean hasChildren() {
		return !isLeaf();
	}

	@Override
	public List<Node> getChildren() {
		return children;
	}

	@Override
	public Node getParent() {
		return parent == null ? null : parent;
	}

	@Override
	public Node addChild(Node n) {
		if (n != null) {
			children.add(n);
			n.setParent(this);
		}
		return n;

	}

	@Override
	public void setParent(Node parent) {
		this.parent = parent;

	}

	@Override
	public String getName() {
		return name;
	}


}

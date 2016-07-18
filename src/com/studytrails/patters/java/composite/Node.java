package com.studytrails.patters.java.composite;

import java.util.List;

/**
 * The Node Interface that defines the contract for a leaf as well as a parent.
 */
public interface Node {

	/**
	 * If the node has no children then it is a leaf
	 */
	boolean isLeaf();

	/**
	 * If the node has not children then return false. This has the same purpose
	 * as isLeaf and is provided just for usability. Its ok to have only one
	 * method though.
	 * 
	 * @return
	 */
	boolean hasChildren();

	/**
	 * Get the list of children.
	 * 
	 * @return
	 */
	List<Node> getChildren();

	/**
	 * The parent of the current node
	 * 
	 * @return parent node
	 */
	Node getParent();

	/**
	 * adds child
	 * 
	 * @param child
	 * @return the added child or null if the current node is a leaf.
	 */
	Node addChild(Node child);

	/**
	 * When a child is added to a node the parent field of the child is set to
	 * the node to which it is added. helps in traversing the trees both ways.
	 * 
	 * @param parent
	 */
	void setParent(Node parent);

	/**
	 * the name of the node.
	 * 
	 * @return
	 */
	String getName();

}

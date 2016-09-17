package tree_based;

import data_interface.Binary_tree;

public class BinarySearchTree implements Binary_tree {

	private static class Node {
		Object data;
		Node left_node;
		Node right_node;

		Node(Object e, Node l, Node r) {
			data = e;
			left_node = l;
			right_node = r;
		}
	}

	Node root_node;

	int size = 0;

	public void BinaryTree() {
	}

	public void prefix() {
		traverse_tree(root_node, 0);
	}

	public void infix() {
		traverse_tree(root_node, 1);
	}

	public void postfix() {
		traverse_tree(root_node, 2);
	}

	private void traverse_tree(Node n, int method) {
		if (n == null)
			return;
		else {
			if (method == 0) {
				System.out.println(n.data);
				traverse_tree(n.left_node, 0);
				traverse_tree(n.right_node, 0);

			} else if (method == 1) {
				traverse_tree(n.left_node, 1);
				System.out.println(n.data);
				traverse_tree(n.right_node, 1);
			} else {
				traverse_tree(n.left_node, 2);
				traverse_tree(n.right_node, 2);
				System.out.println(n.data);
			}

		}
	}

	public boolean isleaf(Node n) {
		if (n != null)
			return n.left_node == null && n.right_node == null;

		return false;
	}

	@Override
	public boolean add(Object e) {
		if (e == null)
			return false;

		root_node = add(root_node, e);

		return true;
	}

	private Node add(Node n, Object e) {

		if (n == null) {
			n = new Node(e, null, null);
			size++;
		}

		else {

			@SuppressWarnings("unchecked")
			Comparable<Object> e_val = (Comparable<Object>) e;

			if (e_val.compareTo((Integer) n.data) < 0) {
				n.left_node = add(n.left_node, e);
			} else if (e_val.compareTo((Integer) n.data) > 0) {
				n.right_node = add(n.right_node, e);
			}

		}

		return n;
	}

	@Override
	// Utility function for user to call the remove method
	public void remove(Object e) {
		if (e != null) {
			root_node = remove(root_node, e);
		}

	}

	/*
	 * The idea here is to recursively remove the target object from the smaller
	 * BS-Tree. We will traverse the tree and keep checking the value of current node 
	 * with object's value. If object's value is lesser, we recursively remove the
	 * object from the Left-child of current node. On the other hand, remove that object 
	 * from the right-child instead. If the target node is found we remove it from
	 * small BS-tree and return the new Root-node of this small BS-tree.
	 */
	@SuppressWarnings("unchecked")
	private Node remove(Node n, Object e) {
		if (n == null)
			return n;

		Comparable<Object> e_val = (Comparable<Object>) e;

		if (e_val.compareTo(n.data) < 0) {
			n.left_node = remove(n.left_node, e);
		} else if (e_val.compareTo(n.data) > 0) {
			n.right_node = remove(n.right_node, e);
		} else {
			// if the target node has single or no child
			// we can replace the target node with it's child node
			if (n.left_node == null || n.right_node == null) {
				n = n.left_node == null ? n.right_node : n.left_node;
				--size;
			} else {
				Node tmp = n.right_node;
				while (tmp.left_node != null)
					tmp = tmp.left_node;
				n.data = tmp.data;
				n.right_node = remove(n.right_node, tmp.data);
				/*
				 * Or we can write this function using iteration
				 * 
				 * Since we find the leftmost node on the right side of tree
				 * There are two possible nodes
				 * 
				 * 1) The left-most node has right child
				 * 
				 * We can replace the left-most node with it's right-child
				 * 
				 * if(tmp.right_node!=null){
				 * 
				 * tmp = tmp.right_node;
				 * 
				 * tmp.right_node = null;
				 * 
				 * --size; }
				 * 
				 * 2) The left-most node has no child
				 * 
				 * We can just removed it.
				 * 
				 * else{
				 * 
				 * tmp = null;
				 * 
				 * --size;
				 * 
				 * }
				 */
			}

		}
		return n;
	}

}

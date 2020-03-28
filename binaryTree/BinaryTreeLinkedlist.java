package binaryTree;

import java.util.*;

public class BinaryTreeLinkedlist {
	Node root;

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int val) {
			this.data = val;
			this.left = null;
			this.right = null;
		}
	}

	// Printing
	private void inorderTraversal(Node node) {
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
		else {
			if (node == null)
				return;
			inorderTraversal(node.left);
			System.out.print(node.data + " ");
			inorderTraversal(node.right);
		}
	}

	private void preorderTraversal(Node node) {
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
		else {
			if (node == null)
				return;
			System.out.print(node.data + " ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}

	private void postorderTraversal(Node node) {
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
		else {
			if (node == null)
				return;
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	private void levelorderTraversal(Node node) {
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
		else {
			if (node == null)
				return;
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			while (!q.isEmpty()) {
				Node temp = q.remove();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
	}

	// insert in tree
	private void insertNode(int val) {
		if (root == null) {
			root = new Node(val);
		} else {
			Node node = new Node(val);
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node temp = q.remove();
				if (temp.left == null) {
					temp.left = node;
					System.out.println("Inserted succesfully");
					return;
				} else if (temp.right == null) {
					temp.right = node;
					System.out.println("Inserted succesfully");
					return;
				} else {
					q.add(temp.left);
					q.add(temp.right);
				}
			}
		}
	}

	// search node in tree
	private void searchNode(int val) {
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
		else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node temp = q.remove();
				if (temp.data != val) {
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
				} else {
					System.out.println("Value Found");
					return;
				}
			}
		}
		System.out.println("Value Not Found");
	}

	// delete a node
	private void deleteNode(int val) {
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed before this");
		else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				Node temp = q.remove();
				if (temp.data != val) {
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
				} else {
					// System.out.println("Value Found");
					Node last = getDeepestNode();
					temp.data = last.data;
					// value of last node inserted on node to be deleted
					deleteDeepestNode();
					// now we deleted the deepest node inroder to avoid duplication
					// also releasing the parent link to it
					System.out.println("Node deleted successfully");
					return;
				}
			}
		}
		System.out.println("Value Not Found");
	}

	// search deepest node
	private Node getDeepestNode() {
		Node node = null;
		if (root.left == null && root.right == null) {
			node = root;
		} else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while (!q.isEmpty()) {
				node = q.remove();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
		return node;
	}

	// delete deepest node inorder to delete its parent references to it
	private void deleteDeepestNode() {
		Node node = null;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node previousNode = null;
		while (!q.isEmpty()) {
			previousNode = node;
			node = q.remove();
			if (node.left == null) {
				previousNode.right = null;
				return;
			} else if (node.right == null) {
				node.left = null;
			}
			q.add(node.left);
			q.add(node.right);
		}
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeLinkedlist bt = null;
		int option = 0;
		do {
			System.out.println("\n----------------Binary Tree using LL----------------");
			System.out.println("1. Create Binary Tree");
			System.out.println("2. Insert a Node");
			System.out.println("3. Delete a Node");
			System.out.println("4. Search Node");
			System.out.println("5. Traverse i.e Print Tree");
			System.out.println("6. Delete Binary Tree");
			System.out.println("7. Exit ");
			option = sc.nextInt();
			try {
				switch (option) {
				case 1:
					if (bt == null) {
						bt = new BinaryTreeLinkedlist();
						System.out.println("Binary Tree Created");
						bt.root = null;
					} else {
						System.out.println("Binary Tree already exist");
					}
					break;
				case 2:
					System.out.println("Please enter value to be inserted");
					int val = sc.nextInt();
					bt.insertNode(val);
					break;
				case 3:
					System.out.println("Please enter value to be deleted");
					int del = sc.nextInt();
					bt.deleteNode(del);
					break;
				case 4:
					System.out.println("Please enter value to be searched");
					int ser = sc.nextInt();
					bt.searchNode(ser);
					break;
				case 5:
					System.out.print("Inorder Traversal: ");
					bt.inorderTraversal(bt.root);
					System.out.print("\npreorder Traversal: ");
					bt.preorderTraversal(bt.root);
					System.out.print("\npostorder Traversal: ");
					bt.postorderTraversal(bt.root);
					System.out.print("\nLevel Order Traversal: ");
					bt.levelorderTraversal(bt.root);
					break;
				case 6:
					bt = null;
					System.out.println("Binary Tree deleted");
					break;
				case 7:
					System.out.println("Sayonara !");
					break;
				default:
					System.out.println("Please choose correct option !!!");
					break;
				}
			} catch (Exception e) {
				System.out.println("Did you forget to plant a see of Binary tree ?");
			}
		} while (option != 7);
	}
}

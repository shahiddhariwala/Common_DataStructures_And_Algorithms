package binaryTree;
/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
import java.util.*;

//I am considering here height of null node to be 0 not -1;
// it simplifies the code
public class AVLTree
{
	private Node root;
	static final int count = 10;

	public AVLTree()
	{
		root = null;
	}

	class Node
	{
		int data;
		int height;
		Node left;
		Node right;

		public Node(int val)
		{
			this.data = val;
			this.height = 1;
			// since this will, be leaf node its height is 0
		}
	}
	// searching some value

	private boolean searchNode(Node node, int val)
	{
		if (node == null)
		{
			return false;
		} else
		{
			if (val < node.data)
				searchNode(node.left, val);
			else if (node.data > val)
				searchNode(node.right, val);
			else
			{
				return true;
			}
		}
		return false;
	}

	// Inorder
	private void inOrderTraversal(Node node)
	{
		if (root == null)
			return;
		else
		{
			if (node == null)
				return;
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	// preorder
	private void preOrderTraversal(Node node)
	{
		if (root == null)
			return;
		else
		{
			if (node == null)
				return;
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	// postorder
	private void postOrderTraversal(Node node)
	{
		if (root == null)
			return;
		else
		{
			if (node == null)
				return;
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	// Levelorder
	private void levelOrderTraversal(Node node)
	{
		if (root == null)
			return;
		else
		{
			if (node == null)
				return;
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			while (!q.isEmpty())
			{
				Node temp = q.remove();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
	}

	private void printAVLTree(Node node, int space)
	{
		if (root == null)
		{
			System.out.println("AVL Tree is empty");
			return;
		}
		if (node == null)
		{
			
			return;
		}
		// we do inOrder traversal here
		// increase distance between levels
		space += count;
		// process from right
		printAVLTree(node.right, space);
		// print current node after space
		for (int i = count; i < space; i++)
		{
			System.out.print(" ");
		}
		System.out.println(node.data);
		// process from left
		printAVLTree(node.left, space);
		return;
	}

	// insertNode
	private Node insertNode(Node node, int val)
	{
		// if empty node found insert new node value
		if (node == null)
			return new Node(val);
		// BST operations
		if (val < node.data)
			node.left = insertNode(node.left, val);
		else if (val > node.data)
			node.right = insertNode(node.right, val);
		else
			return node;
		// check height
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		int balanceFactor = checkBalance(node);
		
		if (balanceFactor > 1 && val < node.left.data)
		{
			// LL Condition therefore right rotate
			return rightRotate(node);
		} 
		if (balanceFactor < -1 && val > node.right.data)
		{
			// RR condition therefore left rotate
			return leftRotate(node);
		}
		if (balanceFactor > 1 && val > node.left.data)
		{
			// LR Condition therefore first left rotate and then right rotate
//			  c(node)                     	    c                                          a
//			/  \                              /   \                                      /  \
//		   b    T4 						     a    T4                                    b    c
//		 /   \      ===leftRotate(b)===>   /  \             ===rightRotate(c)===>     / \   /  \
//		T1   a                            b    T3                                    T1 T2 T3  T4             
//		    / \                           /  \
//		   T2 T3                         T1   T2
//		
			node.left = leftRotate(node.left);
			return rightRotate(node);
		} 
		if (balanceFactor < -1 && val < node.right.data)
		{
			// RL Condition therefore first right rotate and then left rotate
//			  c(node)                     	    c                                          a
//			/  \                              /   \                                      /    \
//		   T4    b 						     T4    a                                    c      b
//		       /   \  ===rightRotate(b)===>      /  \       ===leftRotate(c)===>      /  \    /  \
//		       a    T3                          T1   b                               T4  T1  T2   T3             
//		      / \                                  /  \                                    
//		      T1 T2                               T2   T3                              
//		
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	// check balance
	private int checkBalance(Node node)
	{
		if (node == null)
			return 0;
		return getHeight(node.left) - getHeight(node.right);
	}

	// calculate height
	private int getHeight(Node node)
	{
		// I have created this function to tackle the null pointer exception
		// it can happen if we check node.height n node is null i.e null.height which is
		// not
		// good thing bruh !!
		if (node == null)
			return 0;
		else
		{
			return node.height;
		}
	}

	// left rotate
	private Node leftRotate(Node node)
	{
//	     My Assume Structure T's are subtree		
//			c(node)
//			/     \
//			T4     b
//	            /    \
//	            T3    a
//	                /   \
//	                T1  T2
//		----------------------------
//		after left rotate
//		        b
//		       /  \
//		       c    a
//		      / \   / \
//		     T4 T3 T1 T2
//		      
		// lets assign the nodes
		Node b = node.right;
		Node T3 = b.left;
		// lets rotate
		b.left = node;
		node.right = T3;
		// lets update the height height is dependent on its sub tree since T1 n T2
		// are not chsanging there fore a height wont be affected
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;
		return b;
	}

	// right rotate
	private Node rightRotate(Node node)
	{
//     My Assume Structure T's are subtree		
//		c(node)
//		/     \
//		b     T4
//      / \
//      c  T3
//    /  \
//    T1 T2
// -------------------------------
//		after right rotate
//		    b
//		  /   \
//		 a      c
//		/  \   / \ 
//	   T1  T2 T3  T4
		// lets assign the nodes
		Node b = node.left;
		Node T3 = b.right;
		// lets right rotate
		b.right = node;
		node.left = T3;
		// lets update height
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;
		return b;
	}

	private Node deleteNode(Node node)
	{
		return null;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		AVLTree at = null;
		int option = 0;
		do
		{
			System.out.println("=======AVL Tree========");
			System.out.println("1. Create AVL Tree");
			System.out.println("2. Insert a Node");
			System.out.println("3. Delete a Node");
			System.out.println("4. Search a Node");
			System.out.println("5. Traverse AVL Tree");
			System.out.println("6. Print Tree");
			System.out.println("7. Delete AVL Tree");
			System.out.println("8. EXIT");
			option = sc.nextInt();
			switch (option) {
			case 1:
				at = new AVLTree();
				System.out.println("AVL Tree is created");
				break;
			case 2:
				System.out.println("Please enter the value");
				at.root = at.insertNode(at.root, sc.nextInt());
				System.out.println("Node Inserted Succesfully");
				break;
			case 3:
				System.out.println("Please enter the value to be deleted");
				int del = sc.nextInt();
				if (at.searchNode(at.root, del))
					at.deleteNode(at.root);
				else
					System.out.println("Value not found in tree");
				break;
			case 4:
				System.out.println("Please enter value to be searched");
				if (at.searchNode(at.root, sc.nextInt()))
					System.out.println("Value Found");
				else
					System.out.println("Value not Found");
				break;
			case 5:
				System.out.print("Inorder Traversal: ");
				at.inOrderTraversal(at.root);
				System.out.print("\npreorder Traversal: ");
				at.preOrderTraversal(at.root);
				System.out.print("\npostorder Traversal: ");
				at.postOrderTraversal(at.root);
				System.out.print("\nLevel Order Traversal: ");
				at.levelOrderTraversal(at.root);
				System.out.println();
				break;
			case 6:
				System.out.println("Tree representation of AVL is as Follow");
				at.printAVLTree(at.root, 0);
				break;
			case 7:
				at = null;
				System.out.println("AVL Tree deleted");
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("Please choose correct option duh !!!!");
				break;
			}
		} while (option != 8);
	}
}

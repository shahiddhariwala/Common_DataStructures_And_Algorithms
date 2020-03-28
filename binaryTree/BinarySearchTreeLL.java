package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTree.BinaryTreeLinkedlist.Node;

public class BinarySearchTreeLL
{
	Node root;

	public BinarySearchTreeLL()
	{
		this.root = null;
	}

	class Node
	{
		int data;
		Node left;
		Node right;

		public Node(int val)
		{
			this.data = val;
			this.left = null;
			this.right = null;
		}
	}
	// Traversall

	// Printing
	private void inorderTraversal(Node node)
	{
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
		else
		{
			if (node == null)
				return;
			inorderTraversal(node.left);
			System.out.print(node.data + " ");
			inorderTraversal(node.right);
		}
	}

	private void preorderTraversal(Node node)
	{
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
		else
		{
			if (node == null)
				return;
			System.out.print(node.data + " ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}

	private void postorderTraversal(Node node)
	{
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
		else
		{
			if (node == null)
				return;
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	private void levelorderTraversal(Node node)
	{
		if (root == null)
			System.out.println("Tree is empty bruh !! Please plant a seed");
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

	// search value
	private void searchNode(Node node, int ser)
	{
		if (node == null)
		{
			System.out.println("Value does not Exist");
			return;
		}
		if (node.data == ser)
			System.out.println("Value Found Bruh !!");
		else if (ser < node.data)
			searchNode(node.left, ser);
		else
			searchNode(node.right, ser);
	}

	// insertNode
	private Node insertNode(Node node, int val)
	{
		if (node == null)
		{
			System.out.println("Succesfully Inserted Value");
			return new Node(val);
		} else if (val <= node.data)
			node.left = insertNode(node.left, val);
		else if (val > node.data)
		{
			node.right = insertNode(node.right, val);
		}
		return node;
	}

	// delete node
	private Node deleteNode(Node node, int val)
	{
		if (node == null)
		{
			System.out.println("Value not found in tree");
			return null;
		}
			
		if (val < node.data)
			node.left = deleteNode(node.left, val);
		else if (val > node.data)
			node.right = deleteNode(node.right, val);
		else
		{
			if (node.right == null && node.left == null)
			{
				// no child is present
				node = null;
			} else if (node.right != null && node.left != null)
			{
				Node temp = getMinimumFromRight(node.right);
				//temp is sucessor of our current node
				node.data=temp.data;
				temp=null;
			} else if (node.left == null)
			{
				// right child is present & no left child
				node = node.right;
			} else
			{
				// left child is present & no right child
				node = node.left;
			}
			System.out.println("Deleted Succesfully ");
		}
		return node;
	}
	//getting successor of that node
	private Node getMinimumFromRight(Node node)
	{
		if(node.left==null)
			return node;
		else
			return getMinimumFromRight(node.left);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BinarySearchTreeLL bt = null;
		int option = 0;
		try
		{
			do
			{
				System.out.println("\n----------------Binary Search Tree using LL----------------");
				System.out.println("1. Create Binary Tree");
				System.out.println("2. Insert a Node");
				System.out.println("3. Delete a Node");
				System.out.println("4. Search Node");
				System.out.println("5. Traverse i.e Print Tree");
				System.out.println("6. Delete Binary Tree");
				System.out.println("7. Exit ");
				option = sc.nextInt();
				try
				{
					switch (option) {
					case 1:
						if (bt == null)
						{
							bt = new BinarySearchTreeLL();
							System.out.println("Binary Search Tree Created");
						} else
						{
							System.out.println("Binary Search Tree already exist");
						}
						break;
					case 2:
						System.out.println("Please enter value to be inserted");
						int val = sc.nextInt();
						bt.root = bt.insertNode(bt.root, val);
						break;
					case 3:
						System.out.println("Please enter value to be deleted");
						int del = sc.nextInt();
						bt.deleteNode(bt.root, del);
						
						break;
					case 4:
						System.out.println("Please enter value to be searched");
						int ser = sc.nextInt();
						bt.searchNode(bt.root, ser);
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
						System.out.println("Binary Search Tree deleted");
						break;
					case 7:
						System.out.println("Sayonara !");
						break;
					default:
						System.out.println("Please choose correct option !!!");
						break;
					}
				} catch (Exception e)
				{
					System.out.println("Did you forget to plant a see of Binary tree ?");
				}
			} while (option != 7);
		} catch (Exception e)
		{
			System.out.println("Something went Wrong !!");
		}
	}
}

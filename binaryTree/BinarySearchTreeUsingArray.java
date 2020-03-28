package binaryTree;

import java.util.Scanner;

public class BinarySearchTreeUsingArray
{
	int arr[];
	int lastUsedIndex;

	// create binary search tree
	public BinarySearchTreeUsingArray()
	{
		// size is problematic in array
		// as BST can be very unbalanced
		// it depends heavily on the input
		// to avoid error I have initialized it to 10000,
		// better to use LinkedList to make it more space efficient
		this.arr = new int[10000];
		lastUsedIndex = 0;
		// initialise
		for (int i = 0; i < 10000; i++)
		{
			arr[i] = Integer.MIN_VALUE;
		}
	}

	// InOrder Traversal
	private void inOrderTraversal(int index)
	{
		if (lastUsedIndex == 0)
		{
			System.out.println("Sorry Tree is Empty");
			return;
		} else if (index > lastUsedIndex)
			return;
		else
		{
			inOrderTraversal(index * 2);
			if (arr[index] != Integer.MIN_VALUE)
			{
				System.out.print(arr[index] + " ");
			}
			inOrderTraversal(index * 2 + 1);
		}
	}

	// postOrderTraversal
	private void postOrderTraversal(int index)
	{
		if (lastUsedIndex == 0)
		{
			System.out.println("Sorry Tree is Empty");
			return;
		} else if (index > lastUsedIndex)
			return;
		else
		{
			postOrderTraversal(index * 2);
			postOrderTraversal(index * 2 + 1);
			if (arr[index] != Integer.MIN_VALUE)
				System.out.print(arr[index] + " ");
		}
	}

	// preOrderTraversal
	private void preOrderTraversal(int index)
	{
		if (lastUsedIndex == 0)
		{
			System.out.println("Sorry Tree is Empty");
			return;
		} else if (index > lastUsedIndex)
			return;
		else
		{
			if (arr[index] != Integer.MIN_VALUE)
				System.out.print(arr[index] + " ");
			preOrderTraversal(index * 2);
			preOrderTraversal(index * 2 + 1);
		}
	}

	// levelOrderTraversal
	private void levelOrderTraversal(int index)
	{
		if (lastUsedIndex == 0)
		{
			System.out.println("Sorry Tree is Empty");
			return;
		} else
		{
			for (int i = index; i <= lastUsedIndex; i++)
				if (arr[i] != Integer.MIN_VALUE)
					System.out.printf("%d ", arr[i]);
		}
	}

	// search Node
	private int searchNode(int index, int val)
	{
		if (lastUsedIndex == 0)
		{
			System.out.println("Sorry Tree is Empty");
			return Integer.MIN_VALUE;
		} else
		{
			if (arr[index] == val)
			{
				System.out.println("Node Found");
				return index;
			}
			if (val < arr[index])
				searchNode(index * 2, val);
			else
				searchNode(index * 2 + 1, val);
		}
		System.out.println("Node Not Found Bruh :'(");
		return Integer.MIN_VALUE;
	}

	// insertNode
	private void insertNode(int index, int val)
	{
		// if first node
		if (arr[1] == Integer.MIN_VALUE)
		{
			arr[1] = val;
			lastUsedIndex = 1;
		} else if (arr[index] == Integer.MIN_VALUE)
		{
			arr[index] = val;
			lastUsedIndex = index;
		} else if (val < arr[index])
			insertNode(2 * index, val);
		else
			insertNode(2 * index + 1, val);
	}

	// delete a node
	private void deleteNode(int index, int val)
	{
		int valIndex = searchNode(index, val);
		if (valIndex == Integer.MIN_VALUE)
		{
			return;
		} else
		{
			if (arr[valIndex * 2] == Integer.MIN_VALUE && arr[valIndex * 2 + 1] == Integer.MIN_VALUE)
			{
				// if its leaf node
				arr[valIndex] = Integer.MIN_VALUE;
			} else if (arr[valIndex * 2] != Integer.MIN_VALUE && arr[valIndex * 2 + 1] != Integer.MIN_VALUE)
			{
				// it it has two child nodes
				// find successor from right subtree and replace it
				int successorIndex = getSuccessor(valIndex);
				arr[valIndex] = arr[successorIndex];
				// reset successor i.e delete it
				arr[successorIndex] = Integer.MIN_VALUE;
			} else if (arr[valIndex * 2] == Integer.MIN_VALUE)
			{
				// no left child
				arr[valIndex] = arr[valIndex * 2 + 1];
				// yaha it will lag as we will have to shift all child of
				// arr[valIndex * 2+1]nodes by valIndex * 2+1
			}
		}
	}

	private int getSuccessor(int index)
	{
		if (arr[index * 2] == Integer.MIN_VALUE)
			return index;
		else
			return getSuccessor(index * 2);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BinarySearchTreeUsingArray bt = null;
		int option = 0;
		do
		{
			System.out.println("\n----------------Binary Search Tree using Array----------------");
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
						bt = new BinarySearchTreeUsingArray();
						System.out.println("Binary Search Tree Created");
					} else
					{
						System.out.println("Binary Search Tree already exist");
					}
					break;
				case 2:
					System.out.println("Please enter value to be inserted");
					int val = sc.nextInt();
					bt.insertNode(1, val);
					break;
				case 3:
					System.out.println("Please enter value to be deleted");
					int del = sc.nextInt();
					bt.deleteNode(1, del);
					break;
				case 4:
					System.out.println("Please enter value to be searched");
					int ser = sc.nextInt();
					bt.searchNode(1, ser);
					break;
				case 5:
					System.out.print("Inorder Traversal: ");
					bt.inOrderTraversal(1);
					System.out.print("\npreorder Traversal: ");
					bt.preOrderTraversal(1);
					System.out.print("\npostorder Traversal: ");
					bt.postOrderTraversal(1);
					System.out.print("\nLevel Order Traversal: ");
					bt.levelOrderTraversal(1);
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
				System.out.println("Did you forget to plant a seed of Binary Search tree ?");
			}
		} while (option != 7);
		sc.close();
	}
}

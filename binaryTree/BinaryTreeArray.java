package binaryTree;

import java.util.Scanner;

public class BinaryTreeArray {
	int arr[];
	int lastUsedIndex;
	
	//create binary tree
	public BinaryTreeArray(int size)
	{
		this.arr= new int[size];
		lastUsedIndex=0;
	}
	
	//Insert a Node
	private void insertNode(int val)
	{
		if(lastUsedIndex+1>this.arr.length)
		{
			System.out.println("Sorry Tree is Full");
			return;
		}
		else
		{
			arr[lastUsedIndex+1]=val;
			++lastUsedIndex;
		}
		System.out.println("Value Inserted");
	}
	
	//InOrder Traversal
	private void inOrderTraversal(int index)
	{
		if(lastUsedIndex==0)
		{
			System.out.println("Sorry Tree is Empty");
			return;
		}
		else if(index>lastUsedIndex)
			return;
		else
		{
			inOrderTraversal(index*2);
			System.out.print(arr[index]+" ");
			inOrderTraversal(index*2+1);
		}
	}
	
	//postOrderTraversal
	private void postOrderTraversal(int index)
	{
		if(lastUsedIndex==0)
		{
			System.out.println("Sorry Tree is Empty");
			return;
		}
		else if(index>lastUsedIndex)
			return;
		else
		{
			postOrderTraversal(index*2);
			postOrderTraversal(index*2+1);
			System.out.print(arr[index]+" ");
		}
	}

	
	//preOrderTraversal
	private void preOrderTraversal(int index)
	{
		if(lastUsedIndex==0)
		{
			System.out.println("Sorry Tree is Empty");
			return;
		}
		else if(index>lastUsedIndex)
			return;
		else
		{
			System.out.print(arr[index]+" ");
			preOrderTraversal(index*2);
			preOrderTraversal(index*2+1);
		}
	}
	
	//levelOrderTraversal
	private void levelOrderTraversal(int index)
	{
		if(lastUsedIndex==0)
		{
			System.out.println("Sorry Tree is Empty");
			return;
		}
		else
		{
			for(int i=1;i<=lastUsedIndex;i++)
				System.out.printf("%d ",arr[i]);
		}
	}
	//search node
	private int searchNode(int val)
	{
		if(lastUsedIndex==0)
		{
			System.out.println("Sorry Tree is Empty");
			return Integer.MIN_VALUE;
		}
		else
		{
			for(int i=1;i<=lastUsedIndex;i++)
			{
				if(arr[i]==val)
					{
					System.out.println("Node Found");
						return i;
						
					}
			}
		}
		System.out.println("Node Not Found Bruh :'(");
		return Integer.MIN_VALUE;
	}
	//delete a Node
	private void deleteNode(int val)
	{
		int indexOfVal = searchNode(val);
		if(indexOfVal>0)
		{
			arr[indexOfVal]=arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("& 3...2...1... Booooom Node Deleted Bruh");
		}
		else
		{
			System.out.println("Sorry Node Not Found");
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeArray bt = null;
		int option = 0;
		do {
			System.out.println("\n----------------Binary Tree using Array----------------");
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
						System.out.println("Please enter the size of tree i.e Array size here");
						int size= sc.nextInt();
						bt = new BinaryTreeArray(size+1);
						System.out.println("Binary Tree Created");
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

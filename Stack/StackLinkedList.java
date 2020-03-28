package Stack;

import java.util.Scanner;

public class StackLinkedList {
	static Node head;
	static Node tail;
	static int lastIndex=-1;
	static class Node {
		int data;
		Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int val) {
			this.data = val;
			this.next = null;
		}
	}
	static void push(int val)
	{
		Node temp = new Node(val);
		if(isEmpty())
		{
			//if stack is empty i.e no nodes are there
			head=temp;
			tail=head;
			lastIndex++;
		}
		else
		{
			temp.next=head;
			head=temp;
			lastIndex++;
		}
		System.out.printf("Pushed %d into Stack",val);
		
	}
	static void pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
		}
		else
		{
			lastIndex--;
			System.out.printf("Popped %d out of stack",head.data);
			head=head.next;
		}
	}
	static int peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
			return Integer.MIN_VALUE;
		}
		return head.data;
	}
	static void printList()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Stack is as below peek-a-boo");
		Node temp=head;
		while(temp.next!=null)
		{
			System.out.printf("|%d|\n",temp.data);
			temp=temp.next;
		}
		System.out.printf("|%d|\n",temp.data);
	}
	private static boolean isEmpty() {
		if(lastIndex==-1)
			return true;
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			System.out.println("\n\n------------------Stack using LinkedList------------------");
			System.out.println("1. Create Stack");
			System.out.println("2. Push");
			System.out.println("3. Pop");
			System.out.println("4. Peek");
			System.out.println("5. isEmpty?");
			System.out.println("6. Print Stack");
			System.out.println("7. EXIT");
			option = sc.nextInt();
			switch (option) {
			case 1:
				head = new Node();
				tail=head;
				System.out.println("Stack created Succesfully");
				break;
			case 2:
				System.out.println("Enter Value");
				int val = sc.nextInt();
				push(val);
				break;
			case 3:
				pop();
				break;
			case 4:
				System.out.println("Value at top is ->" + peek());
				break;
			case 5:
				System.out.println("is Empty ? " + isEmpty());
				break;
			case 6:
				printList();
				break;
			case 7:
				System.out.println("Sayonara !!!");
				;
				break;
			default:
				System.out.println("Please choose correct option bro:)");
				break;
			}
		} while (option != 7);
	}
}

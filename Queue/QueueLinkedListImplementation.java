/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package Queue;

import java.util.Scanner;

public class QueueLinkedListImplementation {
	int len;
	Node head;
	Node tail;
	
	class Node
	{
		int data;
		Node next;
		public Node(int val)
		{
			this.data=val;
			this.next=null;
		}
	}
	//Enqueue 
	private void enQueue(int val)
	{
		Node node = new Node(val);
		if(isEmpty())
		{
			//creating first node
			head=node;
			tail=node;
		}
		else
		{
			//if head is already present just append at tail
			tail.next=node;
			tail=node;
		}
		System.out.println("Enqueued => "+node.data);
	}
	//Dequeue
	private void deQueue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty Broooooooo");
		}
		else
		{
			System.out.println("Dequeued => "+head.data);
			head=head.next;
		}
	}
	//Peek
	private int peek()
	{
		if(isEmpty())
		{
			return Integer.MAX_VALUE;
		}
		else 
			return head.data;
	}
	//isEmpty
	private boolean isEmpty()
	{
		if(head==null && tail==null)
			return true;
		return false;
	}
	//PrintList
	private void printList() 
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty Broooooooo");
		}
		else
		{
			Node temp = head;
			while(temp.next!=null)
			{
				System.out.printf("<-|%d|",temp.data);
				temp=temp.next;
			}
			System.out.printf("<-|%d|",temp.data);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueLinkedListImplementation Q=null;
		int option=0;
		do
		{
			try {
				System.out.println("\n\n------------------Queue using LinkedList------------------");
				System.out.println("1. Create Queue");
				System.out.println("2. enQueue");
				System.out.println("3. deQueue");
				System.out.println("4. Peek");
				System.out.println("5. isEmpty?");
				System.out.println("6. Print Queue");
				System.out.println("7. EXIT");
				option=sc.nextInt();
				switch(option)
				{
					case 1:
						Q=new QueueLinkedListImplementation();
						Q.head=null;
						Q.tail=null;
						System.out.println("Object Initialised ; Queue created Succesfully");
						break;
					case 2:
						System.out.println("Enter Value");
						int val = sc.nextInt();
						Q.enQueue(val);
						break;
					case 3:
						Q.deQueue();
						break;
					case 4:
						System.out.println("Value at start is ->"+Q.peek());
						break;
					case 5:
						System.out.println("is Empty ? "+Q.isEmpty());
						
						break;
					case 6:
						System.out.println("Queue is as below peek-a-boo");
						Q.printList();
						break;
					case 7:
						System.out.println("Sayonara !!!");;
						break;
					default:
						System.out.println("Please choose correct option bro:)");
						break;
				}
			}
			catch(NullPointerException e)
			{
				System.out.println("C'mon Bro did you create a Queue (-___-\\)");
			}
			
			
		}while(option!=7);
	}
}

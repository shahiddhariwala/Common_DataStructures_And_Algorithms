package Queue;

import java.util.*;

public class QueueArrayImplementation {
	int arr[];
	int len;
	int startIndex=0;
	int lastIndex=-1;
	private void enQueue(int val)
	{
		if(isFull())
		{
			System.out.println("Sorry Queue is Full");
			return;
		}
		else
		{
			arr[++lastIndex]=val;
		}
		System.out.println("Succesfully enQueued "+val);
	}
	private boolean isFull() {
		if(lastIndex==len-1)
			return true;
		return false;
	}
	private void deQueue() {
		if(isEmpty())
		{
			System.out.println("Sorry Queue is Empty");
		}
		else
		{
			System.out.printf("Value %d deQueued",arr[startIndex++]);
			if(startIndex>lastIndex)
				{
				startIndex=0;
				lastIndex=-1;
				}
		}
		
	}
	private boolean isEmpty() {
		if(lastIndex==-1)
			return true;
		return false;
	}
	private void printList()
	{
		System.out.println();
		for(int i=startIndex;i<=lastIndex;i++)
		{
			System.out.printf("<--|%d|",arr[i]);
		}
		System.out.println();
	}
	private int peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		}
		else
		{
		return arr[startIndex];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		QueueArrayImplementation Q = new QueueArrayImplementation();
		int option=0;
		do
		{
			System.out.println("\n\n------------------Queue using Array------------------");
			System.out.println("1. Create Queue");
			System.out.println("2. enQueue");
			System.out.println("3. deQueue");
			System.out.println("4. Peek");
			System.out.println("5. isEmpty?");
			System.out.println("6. isFull?");
			System.out.println("7. EXIT");
			option=sc.nextInt();
			switch(option)
			{
				case 1:
					System.out.println("Please Enter the size of Queue");
					Q.len =sc.nextInt();
					Q.arr=new int[Q.len];
					System.out.println("Queue created Succesfully");
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
					System.out.println("Queue is as below peek-a-boo");
					Q.printList();
					break;
				case 5:
					System.out.println("is Empty ? "+Q.isEmpty());
					
					break;
				case 6:
					System.out.println("is Full ? "+Q.isFull());
					break;
				case 7:
					System.out.println("Sayonara !!!");;
					break;
				default:
					System.out.println("Please choose correct option bro:)");
					break;
			}
			
		}while(option!=7);
		
	}
	
}


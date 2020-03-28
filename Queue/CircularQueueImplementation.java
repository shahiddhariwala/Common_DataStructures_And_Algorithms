package Queue;

import java.util.*;

public class CircularQueueImplementation {
	int arr[];
	int len;
	int startIndex = 0;
	int lastIndex = -1;

	private void enQueue(int val) {
		if (arr == null) {
			System.out.println("Please first create Queue Don't be in rush !!!");
			return;
		} else if (isFull()) {
			System.out.println("Sorry Queue is Full");
			return;
		} else {
			
			if (lastIndex+1 == len)
				lastIndex = -1;
			arr[++lastIndex] = val;
			
		}
		System.out.println("Succesfully enQueued " + val);
	}

	private boolean isFull() {
		if (lastIndex + 1 == startIndex && lastIndex !=-1)
			return true;
		else if(startIndex==0 && lastIndex==len-1)
			return true;
		return false;
	}

	private void deQueue() {
		if (arr == null) {
			System.out.println("Please first create Queue DOnt be in rush !!!");
			return;
		} else if (isEmpty()) {
			System.out.println("Sorry Queue is Empty");
		} else {
			
			System.out.printf("Value %d deQueued", arr[startIndex]);
			if(startIndex==lastIndex)
				{
				lastIndex=-1;
				startIndex=0;
				}
			else if(startIndex==len)
				{
					startIndex=0;
				}
			else 
			{
				startIndex++;
			}
				
			
			
		}
	}

	private boolean isEmpty() {
		if (lastIndex == -1)
			return true;
		return false;
	}

	private void printList() {
		System.out.println();
		int start = startIndex;
		if (startIndex == -1) {
			System.out.println("Queue is Empty");
			return;
		}
		System.out.println("Queue is as below peek-a-boo");
		while (start != lastIndex && lastIndex !=-1)
		{
			System.out.printf("<--|%d|", arr[start++]);
			if (start == len)
				start = 0;
		} 
		if(start == lastIndex)
		{
			System.out.printf("<--|%d|", arr[start++]);
		}
		
		System.out.println("\n Actual Array looks like below from arr[0] to arr[len-1]");
		for (int i = 0; i < len; i++) {
			System.out.printf("<--|%d|", arr[i]);
		}
	}

	private int peek() {
		if (arr == null) {
			System.out.println("Please first create Queue Don't be in rush !!!");
			return Integer.MIN_VALUE;
		}
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		} else {
			return arr[startIndex];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularQueueImplementation CQ = new CircularQueueImplementation();
		int option = 0;
		do {
			System.out.println("\n\n------------------Circular Queue using Array------------------");
			System.out.println("1. Create Circular Queue");
			System.out.println("2. enQueue");
			System.out.println("3. deQueue");
			System.out.println("4. Peek");
			System.out.println("5. isEmpty?");
			System.out.println("6. isFull?");
			System.out.println("7. EXIT");
			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Please Enter the size of Queue");
				CQ.len = sc.nextInt();
				CQ.arr = new int[CQ.len];
				CQ.lastIndex=-1;
				CQ.startIndex=0;
				System.out.println("Queue created Succesfully");
				break;
			case 2:
				System.out.println("Enter Value");
				int val = sc.nextInt();
				CQ.enQueue(val);
				break;
			case 3:
				CQ.deQueue();
				break;
			case 4:
				System.out.println("Value at start is ->" + CQ.peek());
				CQ.printList();
				break;
			case 5:
				System.out.println("is Empty ? " + CQ.isEmpty());
				break;
			case 6:
				System.out.println("is Full ? " + CQ.isFull());
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

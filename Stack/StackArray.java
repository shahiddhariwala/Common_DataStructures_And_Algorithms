package Stack;

import java.util.*;

public class StackArray {
	int arr[];
	int len;
	int topIndex=-1;
	private void push(int val)
	{
		if(isFull())
		{
			System.out.println("Sorry Stack is Full");
			return;
		}
		else
		{
			arr[++topIndex]=val;
		}
		System.out.println("Succesfully Pushed "+val);
	}
	private boolean isFull() {
		if(topIndex==len-1)
			return true;
		return false;
	}
	private void pop() {
		if(isEmpty())
		{
			System.out.println("Sorry stack is Empty");
		}
		else
		{
			System.out.printf("Value %d popped from stack",arr[topIndex]);
			topIndex--;
		}
		
	}
	private boolean isEmpty() {
		if(topIndex==-1)
			return true;
		return false;
	}
	private void printList()
	{
		System.out.println();
		for(int i=topIndex;i>-1;i--)
		{
			System.out.printf("|%d|\n",arr[i]);
		}
		
	}
	private int peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
			return Integer.MIN_VALUE;
		}
		else
		{
		return arr[topIndex];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StackArray list = new StackArray();
		int option=0;
		do
		{
			System.out.println("\n\n------------------Stack using Array------------------");
			System.out.println("1. Create Stack");
			System.out.println("2. Push");
			System.out.println("3. Pop");
			System.out.println("4. Peek");
			System.out.println("5. isEmpty?");
			System.out.println("6. isFull?");
			System.out.println("7. EXIT");
			option=sc.nextInt();
			switch(option)
			{
				case 1:
					System.out.println("Please Enter the size of Stack");
					list.len =sc.nextInt();
					list.arr=new int[list.len];
					System.out.println("Stack created Succesfully");
					break;
				case 2:
					System.out.println("Enter Value");
					int val = sc.nextInt();
					list.push(val);
					break;
				case 3:
					list.pop();
					break;
				case 4:
					System.out.println("Value at top is ->"+list.peek());
					System.out.println("Stack is as below peek-a-boo");
					list.printList();
					break;
				case 5:
					System.out.println("is Empty ? "+list.isEmpty());
					
					break;
				case 6:
					System.out.println("is Full ? "+list.isFull());
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

/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package LinkedList;
import java.util.*;

public class DoubleCLL {
    Node head;
    //for maintaining start
	Node tail;
	//for maintaining end
	int last=0;
	//for maintaining number of nodes 
	
	static class Node
	{
		int data;
		Node next;
		Node prev;
		
		public Node()
		{
			this.data=0;
			this.next=null;
			this.prev=null;
		}
		public Node(int val)
		{
			this.data=val;
			this.next=null;
			this.prev=null;
		}
		
	}
	private void insert(int loc, int val) {
		//If location is at start 
		//if location is last
		//if at some specific location
		Node node = new Node(val);
		if(head==null)
		{
			//i.e list is empty
			head=node;
			tail=node;
			node.next=node;
			last=0;
			System.out.print("Head Initialised at Loc 0 as it was empty\n");
		}
		else if(loc==0)
		{
			System.out.print("Head Replaced\n");
			//want to insert at start of LL
			node.next=head;
			node.prev=null;
			head=node;
			tail.next=node;
			head.prev=tail;
			last+=1;
		}
		else if(loc==last+1)
		{
			System.out.print("Tail Replaced\n");
			//want to insert at Last
			tail.next=node;
			node.prev=tail;
			node.next=head;
			tail=node;
			last++;
		}
		else if(loc > last+1)
		{
			//fail safe by default value will be added at last
			System.out.println("Please enter valid location from next time\n"
					+ "for now value is added at last of Linked List");
			tail.next=node;
			node.next=head;
			node.prev=tail;
			tail=node;
			last++;
		}
		else
		{
			//want to insert at specified location
			Node temp=head;
			int i=0;
			while(temp.next!=tail && i!=loc-1)
			{
				temp=temp.next;
				i++;
			}
			node.prev=temp;
			node.next=temp.next;
			temp.next.prev=node;
			temp.next=node;
			last+=1;
		}
		System.out.println("Value added to List");
	}
	//delete node
	private void delete(int loc) {
		//If location is at start 
		//if location is last
		//if at some specific location
		if(head==null)
			{
				System.out.println("List is empty");
				return;
			}
		else if(loc == 0)
		{
			// removing first Node
			
			if(head.next==null)
				{
				//if head is only element
				head=null;
				tail=null;
				last=0;
				System.out.println(" Last node deleted; List is Empty; ");
				}
			else
				{
					head=head.next;
					head.prev=tail;
					last--;
				}
			
		}
		else if(loc==last)
		{
			//removing last element
			tail.next=null;
			tail=tail.prev;
			head.prev=tail;
			tail.next=head;
			last--;
		}
		else if(loc > last)
		{
			//if location is outside
			System.out.println("Please enter valid location out of range");
		}
		else
		{
			//if deleting in between nodes
			Node temp = head;
			int i=0;
			while(temp.next!= tail && i!=loc-1)
				{
				temp=temp.next;
				i++;
				}
			temp.next.prev=null;
			temp.next=temp.next.next;
			temp.next.prev.next=null;
			temp.next.prev=temp;
			
			
			last--;
		}
		System.out.println("Node Deleted Successfully");
		return;
	}
	
	//search value
	private void search(int val)
	{
		if(head==null)
		{
			//i.e list is empty
			System.out.println("List is empty");
		}
		else
		{
			Node temp=head;
			while(temp.data!=val && temp!=tail)
			{
				temp=temp.next;
			}
			if(temp.data==val)
				{
				System.out.println("Value Found");
				return;
				}			
		}		
		System.out.println("Value Not Found");
	}
	
	//Print ll
	
	private void printList()
	{
		if(head==null)
		{
			//i.e list is empty
			System.out.println("List is empty");
		}
		else
		{
			//using only head forward traversal
			System.out.print("Forward Traversal using next = [ ");
			Node temp=head;
			while(temp!=tail)
			{
				System.out.print(temp.data+"-->");
				temp=temp.next;
			}
			System.out.print(temp.data+" ]");
			//using only prev reverse traversal
			System.out.print("\nReverse Traversal using prev = [ ");
			Node tempt=tail;
			while(tempt!=head)
			{
				System.out.print(tempt.data+"-->");
				tempt=tempt.prev;
			}
			System.out.print(tempt.data+" ]");
		}
		
		System.out.println("");

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option=0;
		DoubleCLL list = new DoubleCLL();
		do
		{
			System.out.println("\n\n------------------Double Circular LinkedList------------------");
			System.out.println("1. Create LinkedList");
			System.out.println("2. Insert Node");
			System.out.println("3. Delete Node");
			System.out.println("4. Print i.e Traverse LinkedList");
			System.out.println("5. Delete LinkedList");
			System.out.println("6. Search Value");
			System.out.println("7. EXIT");
			option=sc.nextInt();
			switch(option)
			{
				case 1:
					list.head=null;
					list.tail=null;
					System.out.println("Linked List created Succesfully");
					break;
				case 2:
					System.out.println("Enter Location and Value");
					int loc = sc.nextInt();
					int val = sc.nextInt();
					list.insert(loc,val);
					break;
				case 3:
					System.out.println("Enter Location of node to be deleted");
					list.delete(sc.nextInt());
					break;
				case 4:
					list.printList();
					break;
				case 5:
					//as every node has two references to a node i.e prev and next, we can either delete one from each of node and then let gc do the magic
					Node temp=list.head;
					while(temp!=list.tail)
					{
						temp.prev=null;
						temp=temp.next;
					}
					list.head=null;
					list.tail=null;
					
					System.out.println("Linked List Deleted Succesfully");
					
					break;
				case 6:
					System.out.println("Enter the value to be search");
					list.search(sc.nextInt());
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

/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package greedyProblems;
import java.util.ArrayList;
import java.util.Collections;
class Knapsack implements Comparable<Knapsack>
{
	int index;
	int weight;
	int value;
	double ratio;
	
	public Knapsack(int index, int weight,int value)
	{
		this.index=index;
		this.weight=weight;
		this.value=value;
		this.ratio=(double)value/(double)weight;
	}

	@Override
	public int compareTo(Knapsack o)
	{
		// TODO Auto-generated method stub
		if(this.ratio>o.ratio)
			return -1;
		else
			return 1;
		
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Item - "+this.index+"\tWeight: "+this.weight+"\tValue: "+this.value+"\t Density: "+this.ratio;
	}
	
}


public class Greedy_Fractional_Knapsack
{
	public static void doSomeRobbingBro(ArrayList<Knapsack> arrayList,int capacity)
	{
		Collections.sort(arrayList);
		
		System.out.println("\n\n\n\n\n\nChecking....");
		
		
		double totalValueLooted=0;
		for(int i=0;i<arrayList.size();i++)
		{
			if((capacity-arrayList.get(i).weight)>0)
			{
				System.out.println("Taken "+arrayList.get(i));
				capacity=capacity-arrayList.get(i).weight;
				totalValueLooted+=arrayList.get(i).value;
			}
			else
			{
				
				double valueTaken = (double) (capacity*arrayList.get(i).ratio);
				
				capacity=0;
				totalValueLooted+=valueTaken;
				System.out.println("Fractional Value "+valueTaken+" Taken of Item - "+arrayList.get(i).index);
			}
			
			if(capacity==0)
			{
				break;
			}
		}
		System.out.printf("\nTotal Value %.3f",totalValueLooted);
	}
	public static void main(String[] args) {
		ArrayList<Knapsack> arrayList = new ArrayList<Knapsack>();
		
		int capacityOfSack=10;
		arrayList.add(new Knapsack(1, 6, 5));
		arrayList.add(new Knapsack(2, 10, 2));
		arrayList.add(new Knapsack(3, 3, 1));
		arrayList.add(new Knapsack(4, 5, 8));
		arrayList.add(new Knapsack(5, 1, 3));
		arrayList.add(new Knapsack(6, 3, 5));
		
		System.out.println("Following are the Items \n");
		for(Knapsack s : arrayList)
			System.out.println(s);
		
		doSomeRobbingBro(arrayList,capacityOfSack);
	}
}

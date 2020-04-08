/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

class Knapsack implements Comparable<Knapsack>
{
	int index;
	int weight;
	int value;
	double ratio;

	public Knapsack(int index, int weight, int value)
	{
		this.index = index;
		this.weight = weight;
		this.value = value;
		this.ratio = (double) value / (double) weight;
	}

	@Override
	public int compareTo(Knapsack o)
	{
		// TODO Auto-generated method stub
		if (this.ratio > o.ratio)
			return -1;
		else
			return 1;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Item - " + this.index + "\tWeight: " + this.weight + "\tValue: " + this.value + "\t Density: "
				+ this.ratio;
	}
}

public class DP_Zero_One_Knapsack
{
	static int topDownDp[][];
	static int bottomUpDp[][];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int letsDoSomeRobbing(ArrayList<Knapsack> arrayList, int index, int capacityOfSack, int profit)
	{
		dnc_CallCount++;
		if (capacityOfSack <= 0 || index >= arrayList.size())
		{
			return 0;
		} else
		{
			int currentWeight = arrayList.get(index).weight;
			int currentValue = arrayList.get(index).value;
			int takingCurrent = 0;
			if (capacityOfSack - currentWeight >= 0)
			{
				takingCurrent = currentValue + letsDoSomeRobbing(arrayList, index + 1, capacityOfSack - currentWeight,
						profit + currentValue);
			}
			int notTakingCurrent = letsDoSomeRobbing(arrayList, index + 1, capacityOfSack, profit);
			return Math.max(takingCurrent, notTakingCurrent);
		}
	}

	public static int letsDoSomeRobbingUsingTopDownDP(ArrayList<Knapsack> arrayList, int index, int capacityOfSack,
			int profit)
	{
		dp_TDCallCount++;
		if (capacityOfSack <= 0 || index >= arrayList.size())
		{
			return 0;
		} else
		{
			if (topDownDp[index][capacityOfSack] == 0)
			{
				int currentWeight = arrayList.get(index).weight;
				int currentValue = arrayList.get(index).value;
				int takingCurrent = 0;
				if (capacityOfSack - currentWeight >= 0)
				{
					takingCurrent = currentValue + letsDoSomeRobbingUsingTopDownDP(arrayList, index + 1,
							capacityOfSack - currentWeight, profit + currentValue);
				}
				int notTakingCurrent = letsDoSomeRobbingUsingTopDownDP(arrayList, index + 1, capacityOfSack, profit);
				topDownDp[index][capacityOfSack] = Math.max(takingCurrent, notTakingCurrent);
			}
		}
		return topDownDp[index][capacityOfSack];
	}

	public static int letsDoSomeRobbingUsingBottomUpDP(ArrayList<Knapsack> arrayList, int index, int capacityOfSack,
			int profit)
	{
		dp_BUCallCount++;
		
//		System.out.println("Printing DP bottom up table");
		for(int i=0;i<=arrayList.size();i++)
		{
			bottomUpDp[i][0]=0;
		}
		for(int i=0;i<=capacityOfSack;i++)
		{
			bottomUpDp[0][i]=0;
//			if(i>0)
//				System.out.print(i+"\t");
		}
		System.out.println();
		
		for(int row=1;row<=arrayList.size();row++)
		{
			for(int col=1;col<=capacityOfSack;col++)
			{
				int profitIfTaken=0;
				int profitIfNotTaken=0;
				int currentItemWeight=arrayList.get(row-1).weight;
				int currenItemValue=arrayList.get(row-1).value;
				if(currentItemWeight <=col)//column is our present capacity
				{
					profitIfTaken= currenItemValue + bottomUpDp[row-1][col-currentItemWeight];
				}
				profitIfNotTaken = bottomUpDp[row-1][col];
				//
				bottomUpDp[row][col] = Math.max(profitIfNotTaken,profitIfTaken); 
//				System.out.print(bottomUpDp[row][col]+"\t");
			}
//			System.out.println();
		}
		
		return bottomUpDp[arrayList.size()][capacityOfSack];
		
	}
	public static void main(String[] args)
	{
		ArrayList<Knapsack> arrayList = new ArrayList<Knapsack>();
		int capacityOfSack = 7;
		arrayList.add(new Knapsack(1, 3, 31));
		arrayList.add(new Knapsack(3, 1, 26));
		arrayList.add(new Knapsack(2, 5, 72));
		arrayList.add(new Knapsack(4, 2, 17));
		topDownDp = new int[arrayList.size()+1][capacityOfSack+1];
		bottomUpDp = new int[arrayList.size()+1][capacityOfSack+1];
		
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime() / 1000;
		System.out.println(
				"Maximum Profit Robber can make " + letsDoSomeRobbingUsingTopDownDP(arrayList, 0, capacityOfSack, 0));
		long endTime = System.nanoTime() / 1000;
		System.out.println("TopDown : " + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dp_TDCallCount);
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.println("Maximum Profit Robber can make " + letsDoSomeRobbingUsingBottomUpDP(arrayList, 0, capacityOfSack, 0));
		endTime = System.nanoTime() / 1000;
		System.out.println("BootumUp : " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of recursive call made " + dp_BUCallCount);
		System.out.println("\n===============DNC====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.println("Maximum Profit Robber can make " + letsDoSomeRobbing(arrayList, 0, capacityOfSack, 0));
		endTime = System.nanoTime() / 1000;
		System.out.println("For DNC :" + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dnc_CallCount);
	}
}

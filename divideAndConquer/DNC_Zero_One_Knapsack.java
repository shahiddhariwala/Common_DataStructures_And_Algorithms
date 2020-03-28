package divideAndConquer;

import java.util.ArrayList;

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

public class DNC_Zero_One_Knapsack
{
	public static int letsDoSomeRobbing(ArrayList<Knapsack> arrayList, int index, int capacityOfSack, int profit)
	{
		if (capacityOfSack <= 0 || index>=arrayList.size())
		{
			return 0;
		} else
		{
			int currentWeight = arrayList.get(index).weight;
			int currentValue = arrayList.get(index).value;
			int takingCurrent=0;
			if(capacityOfSack-currentWeight>=0)
			{
				takingCurrent = currentValue
						+ letsDoSomeRobbing(arrayList, index + 1, capacityOfSack - currentWeight, profit+currentValue);
			}
			
			int notTakingCurrent = letsDoSomeRobbing(arrayList, index + 1, capacityOfSack, profit);
			
			return Math.max(takingCurrent, notTakingCurrent);
		}
	}

	public static void main(String[] args)
	{
		ArrayList<Knapsack> arrayList = new ArrayList<Knapsack>();
		arrayList.add(new Knapsack(1, 3, 31));
		arrayList.add(new Knapsack(3, 1, 26));
		arrayList.add(new Knapsack(2, 5, 72));
		arrayList.add(new Knapsack(4, 2, 17));
		int capacityOfSack = 7;
		System.out.println("Maximum Profit Robber can make " + letsDoSomeRobbing(arrayList, 0, capacityOfSack, 0));
	}
}

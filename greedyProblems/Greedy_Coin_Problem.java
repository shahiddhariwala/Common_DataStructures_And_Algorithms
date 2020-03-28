package greedyProblems;

import java.util.Arrays;

public class Greedy_Coin_Problem
{
	public static int findChange(int arr[],int amount)
	{
		int coinsRequired=0;
		//System.out.println("I am here");
		int i=arr.length-1;//last largest coin
		while(amount !=0)
		{
			if((amount/arr[i])>0)
			{
				coinsRequired+=(amount/arr[i]);
				amount=amount%arr[i];
				System.out.println("We need "+arr[i]+" Coin");
			}
			else
			{
				i--;
			}
			//System.out.println(i);
		}
		return coinsRequired;
	}
	public static void main(String[] args)
	{
		int coinArr[]= {1,2,5,10};
		int amount=22;
		Arrays.parallelSort(coinArr);
		//System.out.println("I anm here in main");
		System.out.println(findChange(coinArr,amount));
		
	}
}

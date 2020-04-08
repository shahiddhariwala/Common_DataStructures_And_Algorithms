/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package dynamicProgramming;

public class DP_Number_Factor
{
	static int topDownDp[] = new int[10000];
	static int bottomUpDp[] = new int[10000];

	public static int getNumberFactorDNC(int num)
	{
		if (num == 1 || num == 0 || num == 2)
			return 1;
		else if (num == 3)
			return 2;// {1,1,1,}{3};
		else
		{
			int num1 = getNumberFactorDNC(num - 1);
			int num3 = getNumberFactorDNC(num - 3);
			int num4 = getNumberFactorDNC(num - 4);
			return num1 + num3 + num4;
		}
	}

	public static int getNumberFactorUsingTopDownDP(int num)
	{
		if (num == 1 || num == 0 || num == 2)
			return 1;
		if (num == 3)
			return 2;// {1,1,1,}{3};
		if (topDownDp[num] == 0)
		{
			int num1 = getNumberFactorDNC(num - 1);
			int num3 = getNumberFactorDNC(num - 3);
			int num4 = getNumberFactorDNC(num - 4);
			topDownDp[num] = num1 + num3 + num4;
		}
		return topDownDp[num];
	}

	public static int getNumberFactorUsingBottomUpDP(int num)
	{
		bottomUpDp[0]=bottomUpDp[1]=bottomUpDp[2]=1;
		bottomUpDp[3]=2;
		if (num == 1 || num == 0 || num == 2)
			return 1;
		if (num == 3)
			return 2;// {1,1,1,}{3};
		if (bottomUpDp[num] == 0)
		{
			for(int i=4;i<=num;i++)
				bottomUpDp[i]=bottomUpDp[i-1]+bottomUpDp[i-3]+bottomUpDp[i-4];
		}
		return topDownDp[num];
	}

	public static void main(String[] args) throws InterruptedException
	{
		// Given N. count the number of ways to express N as sum of 1,3, and 4;
		System.out.println("=====Welcome To Number Factor Problem====\n");
		int factorArray[] =
		{ 1, 3, 4 };
		
		Thread.sleep(100);
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime() / 1000;
		for (int i = 1; i <= 10; i++)
			System.out.println("Number of ways to represent " + i + " is " + getNumberFactorUsingTopDownDP(i));
		long endTime = System.nanoTime() / 1000;
		System.out.println("TopDown : " + (endTime - startTime) + "  micro  seconds");
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime() / 1000;
		for (int i = 1; i <= 10; i++)
			System.out.println("Number of ways to represent " + i + " is " + getNumberFactorUsingBottomUpDP(i));
		endTime = System.nanoTime() / 1000;
		System.out.println("BootumUp : " + (endTime - startTime) + " micro seconds");
		System.out.println("\n=================DNC======================\n");
		startTime = System.nanoTime() / 1000;
		for (int i = 1; i <= 10; i++)
			System.out.println("Number of ways to represent " + i + " is " + getNumberFactorDNC(i));
		endTime = System.nanoTime() / 1000;
		System.out.println("For DNC :" + (endTime - startTime) + "  micro  seconds");
	}
}

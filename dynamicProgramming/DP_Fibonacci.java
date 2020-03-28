package dynamicProgramming;

public class DP_Fibonacci
{
	static int topDownDp[] = new int[10000];
	static int BottomUpDp[] = new int[10000];
	public static int getFibonacciUsingTopDownDP(int n)
	{
		if (n == 1 || n == 0)
			return topDownDp[n];
		else if (topDownDp[n] != 0)
			return topDownDp[n];
		else
			topDownDp[n] = getFibonacciUsingTopDownDP(n - 1) + getFibonacciUsingTopDownDP(n - 2);
		return topDownDp[n];
	}
	public static int getFibonacciUsingBottomUp(int n)
	{
		if (n == 1 || n == 0)
			return BottomUpDp[n];
		else if (BottomUpDp[n] != 0)
			return BottomUpDp[n];
		else
		{
			for(int i=2;i<=n;i++)
			{
				BottomUpDp[i]=BottomUpDp[i-1]+BottomUpDp[i-2];
			}
			return BottomUpDp[n];
		}
	}
	public static void main(String[] args)
	{
		DP_Fibonacci fib = new DP_Fibonacci();
		System.out.println("\n===============Top Down====================\n");
		topDownDp[0] = 0;
		topDownDp[1] = 1;
		
		long startTime = System.nanoTime()/1000;
		for (int i = 14; i >=0; i--)
		{
			int num = i;
			System.out.println("Fibonacci Number at Position " + (num + 1) + " is " + getFibonacciUsingTopDownDP(num));
		}
		long endTime = System.nanoTime()/1000;
		System.out.println("TopDown : "+(endTime-startTime)+"  micro  seconds");
		
		System.out.println("\n===============Bottom Up====================\n");
		 BottomUpDp[0]=0;
		 BottomUpDp[1]=1;
		startTime = System.nanoTime()/1000;
		
		for (int i = 14; i >=0; i--)
		{
			int num = i;
			System.out.println("Fibonacci Number at Position " + (num + 1) + " is " + getFibonacciUsingBottomUp(num));
		}
		 endTime = System.nanoTime()/1000;
		
		
		
		System.out.println("BootumUp : "+(endTime-startTime)+" micro seconds");
		
		System.out.println("\n===============DNC====================\n");
		System.out.println("For DNC : 5611  micro  seconds");
	}
}

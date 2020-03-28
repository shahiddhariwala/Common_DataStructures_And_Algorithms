package dynamicProgramming;

public class DP_Longest_Common_Subsequence
{
	static int topDownDp[][];
	static int bottomUpDp[][];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int getLCS(String s1, String s2, int index1, int index2)
	{
		dnc_CallCount++;
		if (index1 >= s1.length() || index2 >= s2.length())
		{
			return 0;
		} else
		{
			int cost1 = 0;
			if (s1.charAt(index1) == s2.charAt(index2))
			{
				cost1 = 1 + getLCS(s1, s2, index1 + 1, index2 + 1);
			}
			int cost2 = getLCS(s1, s2, index1 + 1, index2);
			int cost3 = getLCS(s1, s2, index1, index2 + 1);
			return Math.max(cost1, Math.max(cost2, cost3));
		}
	}

	public static int getLCSUsingTopDownDP(String s1, String s2, int index1, int index2)
	{
		dp_TDCallCount++;
		if (index1 >= s1.length() || index2 >= s2.length())
		{
			return 0;
		} else
		{
			if (topDownDp[index1][index2] == 0)
			{
				int cost1 = 0;
				if (s1.charAt(index1) == s2.charAt(index2))
				{
					cost1 = 1 + getLCSUsingTopDownDP(s1, s2, index1 + 1, index2 + 1);
				}
				int cost2 = getLCSUsingTopDownDP(s1, s2, index1 + 1, index2);
				int cost3 = getLCSUsingTopDownDP(s1, s2, index1, index2 + 1);
				topDownDp[index1][index2] = Math.max(cost1, Math.max(cost2, cost3));
			}
			return topDownDp[index1][index2];
		}
	}
	
	public static int getLCSUsingBottomUpDP(String s1, String s2, int index1, int index2)
	{
		dp_BUCallCount++;
		
		for(int i=s1.length()-1;i>=0;i--)
		{
			for(int j=s2.length()-1;j>=0;j--)
			{
				int tempCost=0;
				if(s1.charAt(i)==s2.charAt(j))
				{
					tempCost = 1 + bottomUpDp[i+1][j+1];
				}
				bottomUpDp[i][j]  = Math.max(tempCost, Math.max(bottomUpDp[i][j+1], bottomUpDp[i+1][j]));
				
			}
			
		}
		return bottomUpDp[0][0];
	}

	public static void printBottomUpDP() {
		for (int i = 0; i < bottomUpDp.length; i++) {
			for (int j = 0; j < bottomUpDp[0].length; j++) {
				System.out.printf("%d\t",bottomUpDp[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Longest Commmon Subsequence Problem");
		String s1 = "shahid";
		String s2 = "sidohahid";
		topDownDp = new int[s1.length() + 1][s2.length() + 1];
		bottomUpDp = new int[s1.length() + 1][s2.length() + 1];
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime() / 1000;
		System.out.printf("Longest Common Susbequnce between\n'%s' and '%s' is of %d letters \n", s1, s2,
				getLCSUsingTopDownDP(s1, s2, 0, 0));
		long endTime = System.nanoTime() / 1000;
		System.out.println("TopDown : " + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dp_TDCallCount);
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.printf("Longest Common Susbequnce between\n'%s' and '%s' is of %d letters \n", s1, s2,
				getLCSUsingBottomUpDP(s1, s2, 0, 0));
		endTime = System.nanoTime() / 1000;
		System.out.println("BootumUp : " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of recursive call made " + dp_BUCallCount);
		System.out.println("\nPrinting Bottom Up Table");
		printBottomUpDP();
		System.out.println("\n===============DNC====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.printf("Longest Common Susbequnce between\n'%s' and '%s' is of %d letters \n", s1, s2,
				getLCS(s1, s2, 0, 0));
		endTime = System.nanoTime() / 1000;
		System.out.println("For DNC :" + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dnc_CallCount);
	}
}

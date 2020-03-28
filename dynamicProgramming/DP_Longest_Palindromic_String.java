package dynamicProgramming;

public class DP_Longest_Palindromic_String
{
	static int topDownDp[][];
	static int bottomUpDp[][];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int getLPSDNC(String str, int startindex, int endIndex)
	{
		dnc_CallCount++;
		// base case
		if (startindex > endIndex)
			return 0;
		else if (startindex == endIndex)
		{
			// single character is palindrome itself
			return 1;
		}
		// 3 option
		// if same +2 s+1 and e-1
		// if not same s+1,e or s,e-1
		int len3 = 0;
		if (str.charAt(startindex) == str.charAt(endIndex))
		{
			int inBetweenLength = getLPSDNC(str, startindex + 1, endIndex - 1);
			if (inBetweenLength == endIndex - startindex - 1)
			{
				len3 = 2 + inBetweenLength;
			}
		}
		int len1 = getLPSDNC(str, startindex + 1, endIndex);
		int len2 = getLPSDNC(str, startindex, endIndex - 1);
		return Math.max(len3, Math.max(len1, len2));
	}

	public static int getLPS_Using_TopDown_DP(String str, int startindex, int endIndex)
	{
		dp_TDCallCount++;
		// base case
		if (startindex > endIndex)
			return 0;
		else if (startindex == endIndex)
		{
			// single character is palindrome itself
			topDownDp[startindex][endIndex] = 1;
		}
		// 3 option
		// if same +2 s+1 and e-1
		// if not same s+1,e or s,e-1
		if (topDownDp[startindex][endIndex] == 0)
		{
			int len3 = 0;
			if (str.charAt(startindex) == str.charAt(endIndex))
			{
				int inBetweenLength = getLPS_Using_TopDown_DP(str, startindex + 1, endIndex - 1);
				if (inBetweenLength == endIndex - startindex - 1)
				{
					len3 = 2 + inBetweenLength;
				}
			}
			int len1 = getLPS_Using_TopDown_DP(str, startindex + 1, endIndex);
			int len2 = getLPS_Using_TopDown_DP(str, startindex, endIndex - 1);
			topDownDp[startindex][endIndex] = Math.max(len3, Math.max(len1, len2));
		}
		return topDownDp[startindex][endIndex];
	}

	public static int getLPS_Using_BottomUp_DP(String str, int startindex, int endIndex)
	{
		dp_BUCallCount++;
		for (int col = 0; col < str.length(); col++)
		{
			for (int row = str.length() - 1; row >= 0; row--)
			{
				if (row > col)
					bottomUpDp[row][col] = 0;
				else if (row == col)
					bottomUpDp[row][col] = 1;
				else
				{
					int len3 = 0;
					if (str.charAt(row) == str.charAt(col))
					{
						int inBetweenLength = bottomUpDp[row + 1][col - 1];
						if (inBetweenLength == col - row - 1)
						{
							len3 = 2 + inBetweenLength;
						}
					}
					int len1 = bottomUpDp[row + 1][col];
					int len2 = bottomUpDp[row][col - 1];
					bottomUpDp[row][col] = Math.max(len3, Math.max(len1, len2));
				}
			}
		}
		return bottomUpDp[startindex][endIndex];
	}

	public static void printBottomUpDP()
	{
		for (int i = 0; i < bottomUpDp.length; i++)
		{
			for (int j = 0; j < bottomUpDp[0].length; j++)
			{
				System.out.printf("%d\t", bottomUpDp[i][j]);
			}
			System.out.println();
		}
	}

	public static void printTopDOwnDP()
	{
		for (int i = 0; i < topDownDp.length; i++)
		{
			for (int j = 0; j < topDownDp[0].length; j++)
			{
				System.out.printf("%d\t", topDownDp[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		System.out.println("====Welcome to Longest Palindromic String Problem====");
		String str = "ABCCBUA";
		System.out.println("String is " + str);
		topDownDp = new int[str.length()][str.length()];
		bottomUpDp = new int[str.length()][str.length()];
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime() / 1000;
		System.out.println(
				"Length of Longest Palindromic String is => " + getLPS_Using_TopDown_DP(str, 0, str.length() - 1));
		long endTime = System.nanoTime() / 1000;
		System.out.println("TopDown : " + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dp_TDCallCount);
		System.out.println("\nPrinting Top Down Table");
		printTopDOwnDP();
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.println(
				"Length of Longest Palindromic String is => " + getLPS_Using_BottomUp_DP(str, 0, str.length() - 1));
		endTime = System.nanoTime() / 1000;
		System.out.println("BootumUp : " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of recursive call made " + dp_BUCallCount);
		System.out.println("\nPrinting Bottom Up Table");
		printBottomUpDP();
		System.out.println("\n===============DNC====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.println("Length of Longest Palindromic String is => " + getLPSDNC(str, 0, str.length() - 1));
		endTime = System.nanoTime() / 1000;
		System.out.println("For DNC :" + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dnc_CallCount);
	}
}

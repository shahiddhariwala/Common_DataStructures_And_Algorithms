/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package dynamicProgramming;

public class DP_Longest_Palindromic_Subsequence
{
	static int topDownDp[][];
	static int bottomUpDp[][];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int getLPS_DNC(String str, int startindex, int endIndex)
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
			len3 = 2 + getLPS_DNC(str, startindex + 1, endIndex - 1);
		}
		int len1 = getLPS_DNC(str, startindex + 1, endIndex);
		int len2 = getLPS_DNC(str, startindex, endIndex - 1);
		return Math.max(len3, Math.max(len1, len2));
	}

	public static int getLPS_Top_Down_DP(String str, int startindex, int endIndex)
	{
		dp_TDCallCount++;
		// base case
		if (startindex > endIndex)
			return 0;
		else if (startindex == endIndex)
		{
			// single character is palindrome itself
			topDownDp[startindex][endIndex]= 1;
		}
		if (topDownDp[startindex][endIndex] == 0)
		{
			// 3 option
			// if same +2 s+1 and e-1
			// if not same s+1,e or s,e-1
			int len3 = 0;
			if (str.charAt(startindex) == str.charAt(endIndex))
			{
				len3 = 2 + getLPS_Top_Down_DP(str, startindex + 1, endIndex - 1);
			}
			int len1 = getLPS_Top_Down_DP(str, startindex + 1, endIndex);
			int len2 = getLPS_Top_Down_DP(str, startindex, endIndex - 1);
			System.out.printf("(%d,%d) => (i+1) %d (j-1) %d (i+1,j-1) %d\n",startindex,endIndex,len1,len2,len3);
			topDownDp[startindex][endIndex] = Math.max(len3, Math.max(len1, len2));
		}
		return topDownDp[startindex][endIndex];
	}

	public static int getLPS_Bottom_Up_DP(String str, int startindex, int endIndex)
	{
		dp_BUCallCount++;
		for (int j = 0; j < str.length(); j++)
		{
			for (int i = str.length() - 1; i >= 0; i--)
			{
				if (i > j)
					bottomUpDp[i][j] = 0;
				else if (i == j)
					bottomUpDp[i][j] = 1;
				else
				{
					int len1 = 0;
					int len2 = 0;
					if (str.charAt(i) == str.charAt(j))
					{
						len1 = 2 + bottomUpDp[i + 1][j - 1];
					} else
					{
						len2 = Math.max(bottomUpDp[i + 1][j], bottomUpDp[i][j - 1]);
					}
					bottomUpDp[i][j] = Math.max(len1, len2);
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
		System.out.println("====Welcome to Longest palindromic Subsequence Problem====");
		String str = "sahaid";
		System.out.println("String is " + str);
		topDownDp = new int[str.length() + 1][str.length() + 1];
		bottomUpDp = new int[str.length() + 1][str.length() + 1];
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime() / 1000;
		System.out.println(
				"Length of Longest Palindromic Subsequence is => " + getLPS_Top_Down_DP(str, 0, str.length() - 1));
		long endTime = System.nanoTime() / 1000;
		System.out.println("TopDown : " + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dp_TDCallCount);
		System.out.println("\nPrinting Top Down Table");
		printTopDOwnDP();
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.println(
				"Length of Longest Palindromic Subsequence is => " + getLPS_Bottom_Up_DP(str, 0, str.length() - 1));
		endTime = System.nanoTime() / 1000;
		System.out.println("BootumUp : " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of recursive call made " + dp_BUCallCount);
		System.out.println("\nPrinting Bottom Up Table");
		printBottomUpDP();
		System.out.println("\n===============DNC====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.println("Length of Longest Palindromic Subsequence is => " + getLPS_DNC(str, 0, str.length() - 1));
		endTime = System.nanoTime() / 1000;
		System.out.println("For DNC :" + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dnc_CallCount);
	}
}

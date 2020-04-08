/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package dynamicProgramming;

public class DP_Convert_One_String_To_Another
{
	static int topDownDp[][];
	static int bottomUpDp[][];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int getMinimumCostDNC(String s1, String s2, int indexS1, int indexS2)
	{
		dnc_CallCount++;
		if (indexS1 == s1.length())
		{
			return s2.length() - indexS2;
		} else if (indexS2 == s2.length())
		{
			return s1.length() - indexS1;
		} else
		{
			if (s1.charAt(indexS1) == s2.charAt(indexS2))
			{
				return getMinimumCostDNC(s1, s2, indexS1 + 1, indexS2 + 1);
			}
			int c0 = 1 + getMinimumCostDNC(s1, s2, indexS1 + 1, indexS2 + 1);
			int c1 = 1 + getMinimumCostDNC(s1, s2, indexS1 + 1, indexS2);
			int c2 = 1 + getMinimumCostDNC(s1, s2, indexS1, indexS2 + 1);
			return Math.min(c0, Math.min(c1, c2));
		}
	}

	public static int getMinimumCostUsingTopDownDP(String s1, String s2, int indexS1, int indexS2)
	{
		dp_TDCallCount++;
		if (topDownDp[indexS1][indexS2] == 0)
		{
			if (indexS1 == s1.length())
			{
				topDownDp[indexS1][indexS2] = s2.length() - indexS2;
			} else if (indexS2 == s2.length())
			{
				topDownDp[indexS1][indexS2] = s1.length() - indexS1;
			} else
			{
				if (s1.charAt(indexS1) == s2.charAt(indexS2))
				{
					topDownDp[indexS1][indexS2] = getMinimumCostUsingTopDownDP(s1, s2, indexS1 + 1, indexS2 + 1);
				} else
				{
					int c0 = 1 + getMinimumCostUsingTopDownDP(s1, s2, indexS1 + 1, indexS2 + 1);// replace
					int c1 = 1 + getMinimumCostUsingTopDownDP(s1, s2, indexS1 + 1, indexS2);// delete
					int c2 = 1 + getMinimumCostUsingTopDownDP(s1, s2, indexS1, indexS2 + 1);// insert
					topDownDp[indexS1][indexS2] = Math.min(c0, Math.min(c1, c2));
				}
			}
		}
		return topDownDp[indexS1][indexS2];
	}

	public static int getMinimumCostUsingBottomUpDP(String s1, String s2, int indexS1, int indexS2)
	{
		dp_BUCallCount++;
		for (int i = 0; i <= s1.length(); i++)
		{
			bottomUpDp[i][0] = i;
		}
		for (int i = 0; i <= s2.length(); i++)
		{
			bottomUpDp[0][i] = i;
		}
		for (int i = 1; i <= s1.length(); i++)
		{
			for (int j = 1; j <= s2.length(); j++)
			{
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
				{
					bottomUpDp[i][j] = bottomUpDp[i - 1][j - 1];
				} else
				{
					bottomUpDp[i][j] = 1
							+ Math.min(bottomUpDp[i - 1][j - 1], Math.min(bottomUpDp[i][j - 1], bottomUpDp[i - 1][j]));
				}
			}
		}
		return bottomUpDp[s1.length()][s2.length()];
	}

	public static void main(String[] args)
	{
		// find minimum cost to Convert String s2 to s1
		String s1 = "DISTANCE";// EDITING
		String s2 = "EDITING";// DISTANCE
		topDownDp = new int[s1.length() + 1][s2.length() + 1];
		bottomUpDp = new int[s1.length() + 1][s2.length() + 1];
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime() / 1000;
		System.out.printf(
				"Minimum cost to convert \"%s\" to \"%s\"  is " + getMinimumCostUsingTopDownDP(s1, s2, 0, 0), s2, s1);
		long endTime = System.nanoTime() / 1000;
		System.out.println("\nTopDown : " + (endTime - startTime) + "  nano  seconds");
		System.out.println("\nNumber of recursive call made " + dp_TDCallCount);
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.printf(
				"\nMinimum cost to convert \"%s\" to \"%s\"  is " + getMinimumCostUsingBottomUpDP(s1, s2, 0, 0), s2,
				s1);
		endTime = System.nanoTime() / 1000;
		System.out.println("\nBootumUp : " + (endTime - startTime) + " nano seconds");
		System.out.println("\nNumber of recursive call made " + dp_BUCallCount);
		System.out.println("\n===============DNC====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.printf("\nMinimum cost to convert \"%s\" to \"%s\"  is" + getMinimumCostDNC(s1, s2, 0, 0), s2,
				s1);
		endTime = System.nanoTime() / 1000;
		System.out.println("\nFor DNC :" + (endTime - startTime) + "  nano  seconds");
		System.out.println("\nNumber of recursive call made " + dnc_CallCount);
	}
}

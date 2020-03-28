package divideAndConquer;

public class DNC_Convert_One_String_To_Another
{
	static int topDownDp[] = new int[10000];
	static int bottomUpDp[] = new int[10000];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int getMinimumCost(String s1, String s2, int indexS1, int indexS2)
	{
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
				return getMinimumCost(s1, s2, indexS1 + 1, indexS2 + 1);
			}
			int c0 = 1 + getMinimumCost(s1, s2, indexS1 + 1, indexS2 + 1);
			int c1 = 1 + getMinimumCost(s1, s2, indexS1 + 1, indexS2);
			int c2 = 1 + getMinimumCost(s1, s2, indexS1, indexS2 + 1);
			return Math.min(c0, Math.min(c1, c2));
		}
	}

	public static void main(String[] args)
	{
		// find minimum cost to Convert String s2 to s1
		String s1 = "shahid";
		String s2 = "sidehahid";
		System.out.printf("Minimum cost to convert \"%s\" to \"%s\"  is\" " + getMinimumCost(s1, s2, 0, 0), s2, s1);
	}
}

package dynamicProgramming;

public class DP_Number_Paths_To_Reach_End_Of_Matrix_In_Given_Cost
{
	static int topDownDp[][];
	static int bottomUpDp[][];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int numberOfPath_DNC(int[][] array, int row, int col, int cost)
	{
		dnc_CallCount++;
		if (cost < 0)
			return 0;
		if (row == 0 && col == 0 && cost == array[0][0])
			return 1;
		else if (row == 0 && col == 0 && cost != array[0][0])
			return 0;
		if (row == 0)
			return numberOfPath_DNC(array, 0, col - 1, cost - array[row][col]);
		else if (col == 0)
			return numberOfPath_DNC(array, row - 1, 0, cost - array[row][col]);
		int pathFromUp = numberOfPath_DNC(array, row - 1, col, cost - array[row][col]);
		int pathFromLeft = numberOfPath_DNC(array, row, col - 1, cost - array[row][col]);
		return pathFromUp + pathFromLeft;
	}

	public static int numberOfPath_TD_DP(int[][] array, int row, int col, int cost)
	{
		int dp[][] = new int[row + 1][col + 1];
		return numberOfPath_Top_Down_DP(dp, array, row, col, cost);
	}

	public static int numberOfPath_Top_Down_DP(int[][] dp, int[][] array, int row, int col, int cost)
	{
		if (cost < 0)
		{// BASE CASE
			return 0;
		}
		if (row == 0 && col == 0)
		{ // BASE CASE
			return (array[0][0] - cost == 0) ? 1 : 0;
		}
		if (dp[row][col] == 0)
		{// If we have not solved this problem previously, only then solve it
			if (row == 0)
			{ // BASE CASE: If we're at first row, we can only go left
				dp[row][col] = numberOfPath_TD_DP(array, 0, col - 1, cost - array[row][col]);
			} else if (col == 0)
			{ // BASE CASE: if we're at first column, we can only go up
				dp[row][col] = numberOfPath_TD_DP(array, row - 1, 0, cost - array[row][col]);
			} else
			{
				int noOfPathsFromPreviousRow = numberOfPath_TD_DP(array, row - 1, col, cost - array[row][col]);
				int noOfPathsFromPreviousCol = numberOfPath_TD_DP(array, row, col - 1, cost - array[row][col]);
				dp[row][col] = noOfPathsFromPreviousRow + noOfPathsFromPreviousCol;
			}
			System.out.printf("(%d,%d) = %d\n", row, col, dp[row][col]);
		} // end of if-else block
		return dp[row][col];
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
		System.out.println("Number of Paths to Reach End Of Matrix in a given Cost Problem");
		int[][] array =
		{
				{ 4, 7, 1, 6 },
				{ 5, 7, 3, 9 },
				{ 3, 2, 1, 2 },
				{ 7, 1, 6, 3 } };
		int cost = 25;
		topDownDp = new int[array.length + 1][array.length + 1];
		bottomUpDp = new int[array.length][array.length];
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime() / 1000;
		System.out.print("Number of Paths to Reach End Of Matrix in a given " + cost + " cost is ");
		System.out.println(numberOfPath_TD_DP(array, array.length - 1, array[0].length - 1, cost));
		long endTime = System.nanoTime() / 1000;
		System.out.println("TopDown : " + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dp_TDCallCount);
		System.out.println("\nPrinting Top Down Table");
		printTopDOwnDP();
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.print("Number of Paths to Reach End Of Matrix in a given " + cost + " cost is ");
		System.out.println(numberOfPath_DNC(array, array.length - 1, array[0].length - 1, cost));
		endTime = System.nanoTime() / 1000;
		System.out.println("BootumUp : " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of recursive call made " + dp_BUCallCount);
		System.out.println("\nPrinting Bottom Up Table");
		printBottomUpDP();
		System.out.println("\n===============DNC====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.print("Number of Paths to Reach End Of Matrix in a given " + cost + " cost is ");
		System.out.println(numberOfPath_DNC(array, array.length - 1, array[0].length - 1, cost));
		endTime = System.nanoTime() / 1000;
		System.out.println("For DNC :" + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dnc_CallCount);
	}
}

/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package dynamicProgramming;

public class DP_Minimum_Cost_To_Reach_End_Of_Matrix
{
	static int topDownDp[][];
	static int bottomUpDp[][];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int getMCREM_DNC(int[][] array, int row, int col)
	{
		dnc_CallCount++;
		if (row == 0 && col == 0)
			return array[0][0];
		if (row == 0)
			return array[0][col] + getMCREM_DNC(array, 0, col - 1);
		else if (col == 0)
			return array[row][0] + getMCREM_DNC(array, row - 1, 0);
		int costFromUp = array[row][col] + getMCREM_DNC(array, row - 1, col);
		int costFromLeft = array[row][col] + getMCREM_DNC(array, row, col - 1);
		return Math.min(costFromUp, costFromLeft);
	}

	public static int getMCREM_Top_Down_DP(int[][] array, int row, int col)
	{
		dp_TDCallCount++;
		if (row < 0 || col < 0)
			return 0;
		if (topDownDp[row][col] == 0)
		{
			if (row == 0 && col == 0)
				topDownDp[row][col] = array[0][0];
			if (row == 0)
				topDownDp[row][col] = array[0][col] + getMCREM_Top_Down_DP(array, 0, col - 1);
			else if (col == 0)
				topDownDp[row][col] = array[row][0] + getMCREM_Top_Down_DP(array, row - 1, 0);
			else
			{
				int costFromUp = array[row][col] + getMCREM_Top_Down_DP(array, row - 1, col);
				int costFromLeft = array[row][col] + getMCREM_Top_Down_DP(array, row, col - 1);
				topDownDp[row][col] = Math.min(costFromUp, costFromLeft);
			}
		}
		return topDownDp[row][col];
	}

	public static int getMCREM_Bottom_Up_DP(int[][] array, int row, int col)
	{
		dp_BUCallCount++;
		
		for(int i=0;i<=row;i++)
		{
			for(int j=0;j<=col;j++)
			{
				if(i==0 && j==0)
				{
					//0,0
					bottomUpDp[i][j]=array[i][j];
				}
				else if(i==0)
				{
					//all 0th row as there is only one way to go i.e left
					bottomUpDp[i][j]=bottomUpDp[i][j-1]+array[i][j];
				}
				else if(j==0)
				{
					//all 0th col as there is only one way to go i.e down
					bottomUpDp[i][j]=bottomUpDp[i-1][j]+array[i][j];
				}
				else
				{
					bottomUpDp[i][j]=Math.min(bottomUpDp[i][j-1], bottomUpDp[i-1][j])+array[i][j];
				}
			}
		}
		return bottomUpDp[row][col];
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
		System.out.println("Minimum Cost to Reach End Of Matrix Problem");
		int[][] array =
		{
				{ 4, 7, 8, 6, 4 },
				{ 6, 7, 3, 9, 2 },
				{ 3, 8, 1, 2, 4 },
				{ 7, 1, 7, 3, 7 },
				{ 2, 9, 8, 9, 3 } };
//		int[][] array =
//			{
//					{ 40, 70, 80, 60, 40 },
//					{ 60, 70, 30, 90, 20 },
//					{ 30, 80, 10, 20, 40 },
//					{ 70, 10, 70, 30, 70 },
//					{ 20, 90, 80, 90, 30 } };
		topDownDp = new int[array.length][array.length];
		bottomUpDp = new int[array.length][array.length];
		System.out.print("Min Cost to reach at the end of matrix is ");
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime() / 1000;
		System.out.println(
				"We can reach end of Matrix in " + getMCREM_Top_Down_DP(array, array.length - 1, array[0].length - 1));
		long endTime = System.nanoTime() / 1000;
		System.out.println("TopDown : " + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dp_TDCallCount);
		System.out.println("\nPrinting Top Down Table");
		printTopDOwnDP();
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime() / 1000;
		System.out.println(
				"We can reach end of Matrix in " + getMCREM_Bottom_Up_DP(array, array.length - 1, array[0].length - 1));
		endTime = System.nanoTime() / 1000;
		System.out.println("BootumUp : " + (endTime - startTime) + " nano seconds");
		System.out.println("Number of recursive call made " + dp_BUCallCount);
		System.out.println("\nPrinting Bottom Up Table");
		printBottomUpDP();
		System.out.println("\n===============DNC====================\n");
		startTime = System.nanoTime() / 1000;
		System.out
				.println("We can reach end of Matrix in " + getMCREM_DNC(array, array.length - 1, array[0].length - 1));
		endTime = System.nanoTime() / 1000;
		System.out.println("For DNC :" + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dnc_CallCount);
	}
}

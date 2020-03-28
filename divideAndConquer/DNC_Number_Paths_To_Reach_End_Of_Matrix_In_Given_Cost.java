package divideAndConquer;

public class DNC_Number_Paths_To_Reach_End_Of_Matrix_In_Given_Cost
{
	public static int numberOfPath(int[][] array, int row, int col, int cost)
	{
		if(cost<0)
			return 0;
		if (row == 0 && col == 0 && cost==array[0][0])
			return 1;
		else if(row == 0 && col == 0 && cost!=array[0][0])
			return 0;
		
		if (row == 0)
			return numberOfPath(array, 0, col - 1, cost-array[row][col]);
		else if (col == 0)
			return numberOfPath(array, row - 1, 0, cost-array[row][col]);
		int pathFromUp = numberOfPath(array, row - 1, col, cost-array[row][col]);
		int pathFromLeft = numberOfPath(array, row, col - 1, cost-array[row][col]);
		return pathFromUp+pathFromLeft;
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
	
		System.out.print("Number of Paths to Reach End Of Matrix in a given " + cost + " cost is ");
		System.out.println(numberOfPath(array, array.length - 1, array[0].length - 1, cost));
	}
}

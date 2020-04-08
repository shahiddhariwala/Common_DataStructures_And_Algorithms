/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package divideAndConquer;

public class DNC_Minimum_Cost_To_Reach_End_Of_Matrix
{
	public  static int getMCREM(int[][] array,int row,int col,int cost)
	{
		if(row==0 && col==0)
			return array[0][0];
		
		if(row==0)
			return array[0][col] + getMCREM(array, 0, col-1, cost);
		else if(col==0)
			return array[row][0] + getMCREM(array, row-1, 0, cost);
		
		int costFromUp =  array[row][col] + getMCREM(array, row-1, col, cost);
		int costFromLeft= array[row][col] + getMCREM(array, row, col-1, cost);
		return Math.min(costFromUp, costFromLeft);
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
		
		
		System.out.print("Min Cost to reach at the end of array is ");
		System.out.println(getMCREM(array,array.length-1,array[0].length-1,0));
	}
}

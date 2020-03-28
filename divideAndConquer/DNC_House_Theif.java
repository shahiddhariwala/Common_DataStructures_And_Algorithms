package divideAndConquer;

public class DNC_House_Theif
{
	public static int doRobbingInHouse(int arr[], int startIndex, int endIndex)
	{
		if (startIndex > endIndex)
			return 0;
		if (startIndex == endIndex)
		{
			return arr[startIndex];
		} else
		{
			int ifTaken = arr[startIndex] + doRobbingInHouse(arr, startIndex + 2, endIndex);
			int ifNottaken = doRobbingInHouse(arr, startIndex + 1, endIndex);
			return Math.max(ifTaken, ifNottaken);
		}
	}

	public static void main(String[] args)
	{
		/*
		 * There are n houses build in a line, each of whicjh contains some value in it.
		 * A theif is going to steal the maximal value of these house But he can't steal
		 * in two adjancent houses What is maximum stolen value?
		 */
		int housesValue[] =
		{ 6, 7, 1, 30, 8, 2, 4 };
		System.out.println("Maximum value he can still is " + doRobbingInHouse(housesValue, 0, housesValue.length - 1));
	}
}

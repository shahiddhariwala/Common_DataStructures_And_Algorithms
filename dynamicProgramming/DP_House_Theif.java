/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package dynamicProgramming;

public class DP_House_Theif
{
	static int topDownDp[] = new int[10000];
	static int bottomUpDp[] = new int[10000];
	static int dnc_CallCount = 0;
	static int dp_TDCallCount = 0;
	static int dp_BUCallCount = 0;

	public static int doRobbingInHouseDNC(int arr[], int startIndex, int endIndex)
	{
		dnc_CallCount++;
		if (startIndex > endIndex)
			return 0;
		if (startIndex == endIndex)
		{
			return arr[startIndex];
		} else
		{
			int ifTaken = arr[startIndex] + doRobbingInHouseDNC(arr, startIndex + 2, endIndex);
			int ifNottaken = doRobbingInHouseDNC(arr, startIndex + 1, endIndex);
			return Math.max(ifTaken, ifNottaken);
		}
	}

	public static int doRobbingInHouseUsingTopDownDP(int arr[], int startIndex, int endIndex)
	{
		dp_TDCallCount++;
		if (startIndex > endIndex)
			return 0;
		if (topDownDp[startIndex] == 0)
		{
			int ifTaken = arr[startIndex] + doRobbingInHouseUsingTopDownDP(arr, startIndex + 2, endIndex);
			int ifNottaken = doRobbingInHouseUsingTopDownDP(arr, startIndex + 1, endIndex);
			topDownDp[startIndex] = Math.max(ifTaken, ifNottaken);
		}
		return topDownDp[startIndex];
	}

	public static int doRobbingInHouseUsingBottomUpDP(int arr[], int startIndex, int endIndex)
	{
		dp_BUCallCount++;
		
		bottomUpDp[endIndex]=arr[endIndex];
		//starting from second last House till first house
		for(int i =endIndex-1;i>=startIndex;i--)
		{
			bottomUpDp[i]=Math.max(arr[i]+bottomUpDp[i+2], bottomUpDp[i+1]);
			
		}
		return bottomUpDp[startIndex];
	}

	public static void main(String[] args) throws InterruptedException
	{
		/*
		 * There are n houses build in a line, each of which contains some value in it.
		 * A theif is going to steal the maximal value of these house But he can't steal
		 * in two adjancent houses What is maximum stolen value?
		 */
		int housesValue[] =
		{ 6, 7, 1, 30, 8, 2, 4};
		Thread.sleep(1000);
		System.out.println("\n===============Top Down====================\n");
		long startTime = System.nanoTime();
		System.out.println("Maximum value he can still is "
				+ doRobbingInHouseUsingTopDownDP(housesValue, 0, housesValue.length - 1));
		long endTime = System.nanoTime();
		System.out.println("TopDown : " + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dp_TDCallCount);
		System.out.println("\n===============Bottom Up====================\n");
		startTime = System.nanoTime();
		System.out.println("Maximum value he can still is "
				+ doRobbingInHouseUsingBottomUpDP(housesValue, 0, housesValue.length - 1));
		endTime = System.nanoTime();
		System.out.println("Number of recursive call made " + dp_BUCallCount);
		System.out.println("BootumUp : " + (endTime - startTime) + " nano seconds");
		System.out.println("\n===============DNC====================\n");
		startTime = System.nanoTime();
		System.out.println(
				"Maximum value he can still is " + doRobbingInHouseDNC(housesValue, 0, housesValue.length - 1));
		endTime = System.nanoTime();
		System.out.println("For DNC :" + (endTime - startTime) + "  nano  seconds");
		System.out.println("Number of recursive call made " + dnc_CallCount);
	}
}

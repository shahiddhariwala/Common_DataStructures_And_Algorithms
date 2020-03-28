package sortingAlgos;

public class BubbleSort
{
	private void doBubbleSort(int[] arr)
	{
		for(int i = 0 ; i < arr.length-1 ; i++)
		{
			for(int j=0 ; j < arr.length-1-i ;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	private void printArray(int[] arr)
	{
		int count=1;
		for (Integer i : arr)
		{
			System.out.print(i + " ");
			count++;
			if (count > 10)
			{
				System.out.println(); 
				count=1;
			}
			
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		System.out.println("===========Welcome to Bubble Sort==========");
		int arr[] = new int[100];
		for (int i = 0; i < 100; i++)
		{
			arr[i] = (int) (Math.random() * 100);
		}
		BubbleSort bs = new BubbleSort();
		System.out.println("Before Sorting");
		bs.printArray(arr);
		
		long start = System.nanoTime();
		bs.doBubbleSort(arr);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end - start));
		System.out.println("\nAfter Sorting");
		bs.printArray(arr);

	}
}

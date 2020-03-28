package sortingAlgos;

public class QuickSort
{
	private void doQuickSort(int[] arr, int start, int end)
	{
		if (start < end)
		{
			int pivot = doPartition(arr, start, end);
			//System.out.println("Pivot ->"+arr[pivot]);
			
			doQuickSort(arr, start, pivot - 1);
			doQuickSort(arr, pivot + 1, end);
			
		}
	}

	private int doPartition(int[] arr, int start, int end)
	{
		int pivot = end;
		int i = start - 1;
		
		for (int j = start; j <= end; j++)
		{
			if (arr[j] <= arr[pivot])
			{
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		return i;
	}

	private void printArray(int[] arr)
	{
		int count = 1;
		for (Integer i : arr)
		{
			System.out.print(i + " ");
			count++;
			if (count > 10)
			{
				System.out.println();
				count = 1;
			}
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int arr[] = new int[100];
		for (int i = 0; i < 100; i++)
		{
			arr[i] = (int) (Math.random() * 100);
		}
		
//		int arr[] = {9,4,6,3,7,1,2,11,5};
		System.out.println("====== Welcome to Quick Sort ========");
		QuickSort obj = new QuickSort();
		System.out.println("Before Sorting");
		obj.printArray(arr);
		System.out.println();
		long start = System.nanoTime();
		obj.doQuickSort(arr, 0, arr.length - 1);
		long end = System.nanoTime();
		System.out.println("\nAfter Sorting");
		obj.printArray(arr);
		System.out.println("\n\nTime to execute this algo: " + (end - start));
	}
}

package sortingAlgos;

public class MergeSort
{
	private void doMergeSort(int[] arr, int start, int end)
	{
		if (start < end)
		{
			int mid = (start + end) / 2;
			doMergeSort(arr, start, mid);
			doMergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private void merge(int[] arr, int start, int mid, int end)
	{
		int leftArr[] = new int[mid - start + 2];
		int rightArr[] = new int[end - mid + 1];
		for (int i = 0; i <= mid - start; i++)
			leftArr[i] = arr[start + i];
		for (int i = 0; i < end - mid; i++)
			rightArr[i] = arr[mid + 1 + i];
		leftArr[mid - start + 1] = Integer.MAX_VALUE;
		rightArr[end - mid] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = start; k <= end; k++)
		{
			if (leftArr[i] < rightArr[j])
			{
				arr[k] = leftArr[i];
				i++;
			} else
			{
				arr[k] = rightArr[j];
				j++;
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
		int arr[] = new int[100];
		for (int i = 0; i < 100; i++)
		{
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println("====== Welcome to Merge Sort ========");
		MergeSort obj = new MergeSort();
		System.out.println("Before Sorting");
		obj.printArray(arr);
		long start = System.nanoTime();
		obj.doMergeSort(arr, 0, arr.length - 1);
		long end = System.nanoTime();

		System.out.println("\nAfter Sorting");
		
		obj.printArray(arr);
		System.out.println("\n\nTime to execute this algo: " + (end - start));
	}
}

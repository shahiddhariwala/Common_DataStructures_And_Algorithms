/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package sortingAlgos;

public class SelectionSort
{
	private void doSelectionSort(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
			int minIndex=i;
			for(int j=i+1 ; j < arr.length ;j++)
			{
				if(arr[j]<arr[minIndex])
				{
					minIndex=j;
				}
			}
			if(i!=minIndex)
			{
				int temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
				
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
		System.out.println("====== Welcome to Selection Sort ========");
		SelectionSort bs = new SelectionSort();
		System.out.println("Before Sorting");
		bs.printArray(arr);
		long start = System.nanoTime();
		bs.doSelectionSort(arr);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end - start));
		System.out.println("\nAfter Sorting");
		bs.printArray(arr);
		System.out.println("\n\nTime to execute this algo: " + (end - start));

	}
}

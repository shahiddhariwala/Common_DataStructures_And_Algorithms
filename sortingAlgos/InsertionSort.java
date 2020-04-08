/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package sortingAlgos;


public class InsertionSort
{
	private void doInsertionSort(int[] arr)
	{
		for(int i = 1 ; i < arr.length ; i++)
		{
			int temp = arr[i];
			int j=i;
			while(j>0 && arr[j-1]>temp)
			{
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=temp;
			
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
		System.out.println("====== Welcome to Insertion Sort ========");
		InsertionSort obj = new InsertionSort();
		System.out.println("Before Sorting");
		obj.printArray(arr);
		long start = System.nanoTime();
		obj.doInsertionSort(arr);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end - start));
		System.out.println("\nAfter Sorting");
		obj.printArray(arr);

	}
}

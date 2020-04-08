/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package sortingAlgos;

class BinaryHeap
{
	int lastIndexUsed;
	int minHeap[];

	public BinaryHeap(int size)
	{
		minHeap = new int[size + 1];
		lastIndexUsed = 0;
	}

	void printHeap()
	{
		System.out.println("\n==============xxxx====================");
		System.out.println("Heap As Below\n");
		int prevlog = 0;
		for (int j = 1; j <= lastIndexUsed; j++)
		{
			if (Math.log(j) / Math.log(2) == prevlog + 1)
			{
				// shahid ka dimag for every power of 2 it will print new line
				System.out.println();
				prevlog += 1;
			}
			System.out.printf("%d ", minHeap[j]);
		}
		System.out.println("\n==============xxxx====================");
	}

	void insertInHeap(int val)
	{
		if (lastIndexUsed < minHeap.length)
		{
			minHeap[lastIndexUsed + 1] = val;
			lastIndexUsed += 1;
			System.out.println(val + " value Inserted");
			heapifyBottomToTop(lastIndexUsed);
		} else
		{
			System.out.println("heap is full");
		}
	}

	void heapifyBottomToTop(int child)
	{
		int parent = child / 2;
		if (parent < 1)
			return;
		else
		{
			if (minHeap[parent] > minHeap[child])
			{
				int temp = minHeap[parent];
				minHeap[parent] = minHeap[child];
				minHeap[child] = temp;
				heapifyBottomToTop(parent);
			}
		}
	}

	int extractFromHeap()
	{
		if (lastIndexUsed < 1)
			return Integer.MIN_VALUE;
		int extractedValue = minHeap[1];
		minHeap[1] = minHeap[lastIndexUsed];
		lastIndexUsed--;
		heapifyTopToBottom(1);
		return extractedValue;
	}

	private void heapifyTopToBottom(int parentIndex)
	{
		int leftChild = parentIndex * 2;
		int rightChild = leftChild + 1;
		int tempSmallerIndex = -1;
		if (leftChild > lastIndexUsed)
		{
			return;
		} else if (leftChild == lastIndexUsed)
		{
			if (minHeap[leftChild] < minHeap[parentIndex])
			{
				int temp = minHeap[parentIndex];
				minHeap[parentIndex] = minHeap[leftChild];
				minHeap[leftChild] = temp;
			}
			return;
		} else
		{
			if (minHeap[leftChild] < minHeap[rightChild])
			{
				tempSmallerIndex = leftChild;
			} else
			{
				tempSmallerIndex = rightChild;
			}
			int temp = minHeap[parentIndex];
			minHeap[parentIndex] = minHeap[tempSmallerIndex];
			minHeap[tempSmallerIndex] = temp;
			heapifyTopToBottom(tempSmallerIndex);
		}
	}
}

public class HeapSort
{
	int sortedArray[];

	public HeapSort(int size)
	{
		sortedArray = new int[size];
	}

	private void doHeapSort(BinaryHeap hp)
	{
		int numberOfElement = hp.lastIndexUsed;
		for (int i = 0; i < numberOfElement; i++)
		{
			//System.out.println("After extract");
			sortedArray[i] = hp.extractFromHeap();
			//hp.printHeap();
		}
	}

	private void printArray()
	{
		int count = 1;
		for (Integer i : sortedArray)
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
		System.out.println("====== Welcome to Heap Sort ========");
		int size=100;
		HeapSort obj = new HeapSort(size);
		BinaryHeap bh = new BinaryHeap(size);
		for (int i = 0; i < size; i++)
		{
			int randomNumber = (int) (Math.random() * 1000);
			obj.sortedArray[i] = randomNumber;
			bh.insertInHeap(randomNumber);
		}
		
		bh.printHeap();
		System.out.println("Before Sorting");
		obj.printArray();
		long start = System.nanoTime();
		obj.doHeapSort(bh);
		long end = System.nanoTime();
		System.out.println("\nAfter Sorting");
		obj.printArray();
		System.out.println("\n\nTime to execute this algo: " + (end - start));
	}
}

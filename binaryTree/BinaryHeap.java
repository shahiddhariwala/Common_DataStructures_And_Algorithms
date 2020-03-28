package binaryTree;

import java.util.Scanner;

public class BinaryHeap
{
	int minArr[];
	int maxArr[];
	int lastUsedMinIndex;
	int lastUsedMaxIndex;

	// create binary tree
	public BinaryHeap(int size)
	{
		this.minArr = new int[size + 1];
		this.maxArr = new int[size + 1];
		// since we are not using index 0
		lastUsedMinIndex = 0;
		lastUsedMaxIndex = 0;
	}

	// Insert a Node in Min Heap
	private void insertNodeInMinHeap(int val)
	{
		if (lastUsedMinIndex < minArr.length)
		{
			if (lastUsedMinIndex == 0)
			{
				// if first node
				minArr[++lastUsedMinIndex] = val;
			} else
			{
				// if not first node the we will have to do minheapifyBottomToTop
				minArr[++lastUsedMinIndex] = val;
				minHeapifyBottomToTop(lastUsedMinIndex);
				// we add our value at last then recursively we put it to place where it
				// satisfies
				// the min-Heap property that is parent node is smaller than child node
			}
			System.out.println("Succesfully Inserted value in Min Heap");
			return;
		}
		System.out.println("Min Heap is full,sorry can't insert more value");
		return;
	}

	private void minHeapifyBottomToTop(int index)
	{
		int parentIndex = index / 2;
		if (index <= 1)
		{
			// if no parent
			// its is a root
			return;
		}
		// then check for minHeap property i.e if parent is smaller than child if not
		// then swap
		if (minArr[parentIndex] > minArr[index])
		{
			int temp = minArr[index];
			minArr[index] = minArr[parentIndex];
			minArr[parentIndex] = temp;
		}
		minHeapifyBottomToTop(parentIndex);
	}

	// Insert a Node in Max Heap
	private void insertNodeInMaxHeap(int val)
	{
		if (lastUsedMaxIndex < maxArr.length)
		{
			if (lastUsedMaxIndex == 0)
			{
				// if first node
				maxArr[++lastUsedMaxIndex] = val;
			} else
			{
				// if not first node the we will have to do minheapifyBottomToTop
				maxArr[++lastUsedMaxIndex] = val;
				maxHeapifyBottomToTop(lastUsedMaxIndex);
				// we add our value at last then recursively we put it to place where it
				// satisfies
				// the min-Heap property that is parent node is smaller than child node
			}
			System.out.println("Succesfully Inserted value in Max Heap");
			return;
		}
		System.out.println("Max Heap is full,sorry can't insert more value");
		return;
	}

	private void maxHeapifyBottomToTop(int index)
	{
		
		int parentIndex = index / 2;
		if (index <= 1)
		{
			// if no parent
			// its is a root
			return;
		}

		// then check for maxHeap property i.e if parent is greater than child if not
		// then swap
		if (maxArr[parentIndex] < maxArr[index])
		{
			int temp = maxArr[index];
			maxArr[index] = maxArr[parentIndex];
			maxArr[parentIndex] = temp;
		}
		maxHeapifyBottomToTop(parentIndex);
	}

	private int extractMin()
	{
		int min = -1;
		if (lastUsedMinIndex < 1)
		{
			return min;
		} else
		{
			min = minArr[1];
			minArr[1] = minArr[lastUsedMinIndex];
			lastUsedMinIndex--;
			this.minHeapifyTopToBottom(1);
		}
		return min;
	}

	private void minHeapifyTopToBottom(int index)
	{
		int left = index * 2;
		int right = left + 1;
		int smallestChild = 1;
		if (left > lastUsedMinIndex)
		{
			// no child
			return;
		} else if (left == lastUsedMinIndex)
		{
			// only left child leaf node
			// do comparison between parent and child
			if (minArr[index] > minArr[left])
			{
				int temp = minArr[index];
				minArr[index] = minArr[left];
				minArr[left] = temp;
			}
			return;
		} else
		{
			// both children present
			// find the smallest and do the minHeapify on it so that we always have
			// smallest value in the parent node
			if (minArr[left] > minArr[right])
				smallestChild = right;
			else
				smallestChild = left;
			// after getting smallest child check whether it is smaller than parent
			// if its is smaller than parent then
			// then swap them
			if (minArr[index] > minArr[smallestChild])
			{
				int temp = minArr[smallestChild];
				minArr[smallestChild] = minArr[index];
				minArr[index] = temp;
			}
			// from above we will be having smaller value on parent node
			// therefore now we can continue with minHeapifying the child node with possible
			// larger
			// value
		}
		this.minHeapifyTopToBottom(smallestChild);
	}

	private int extractMax()
	{
		int max = -1;
		if (lastUsedMaxIndex < 1)
		{
			return max;
		} else
		{
			max = maxArr[1];
			maxArr[1] = maxArr[lastUsedMaxIndex];
			lastUsedMaxIndex--;
			maxHeapifyTopToBottom(1);
		}
		return max;
	}

	// maxHeapifyTopToBottom(1);
	private void maxHeapifyTopToBottom(int index)
	{
		int left = index * 2;
		int right = left + 1;
		int largestChildIndex = 0;
		if (left > lastUsedMaxIndex)
		{
			// no child
			return;
		} else if (left == lastUsedMaxIndex)
		{
			// only last left leaf child
			if (maxArr[index] < maxArr[left])
			{
				// if parent is smaller than child then swap
				int temp = maxArr[left];
				maxArr[left] = maxArr[index];
				maxArr[index] = temp;
			}
			return;
		} else
		{
			//System.out.println(right);
			// if both child are present first get Max Valued child index
			if (maxArr[right] < maxArr[left])
				largestChildIndex = left;
			else
				largestChildIndex = right;
			// after getting the value check if parent is larger or not if smaller then do
			// swap
			if (maxArr[index] < maxArr[largestChildIndex])
			{
				// if parent is smaller than Max Valued child index then swap
				int temp = maxArr[largestChildIndex];
				maxArr[largestChildIndex] = maxArr[index];
				maxArr[index] = temp;
			}
			// it is possible to have subtree below largestChildIndex index and if it is not
			// then first if condition will
			// return null;
			
		}
		maxHeapifyTopToBottom(largestChildIndex);
	}

	private int peekMin()
	{
		if (lastUsedMinIndex == 0)
			return -1;
		return minArr[1];
	}

	private int peekMax()
	{
		if (lastUsedMaxIndex == 0)
			return -1;
		return maxArr[1];
	}

	// levelOrderTraversal
	private void levelOrderTraversalMinHeap(int i)
	{
		if (i > lastUsedMinIndex)
		{
			System.out.println("Binary Min Heap is empty ");
			return;
		}
		System.out.println();
		int prevlog = 0;
		for (int j = i; j <= lastUsedMinIndex; j++)
		{
			
			if (Math.log(j) / Math.log(2) == prevlog + 1)
			{
				// shahid ka dimag for every power of 2 it will print new line
				System.out.println();
				prevlog+=1;
			}
			System.out.printf("%d ", minArr[j]);
		}
	}

	private void levelOrderTraversalMaxHeap(int i)
	{
		if (i > lastUsedMaxIndex)
		{
			System.out.println("Binary Max Heap is empty ");
			return;
		}
		System.out.println();
		int prevlog = 0;
		for (int j = i; j <= lastUsedMaxIndex; j++)
		{
			
			if (Math.log(j) / Math.log(2) == prevlog + 1)
			{
				// shahid ka dimag for every power of 2 it will print new line
				System.out.println();
				prevlog+=1;
			}
			System.out.printf("%d ", maxArr[j]);
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BinaryHeap bt = null;
		int option = 0;
		do
		{
			System.out.println("\n----------------Binary Heap using Array----------------");
			System.out.println("1. Create Binary Heap");
			System.out.println("2. Insert a Node");
			System.out.println("3. Extract Min & Max");
			System.out.println("4. Peek Min and Max");
			System.out.println("5. Traverse i.e Print Heap");
			System.out.println("6. Delete Binary Heap");
			System.out.println("7. Exit ");
			
			try {
				
		
				option = sc.nextInt();
				switch (option) {
				case 1:
					if (bt == null)
					{
						System.out.println("Please enter the size of tree i.e Array size here");
						int size = sc.nextInt();
						bt = new BinaryHeap(size + 1);
						System.out.println("Min and Max Binary Heap Created");
					} else
					{
						System.out.println("Binary Heap already exist");
					}
					break;
				case 2:
					System.out.println("Please enter value to be inserted");
					int val = sc.nextInt();
					bt.insertNodeInMinHeap(val);
					bt.insertNodeInMaxHeap(val);
					break;
				case 3:
					int min = bt.extractMin();
					int max = bt.extractMax();
					System.out.printf("Succesfully Extracted %d from minHeap and %d from maxHeap \n", min, max);
					System.out.println("New MinHeap Peek =>" + bt.peekMin() + "\nNew MaxHeap Peek =>" + bt.peekMax());
					break;
				case 4:
					System.out.println("MinHeap Peek =>" + bt.peekMin() + "\nMaxHeap Peek =>" + bt.peekMax());
					break;
				case 5:
					System.out.print("\nLevel Order Traversal Min Heap: ");
					bt.levelOrderTraversalMinHeap(1);
					System.out.print("\nLevel Order Traversal Max Heap: ");
					bt.levelOrderTraversalMaxHeap(1);
					break;
				case 6:
					bt = null;
					System.out.println("Binary Heap deleted");
					break;
				case 7:
					System.out.println("Sayonara !");
					break;
				default:
					System.out.println("Please choose correct option !!!");
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				System.out.println("Something went Wrong");
				option=7;
			}
			
		} while (option != 7);
		
		sc.close();
	}
	
}

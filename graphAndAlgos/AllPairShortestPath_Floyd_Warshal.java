package graphAndAlgos;

import java.util.ArrayList;

public class AllPairShortestPath_Floyd_Warshal
{
	ArrayList<WeightedDirectedGraphNode> nodeList = new ArrayList<WeightedDirectedGraphNode>();
	int arr[][];

	public AllPairShortestPath_Floyd_Warshal(int size)
	{
		arr = new int[size][size];
	}

	private void insertWeightedDirectedGraphEdge(int v1, int v2, int value)
	{
		WeightedDirectedGraphNode node1 = nodeList.get(v1 - 1);
		WeightedDirectedGraphNode node2 = nodeList.get(v2 - 1);
		node1.neighbors.add(node2);
		node1.neighborsWeight.put(node2, value);
	}

	private void findAllShortestpathUsingFloydWarshal()
	{
		// Assigning values in Floyd Warshal's Matrix
		for (int i = 0; i < nodeList.size(); i++)
		{
			WeightedDirectedGraphNode currentRowNode = nodeList.get(i);
			for (int j = 0; j < nodeList.size(); j++)
			{
				WeightedDirectedGraphNode currentColNode = nodeList.get(j);
				if (i == j)
				{
					arr[i][j] = 0;
				} else if (currentRowNode.neighborsWeight.containsKey(currentColNode))
				{
					arr[i][j] = currentRowNode.neighborsWeight.get(currentColNode);
				} else
				{
					arr[i][j] = Integer.MAX_VALUE / 10;
				}
				// System.out.printf(arr[i][j] + " ");
			}
			// System.out.println("\n");
		}
		// Now time for magic
		for (int k = 0; k < nodeList.size(); k++)
		{
			//System.out.printf("\nFor %c \n", (char) 65 + k);
			for (int i = 0; i < nodeList.size(); i++)
			{
				for (int j = 0; j < nodeList.size(); j++)
				{
					if (arr[i][j] > arr[i][k] + arr[k][j])
					{
						//System.out.printf("\n\nChecking if %d > %d + %d",arr[i][j], arr[i][k],arr[k][j]);
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		System.out.println("\nPrinting the Node and their Minimum Distance to reach other Nodes\n");
		System.out.println("  "+nodeList);
		for (int i = 0; i < nodeList.size(); i++)
		{
			System.out.print(nodeList.get(i)+": ");
			for (int j = 0; j < nodeList.size(); j++)
			{
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		System.out.println("======= Welcome to APSP Floyd Warshal ============\n");
		int numberOfVertex = 4;
		AllPairShortestPath_Floyd_Warshal grap = new AllPairShortestPath_Floyd_Warshal(numberOfVertex);
		for (int i = 0; i < numberOfVertex; i++)
		{
			grap.nodeList.add(new WeightedDirectedGraphNode(i));
		}
		System.out.println("Following are the vertices in the graph");
		System.out.println(grap.nodeList);
		grap.insertWeightedDirectedGraphEdge(1, 4, 1);// Add A-> D , weight 1
		grap.insertWeightedDirectedGraphEdge(1, 2, 8);// Add A-> B , weight 8
		grap.insertWeightedDirectedGraphEdge(2, 3, 1);// Add B-> C , weight 1
		grap.insertWeightedDirectedGraphEdge(3, 1, 4);// Add C-> A , weight 4
		grap.insertWeightedDirectedGraphEdge(4, 2, 2);// Add D-> B , weight 2
		grap.insertWeightedDirectedGraphEdge(4, 3, 9);// Add D-> C , weight 9
		grap.findAllShortestpathUsingFloydWarshal();
	}
}

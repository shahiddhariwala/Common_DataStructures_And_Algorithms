/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package graphAndAlgos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SingleSourceShortestPath_Bellman_Ford
{
	ArrayList<WeightedDirectedGraphNode> nodeList = new ArrayList<WeightedDirectedGraphNode>();

	private void insertWeightedDirectedGraphEdge(int v1, int v2, int value)
	{
		WeightedDirectedGraphNode node1 = nodeList.get(v1 - 1);
		WeightedDirectedGraphNode node2 = nodeList.get(v2 - 1);
		node1.neighbors.add(node2);
		node1.neighborsWeight.put(node2, value);
	}

	private void getShortestPathUsingBellmanFordAlgo(WeightedDirectedGraphNode sourceNode)
	{
		sourceNode.currentDistance = 0;
		for (int j = 1; j < nodeList.size(); j++)
			for (WeightedDirectedGraphNode tempNode : nodeList)
			{ // for each edge
				for (WeightedDirectedGraphNode neighbor : tempNode.neighbors)
				{
					if (neighbor.currentDistance > tempNode.currentDistance + tempNode.neighborsWeight.get(neighbor))
					{
						neighbor.currentDistance = tempNode.currentDistance + tempNode.neighborsWeight.get(neighbor);
						neighbor.parent = tempNode;
					}
				}
			}
		System.out.println("Checking for Negative Cycle......");
		for (WeightedDirectedGraphNode tempNode : nodeList)
		{ // for each edge
			for (WeightedDirectedGraphNode neighbor : tempNode.neighbors)
			{
				if (neighbor.currentDistance > tempNode.currentDistance + tempNode.neighborsWeight.get(neighbor))
				{
					System.out.println("Negative Cycle Detected");
					return;
				}
			}
		}
		System.out.println("No Negative Cycle");
		System.out.println("\nFollowing are the path from " + sourceNode);
		for (WeightedDirectedGraphNode node : nodeList)
		{
			System.out.println("\nPrinting path to " + node + " in shortest distance of " + node.currentDistance);
			printPath(node);
		}
	}

	private void printPath(WeightedDirectedGraphNode pathNode)
	{
		if (pathNode.parent != null)
		{
			printPath(pathNode.parent);
		} else
		{
			System.out.print("Source " + pathNode);
			return;
		}
		System.out.print(" --> " + pathNode);
	}

	public static void main(String[] args)
	{
		System.out.println("======= Welcome to SSSP Bellman Ford ============");
		SingleSourceShortestPath_Bellman_Ford grap = new SingleSourceShortestPath_Bellman_Ford();
		int numberOfVertex = 5;
		for (int i = 0; i < numberOfVertex; i++)
		{
			grap.nodeList.add(new WeightedDirectedGraphNode(i));
		}
		System.out.println("Following are the vertices in the graph");
		System.out.println(grap.nodeList);
		grap.insertWeightedDirectedGraphEdge(1, 3, 6); // Add A-> C , weight 6
		grap.insertWeightedDirectedGraphEdge(1, 4, 3); // Add A-> D , weight 3
		grap.insertWeightedDirectedGraphEdge(2, 1, 3); // Add B-> A , weight 3
		grap.insertWeightedDirectedGraphEdge(3, 4, 2); // Add C-> D , weight 2
		grap.insertWeightedDirectedGraphEdge(4, 3, 1); // Add D-> C , weight 1
		grap.insertWeightedDirectedGraphEdge(4, 2, 1); // Add D-> B , weight 1
		grap.insertWeightedDirectedGraphEdge(5, 2, 4); // Add E-> B , weight 4
		grap.insertWeightedDirectedGraphEdge(5, 4, 2); // Add E-> D , weight 2
		// Negative Cycle
//		grap.insertWeightedDirectedGraphEdge(1, 3, 6); // Add A-> C , weight 6
//		grap.insertWeightedDirectedGraphEdge(2, 1, 3); // Add B-> A , weight 3
//		//graph.addWeightedEdge(1, 4, 6); // Add A-> D , weight 6
//		grap.insertWeightedDirectedGraphEdge(1,4,-6); //Add A-> D , weight -6 TEST NEGATIVE WEIGHT
//		// HERE
//		grap.insertWeightedDirectedGraphEdge(4, 3, 1); // Add D-> C , weight 1
//		grap.insertWeightedDirectedGraphEdge(3, 4, 2); // Add C-> D , weight 2
//		grap.insertWeightedDirectedGraphEdge(4, 2, 1); // Add D-> B , weight 1
//		grap.insertWeightedDirectedGraphEdge(5, 4, 2); // Add E-> D , weight 2
//		grap.insertWeightedDirectedGraphEdge(5, 2, 4); // Add E-> B , weight 4
		
		
		int source = 4;
		WeightedDirectedGraphNode sourceNode = grap.nodeList.get(source);
		grap.getShortestPathUsingBellmanFordAlgo(sourceNode);
	}
}

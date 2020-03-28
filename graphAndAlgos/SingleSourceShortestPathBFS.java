package graphAndAlgos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SingleSourceShortestPathBFS
{
	ArrayList<UnweightedUndirectedGraphNode> nodeList = new ArrayList<UnweightedUndirectedGraphNode>();

	private void insertUnweightedUnDirectedEdge(int v1, int v2)
	{
		UnweightedUndirectedGraphNode ver1 = nodeList.get(v1);
		UnweightedUndirectedGraphNode ver2 = nodeList.get(v2);
		ver1.neighbors.add(ver2);
		ver2.neighbors.add(ver1);
	}

	private void doBFSForSSSP(UnweightedUndirectedGraphNode source)
	{
		Queue<UnweightedUndirectedGraphNode> q = new LinkedList<UnweightedUndirectedGraphNode>();
		q.add(source);
		while (!q.isEmpty())
		{
			UnweightedUndirectedGraphNode tempNode = q.remove();
			System.out.println("\n\nPrint Shortest Path to " + tempNode);
			printPath(tempNode);
			tempNode.isVisited = true;
			for (UnweightedUndirectedGraphNode neighbor : tempNode.neighbors)
			{
				if (neighbor.isVisited == false)
				{
					q.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = tempNode;
				}
			}
		}
	}

	private void printPath(UnweightedUndirectedGraphNode pathNode)
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
		System.out.println("======= Welcome to SSSP BFS============");
		SingleSourceShortestPathBFS grap = new SingleSourceShortestPathBFS();
		int numberOfVertex = 10;
		for (int i = 0; i < numberOfVertex; i++)
		{
			grap.nodeList.add(new UnweightedUndirectedGraphNode(i));
		}
		System.out.println("Following are the vertices in the graph");
		System.out.println(grap.nodeList);
		grap.insertUnweightedUnDirectedEdge(0, 8);
		grap.insertUnweightedUnDirectedEdge(8, 2);
		grap.insertUnweightedUnDirectedEdge(8, 9);
		grap.insertUnweightedUnDirectedEdge(2, 1);
		grap.insertUnweightedUnDirectedEdge(9, 1);
		grap.insertUnweightedUnDirectedEdge(2, 4);
		grap.insertUnweightedUnDirectedEdge(1, 3);
		grap.insertUnweightedUnDirectedEdge(1, 7);
		grap.insertUnweightedUnDirectedEdge(3, 4);
		grap.insertUnweightedUnDirectedEdge(3, 5);
		grap.insertUnweightedUnDirectedEdge(7, 6);
		grap.insertUnweightedUnDirectedEdge(5, 6);
		int source = 2;
		System.out.println("Printing BFS From " + source);
		grap.doBFSForSSSP(grap.nodeList.get(2));
	}
}

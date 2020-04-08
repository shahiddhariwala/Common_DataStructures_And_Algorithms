/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package graphAndAlgos;

import java.util.*;

public class DFSTraversal
{
	ArrayList<UnwieghtedGraphNode> nodeList = new ArrayList<UnwieghtedGraphNode>();

	private void insertUnwieghtedEdge(int v1, int v2)
	{
		UnwieghtedGraphNode ver1 = nodeList.get(v1 - 1);
		UnwieghtedGraphNode ver2 = nodeList.get(v2 - 1);
		if (!ver1.neighbors.contains(ver2) && !ver2.neighbors.contains(ver1))
		{
			ver1.neighbors.add(ver2);
			ver2.neighbors.add(ver1);
		}
	}

	private void printDFS()
	{
		for (UnwieghtedGraphNode node : nodeList)
		{
			if (node.isVisitied == false)
			{
				printVertexAndNeigbor(node);
			}
		}
	}

	private void printVertexAndNeigbor(UnwieghtedGraphNode ver)
	{
		Stack<UnwieghtedGraphNode> stak = new Stack<UnwieghtedGraphNode>();
		// Queue<UnwieghtedGraphNode> q = new LinkedList<UnwieghtedGraphNode>();
		stak.push(ver);
		while (!stak.isEmpty())
		{
			UnwieghtedGraphNode tempNode = stak.pop();
			System.out.print(tempNode.nameOfNode + " ");
			tempNode.isVisitied = true;
			for (UnwieghtedGraphNode neighbor : tempNode.neighbors)
			{
				if (neighbor.isVisitied == false)
				{
					stak.push(neighbor);
					neighbor.isVisitied = true;
				}
			}
		}
	}

	public static void main(String[] args)
	{
		System.out.println("============DFS Traversal=================\n");
		DFSTraversal grap = new DFSTraversal();
		int numberOfVertex = 6;
		for (int i = 0; i < numberOfVertex; i++)
		{
			grap.nodeList.add(new UnwieghtedGraphNode(i + 1));
		}
		System.out.println("Following are vertices in graph");
		for (int i = 0; i < numberOfVertex; i++)
		{
			System.out.print(grap.nodeList.get(i).nameOfNode + " ");
		}
		grap.insertUnwieghtedEdge(1, 2);
		grap.insertUnwieghtedEdge(1, 3);
		grap.insertUnwieghtedEdge(5, 2);
		grap.insertUnwieghtedEdge(5, 4);
		grap.insertUnwieghtedEdge(5, 6);
		grap.insertUnwieghtedEdge(3, 4);
		grap.insertUnwieghtedEdge(4, 6);
		System.out.println("\n==========================================");
		System.out.println("\nPrinting Using DFS Traversal");
		grap.printDFS();
		System.out.println("\n==========================================");
	}
}

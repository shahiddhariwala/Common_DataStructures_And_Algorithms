package graphAndAlgos;

import java.util.*;



public class BFSTraversal
{
	ArrayList<UnwieghtedGraphNode> nodeList = new ArrayList<UnwieghtedGraphNode>();

	private void insertUnwieghtedEdge(int v1, int v2)
	{
		UnwieghtedGraphNode ver1 = nodeList.get(v1-1);
		UnwieghtedGraphNode ver2 = nodeList.get(v2-1);
		if (!ver1.neighbors.contains(ver2) && !ver2.neighbors.contains(ver1))
		{
			ver1.neighbors.add(ver2);
			ver2.neighbors.add(ver1);
		}
	}

	private void printBFS()
	{
		for(UnwieghtedGraphNode node : nodeList)
		{
			if(node.isVisitied==false)
			{
				printVertexAndNeigbor(node);
			}
		}
		
	}
	
	private void printVertexAndNeigbor(UnwieghtedGraphNode ver)
	{
		if(!ver.neighbors.isEmpty())
		{
			//Stack<UnwieghtedGraphNode> stak= new Stack<UnwieghtedGraphNode>();
			Queue<UnwieghtedGraphNode> q = new LinkedList<UnwieghtedGraphNode>();
			q.add(ver);
			
			while(!q.isEmpty())
			{
				UnwieghtedGraphNode tempNode = q.remove();
				if(tempNode.isVisitied==false)
				{
					System.out.print(tempNode.nameOfNode+" ");
					tempNode.isVisitied=true;
					for(UnwieghtedGraphNode neighbor : tempNode.neighbors)
						q.add(neighbor);
					
				}
			}
		}
		else
		{
			System.out.print(ver.nameOfNode+" ");
			ver.isVisitied=true;
			return;
		}
	}
	public static void main(String[] args)
	{
		System.out.println("============BFS Traversal=================\n");
		BFSTraversal grap = new BFSTraversal();
		int numberOfVertex=10;
		for (int i = 0; i < numberOfVertex; i++)
		{
			grap.nodeList.add(new UnwieghtedGraphNode(i+1));
		}
		System.out.println("Following are vertices in graph");
		for (int i = 0; i < numberOfVertex; i++)
		{
			System.out.print(grap.nodeList.get(i).nameOfNode+" ");
		}
		
		grap.insertUnwieghtedEdge(1,7);
		grap.insertUnwieghtedEdge(1,8);
		grap.insertUnwieghtedEdge(1,4);
		grap.insertUnwieghtedEdge(7,6);
		grap.insertUnwieghtedEdge(7,5);
		grap.insertUnwieghtedEdge(8,2);
		grap.insertUnwieghtedEdge(8,3);
		grap.insertUnwieghtedEdge(4,9);
		grap.insertUnwieghtedEdge(4,10);
		
		System.out.println("\nPrinting Using BFS Traversal");
		grap.printBFS();
	}
}

/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package graphAndAlgos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class TopologicalSort
{
	Stack<UnwieghtedDirectedNode> stack = new Stack<UnwieghtedDirectedNode>();
	
	private void insertUnwieghtedDirectedEdge(int v1,int v2)
	{
		UnwieghtedDirectedNode ver1 = nodeList.get(v1-1);
		UnwieghtedDirectedNode ver2 = nodeList.get(v2-1);
		ver1.neighbors.add(ver2);
		
	}
	ArrayList<UnwieghtedDirectedNode> nodeList = new ArrayList<UnwieghtedDirectedNode>();

	private void doTopologicalSort()
	{
		
		for (UnwieghtedDirectedNode node : nodeList)
		{
			if (node.isVisited == false)
			{
				doTopologicalVisit(node);
			}
		}
		
		System.out.println("\n========= We will Follow below Procedure==============");
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" --> ");
		}
		
	}
	
	private void doTopologicalVisit(UnwieghtedDirectedNode node)
	{
		for(UnwieghtedDirectedNode neighbor : node.neighbors)
		{
			if(neighbor.isVisited==false)
				doTopologicalVisit(neighbor);
		}
		node.isVisited=true;
		stack.push(node);
	}
	public static void main(String[] args)
	{
		System.out.println("============Topological Sort Traversal=================\n");
		TopologicalSort grap = new TopologicalSort();
		int numberOfVertex = 6;
		for (int i = 0; i < numberOfVertex; i++)      
		{
			grap.nodeList.add(new UnwieghtedDirectedNode(i + 1));
		}
		
		grap.insertUnwieghtedDirectedEdge(1,2);
		grap.insertUnwieghtedDirectedEdge(2,3);
		grap.insertUnwieghtedDirectedEdge(2,4);
		grap.insertUnwieghtedDirectedEdge(3,5);
		grap.insertUnwieghtedDirectedEdge(4,6);
		grap.insertUnwieghtedDirectedEdge(5,4);
		grap.insertUnwieghtedDirectedEdge(5,6);
//		
		
//		grap.insertUnwieghtedDirectedEdge(1,3);
//		grap.insertUnwieghtedDirectedEdge(2,4);
//		grap.insertUnwieghtedDirectedEdge(2,3);
//		grap.insertUnwieghtedDirectedEdge(3,5);
//		grap.insertUnwieghtedDirectedEdge(4,6);
//		grap.insertUnwieghtedDirectedEdge(5,8);
//		grap.insertUnwieghtedDirectedEdge(5,6);
//		grap.insertUnwieghtedDirectedEdge(6,7);
		
		System.out.println("Following are vertices in graph");
		for (int i = 0; i < numberOfVertex; i++)
		{
			System.out.print(grap.nodeList.get(i) + " ");
		}
		
		grap.doTopologicalSort();
		
	}

	
}

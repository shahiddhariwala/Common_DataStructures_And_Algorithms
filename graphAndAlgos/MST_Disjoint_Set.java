/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package graphAndAlgos;

import java.util.ArrayList;

public class MST_Disjoint_Set
{
	ArrayList<WeightedUnDirectedGraphNode> nodesInSet = new ArrayList<WeightedUnDirectedGraphNode>();
	
	public static void makeSetNodes(ArrayList<WeightedUnDirectedGraphNode> nodeList)
	{
		for(WeightedUnDirectedGraphNode node : nodeList)
		{
			MST_Disjoint_Set set = new MST_Disjoint_Set();
			set.nodesInSet.add(node);
			node.nodeSet = set;
		}
		
	}
	
	public static void makeUnionOfSet(WeightedUnDirectedGraphNode node1,WeightedUnDirectedGraphNode node2)
	{
		if(node1.nodeSet.equals(node2.nodeSet))
		{
			return;
		}
		MST_Disjoint_Set set1 = node1.nodeSet;
		MST_Disjoint_Set set2 = node2.nodeSet;
		if(set2.nodesInSet.size() > set1.nodesInSet.size())
		{
			for(WeightedUnDirectedGraphNode nodesFromSet1 : set1.nodesInSet)
			{
				nodesFromSet1.nodeSet=set2;
				set2.nodesInSet.add(nodesFromSet1);
			}
		}
		else
		{
			for(WeightedUnDirectedGraphNode nodesFromSet2 : set2.nodesInSet)
			{
				nodesFromSet2.nodeSet=set1;
				set1.nodesInSet.add(nodesFromSet2);
			}
		}
	}
	
	public static void printSet(MST_Disjoint_Set set)
	{
		System.out.println("Set Contains: ");
		for(WeightedUnDirectedGraphNode nodes : set.nodesInSet)
			System.out.print(nodes+" ");
		
	}
}

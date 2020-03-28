package graphAndAlgos;

import java.util.LinkedList;

public class UnweightedUndirectedGraphNode
{
	String nameOfNode;
	int index;
	boolean isVisited;
	UnweightedUndirectedGraphNode parent;
	LinkedList<UnweightedUndirectedGraphNode> neighbors = new LinkedList<UnweightedUndirectedGraphNode>();

	public UnweightedUndirectedGraphNode(int val)
	{
		index = val;
		nameOfNode = "V" + val;
		isVisited = false;
	}

	@Override
	public String toString()
	{
		return nameOfNode;
	}
}
package graphAndAlgos;

import java.util.HashMap;
import java.util.LinkedList;

public class WeightedDirectedGraphNode implements Comparable<WeightedDirectedGraphNode>
{
	String nameOfNode;
	int index;
	boolean isVisited;
	WeightedDirectedGraphNode parent;
	int currentDistance;
	LinkedList<WeightedDirectedGraphNode> neighbors = new LinkedList<WeightedDirectedGraphNode>();
	HashMap<WeightedDirectedGraphNode, Integer> neighborsWeight = new HashMap<WeightedDirectedGraphNode, Integer>();

	public WeightedDirectedGraphNode(int val)
	{
		index = val;
		nameOfNode = ""+(char) (65 + val);
		isVisited = false;
		currentDistance=Integer.MAX_VALUE/10;
	}

	@Override
	public String toString()
	{
		return nameOfNode;
	}

	@Override
	public int compareTo(WeightedDirectedGraphNode o)
	{
		return this.currentDistance-o.currentDistance;
	}
}

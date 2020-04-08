/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package graphAndAlgos;

import java.util.HashMap;
import java.util.LinkedList;

public class WeightedUnDirectedGraphNode implements Comparable<WeightedUnDirectedGraphNode>
{
	String nameOfNode;
	int index;
	boolean isVisited;
	WeightedUnDirectedGraphNode parent;
	int currentDistance;
	MST_Disjoint_Set nodeSet;
	LinkedList<WeightedUnDirectedGraphNode> neighbors = new LinkedList<WeightedUnDirectedGraphNode>();
	HashMap<WeightedUnDirectedGraphNode, Integer> neighborsWeight = new HashMap<WeightedUnDirectedGraphNode, Integer>();

	public WeightedUnDirectedGraphNode(int val)
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
	public int compareTo(WeightedUnDirectedGraphNode o)
	{
		return this.currentDistance-o.currentDistance;
	}
}

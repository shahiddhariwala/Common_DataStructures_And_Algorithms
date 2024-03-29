/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package graphAndAlgos;

import java.util.LinkedList;

public class UnwieghtedDirectedNode
{
	String nameOfNode;
	int index;
	boolean isVisited;
	UnwieghtedDirectedNode parent;
	LinkedList<UnwieghtedDirectedNode> neighbors = new LinkedList<UnwieghtedDirectedNode>();

	public UnwieghtedDirectedNode(int val)
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
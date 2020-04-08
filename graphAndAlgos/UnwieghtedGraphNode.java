/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package graphAndAlgos;

import java.util.LinkedList;

public class UnwieghtedGraphNode
{
	String nameOfNode;
	int index;
	boolean isVisitied;

	@Override
	public String toString()
	{
		return nameOfNode;
	}

	LinkedList<UnwieghtedGraphNode> neighbors = new LinkedList<UnwieghtedGraphNode>();

	public UnwieghtedGraphNode(int val)
	{
		// When New Node is Created
		this.isVisitied = false;
		this.nameOfNode = "V" + val;
		this.index = val;
	}
}

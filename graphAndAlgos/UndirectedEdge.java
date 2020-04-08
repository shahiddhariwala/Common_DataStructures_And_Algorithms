/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package graphAndAlgos;

public class UndirectedEdge implements Comparable<UndirectedEdge>
{
	WeightedUnDirectedGraphNode vertex1;
	WeightedUnDirectedGraphNode vertex2;
    int distance;
    
    public UndirectedEdge(WeightedUnDirectedGraphNode v1, WeightedUnDirectedGraphNode v2,int dis)
    {
    	this.vertex1=v1;
    	this.vertex2=v2;
    	this.distance=dis;
    }
    public String toString()
    {
		return "Edge ("+vertex1+","+vertex2+ ") Weight: "+distance;
    }
	@Override
	public int compareTo(UndirectedEdge o)
	{
		// TODO Auto-generated method stub
		return this.distance-o.distance;
	}
}

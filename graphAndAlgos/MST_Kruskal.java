package graphAndAlgos;

import java.util.ArrayList;
import java.util.Collections;

public class MST_Kruskal
{
	ArrayList<WeightedUnDirectedGraphNode> nodeList = new ArrayList<WeightedUnDirectedGraphNode>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<UndirectedEdge>();
	ArrayList<UndirectedEdge> mstEdgeList = new ArrayList<UndirectedEdge>();
	
	public void addWeightedUndirectedEdge(int n1, int n2, int value)
	{
		WeightedUnDirectedGraphNode node1 = nodeList.get(n1 - 1);
		WeightedUnDirectedGraphNode node2 = nodeList.get(n2 - 1);
		node1.neighbors.add(node2);
		node2.neighbors.add(node1);
		node1.neighborsWeight.put(node2,value);
		node2.neighborsWeight.put(node1,value);
		edgeList.add(new UndirectedEdge(node1, node2, value));
	}

	public void doKruskalsMagic()
	{
		MST_Disjoint_Set.makeSetNodes(nodeList);
		
		Collections.sort(edgeList);
		
		int cost=0;
		for(UndirectedEdge edge: edgeList)
		{
			if(!edge.vertex1.nodeSet.equals(edge.vertex2.nodeSet))
			{
				MST_Disjoint_Set.makeUnionOfSet(edge.vertex1, edge.vertex2);
				cost=cost+edge.distance;
				mstEdgeList.add(edge);
			}
		}
		
		System.out.println("\nTotal Cost of MST "+cost);
		System.out.println("Following are the edges in MST\n");
		for(UndirectedEdge edge : mstEdgeList)
			System.out.println(edge);
		
	}
	public static void main(String[] args)
	{
		System.out.println("+++++++Lets Find MST Using Kruskal+++++++++++++++");
		int numOfVertex = 5;
		MST_Kruskal graph = new MST_Kruskal();
		for (int i = 0; i < numOfVertex; i++)
		{
			graph.nodeList.add(new WeightedUnDirectedGraphNode(i));
		}
		System.out.println("folliowing are the vertices in graph");
		System.out.println(graph.nodeList);
		// Add A<-> B , weight 10
		graph.addWeightedUndirectedEdge(1, 2, 10);
		// Add A<-> C , weight 20
		graph.addWeightedUndirectedEdge(1, 3, 20);
		graph.addWeightedUndirectedEdge(2, 3, 30);
		graph.addWeightedUndirectedEdge(2, 4, 5);
		graph.addWeightedUndirectedEdge(3, 4, 15);
		graph.addWeightedUndirectedEdge(3, 5, 6);
		graph.addWeightedUndirectedEdge(4, 5, 8);
		
		System.out.println("Following are the edges in graph\n");
		for(UndirectedEdge edge : graph.edgeList)
			System.out.println(edge);
		
		graph.doKruskalsMagic();
		
	}
}

package graphAndAlgos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_Prims
{
	ArrayList<WeightedUnDirectedGraphNode> nodeList = new ArrayList<WeightedUnDirectedGraphNode>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<UndirectedEdge>();

	public void addWeightedUndirectedEdge(int n1, int n2, int value)
	{
		WeightedUnDirectedGraphNode node1 = nodeList.get(n1 - 1);
		WeightedUnDirectedGraphNode node2 = nodeList.get(n2 - 1);
		node1.neighbors.add(node2);
		node2.neighbors.add(node1);
		node1.neighborsWeight.put(node2, value);
		node2.neighborsWeight.put(node1, value);
		edgeList.add(new UndirectedEdge(node1, node2, value));
	}

	public void doPrimsMagic(int source)
	{

		nodeList.get(source).currentDistance = 0;
		PriorityQueue<WeightedUnDirectedGraphNode> q = new PriorityQueue<WeightedUnDirectedGraphNode>();
		q.addAll(nodeList);
		while (!q.isEmpty())
		{
			WeightedUnDirectedGraphNode vertex = q.remove();
			for (WeightedUnDirectedGraphNode neighbor : vertex.neighbors)
			{
				//checking contains because we don't want to visit it again
				if (q.contains(neighbor))
				{
					if (neighbor.currentDistance >vertex.neighborsWeight.get(neighbor))
					{
						neighbor.currentDistance = vertex.neighborsWeight.get(neighbor);
						neighbor.parent = vertex;
						q.remove(neighbor);
						q.add(neighbor);
					}
				}
			}
		}
		int cost=0;
		System.out.println("\n\nPrinting MST From Source "+(char)(65+source));
		for (WeightedUnDirectedGraphNode node : nodeList)
		{
			if(!node.equals(nodeList.get(source)))
			{
			System.out.println("Edge (" + node + "," + node.parent + ") Weight : " + node.currentDistance);
			cost=cost+node.currentDistance;
			}
		}
		System.out.println("Cost of MST : "+cost);
	}

	public static void main(String[] args)
	{
		System.out.println("+++++++Lets Find MST Using Kruskal+++++++++++++++");
		int numOfVertex = 5;
		MST_Prims graph = new MST_Prims();
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
		for (UndirectedEdge edge : graph.edgeList)
			System.out.println(edge);
		graph.doPrimsMagic(0);
	}
}

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.generators.random.ErdosRenyiGenerator;
public class Main{

	private Graph<Vertex, Edge> generateGraph(int numVertices) {
		GraphFactory graphFactory = new GraphFactory();
		Factory<Vertex> vertexFactory = new VertexFactory();
		Factory<Edge> edgeFactory = new EdgeFactory();
		ErdosRenyiGenerator<Vertex, Edge> gen =
			new ErdosRenyiGenerator(graphFactory, vertexFactory, edgeFactory, numVertices, 0.52);
		return gen.create();
	}

	public UndirectedSparseGraph<Vertex, Edge> graph;	

	public void init(){
		graph = (UndirectedSparseGraph) generateGraph(100);
	}

	public static void main(String [] args){
		Main first = new Main();
		first.init();
		System.out.println(	first.graph.toString());
	}

	public void DijkstraExpansion(){
		if(graph == null) return;	
		Dijkstra alg = new Dijkstra(graph,1);
		alg.setUnlimited();
		alg.setSourceDist();
		alg.makeQueue();

	}

	



}

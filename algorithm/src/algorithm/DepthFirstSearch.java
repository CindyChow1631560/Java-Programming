package algorithm;
import java.util.ArrayList;
import java.util.Scanner;
class Graph{
	private final int V;
	private int E;
	private ArrayList<Integer>[] adj;
	public Graph(int V){
		this.V=V;this.E=E;
		adj = new ArrayList[V];//create adjscent table
		for(int v=0;v<V;v++){
			adj[v]= new ArrayList();  //inilize adjscent table
		}
	}
	public Graph(Scanner in){
		this(in.nextInt());  //read V and inilize the Graph
		int E =in.nextInt();  //read E
		for (int i=0;i<E;i++){
			int v= in.nextInt(); //read one point
			int w= in.nextInt(); //read another point
			addEdge(v,w);
		}
	}
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
    public Iterable<Integer> adj(int v){
    	return adj[v];
    }
}
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	public DepthFirstSearch(Graph G, int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	private void dfs(Graph G, int v){
		marked[v]=true;
		count++;
		for(int w:G.adj(v)){
			if(!marked[w]) dfs(G,w);
		}
	}
	public boolean marked(int w){
		return marked[w];
	}
	public int count(){
		return count;
	}

}

package algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class pathInGraph {
public static void main(String[] args){
	Scanner in = new Scanner(System.in);Scanner line = new Scanner(System.in);
    int n= in.nextInt();
    String[][] input = new String[n-1][2];
    for (int i=0;i<n-1;i++){   //ÊäÈë¶àÐÐ×Ö·û´®
  	  String str = line.nextLine();
  	  String[] sque = str.trim().split(" "); 
  	  input[i]=sque;
    }
    int[][] inpu = new int[n-1][2];
    for(int i=0;i<n-1;i++){
    	inpu[i][0]=Integer.parseInt(input[i][0]);
    	inpu[i][1]=Integer.parseInt(input[i][1]);
    }
    Graphs graph = new Graphs(n-1,inpu);
    FindPath dfs = new FindPath(graph,inpu[0][0]);
	int res = dfs.pathTo(inpu[n-1][1]);
	System.out.println(res);   
}
}
class Graphs{
	private int V;
	int E;
	private ArrayList<Integer>[] adj;
	public Graphs(int V){
		this.V=V;this.E=E;
		adj = new ArrayList[V];//create adjscent table
		for(int v=0;v<V;v++){
			adj[v]= new ArrayList();  //inilize adjscent table
		}
	}
	public Graphs(int E,int[][] in){
		//this(in.nextInt());  //read V and inilize the Graph
		//int E =in.nextInt();  //read E
		this.E=E;
		for (int i=0;i<E;i++){
			int v= in[i][0]; //read one point
			int w= in[i][1]; //read another point
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

 class FindPath {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	private int count;
	public FindPath(Graphs G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s=s;
		dfs(G,s);
	}
	private void dfs(Graphs G, int v){
		marked[v]=true;
		count++;
		for(int w:G.adj(v)){
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(G,w);
			}
		}
	}
	public boolean marked(int w){
		return marked[w];
	}
	public int count(){
		return count;
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public int pathTo(int v){
		if(!hasPathTo(v)) return 0;
		Stack<Integer> path = new Stack<Integer>();
		for(int x=v;x!=s;x=edgeTo[x]){
			path.push(x);
			
		}
		path.push(s);
		return path.size();
	}

}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class BipartiteGraph {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
      
        graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
    }




    //// Logic 1:
    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i] == -1){  //Performing the BFS
               q.add(i);
               color[i] = 0;

               while(!q.isEmpty()){
                int curr = q.remove();

                for(int j=0;j<graph[curr].size();j++){
                    Edge e = graph[curr].get(j);

                    //case 1:
                    if(color[e.dest] == -1){
                        int newColor = color[curr] == 0 ? 1:0;
                        color[e.dest] = newColor;
                        q.add(e.dest);
                    }

                    //case 2:
                    if(color[curr] == color[e.dest]){
                        return false;
                    }
                }
               }
            }
        }
        return true;
    }

    

    // Logic 2:
    // 1. check if the graph is acyclic -- True
    // 2. check if graph has even nodes. -- True
    // 3. check if graph has odd nodes. --False
    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        // if(isBipartite(graph)){
        //     System.out.println("Graph is Bipartite");
        // }else{
        //     System.out.println("Graph is not Bipartite");
        // }
    }
}

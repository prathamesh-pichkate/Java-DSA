///// Topological Sort using BFS ////////
///// It uses the indegree method ///////////
///// Kahn's Algorithm //////////////

import java.util.ArrayList;
import java.util.*;
public class TopologicalSortBFS {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }


    public static void calIndegree(ArrayList<Edge> graph[],int indegree[]){
        for(int i=0;i<graph.length;i++){
           for(int j=0;j<graph[i].size();j++){
            Edge e = graph[i].get(j);
            indegree[e.dest]++;
           }
        }
    }

    public static void topologicalSort(ArrayList<Edge> graph[]){
        int indegree[] = new int[graph.length];
        calIndegree(graph, indegree);
        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " "); //print topological sort

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;

                if(indegree[e.dest] == 0){  
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V =6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        topologicalSort(graph);
    }
    
}

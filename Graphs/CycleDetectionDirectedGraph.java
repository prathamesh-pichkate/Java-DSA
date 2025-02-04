import java.util.ArrayList;

public class CycleDetectionDirectedGraph {
    static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }



        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtil(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean visited[], boolean stack[]) {
        visited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 1: If the destination node is already in the recursion stack, cycle exists
            if (stack[e.dest]) {
                return true;
            }

            // Case 2: If not visited, continue DFS
            if (!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)) {
                return true;
            }
        }

        stack[curr] = false; // Backtrack: reset the stack for the current node
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        System.out.println(isCycle(graph) ? "Cycle Detected" : "No Cycle Detected");
    }
}

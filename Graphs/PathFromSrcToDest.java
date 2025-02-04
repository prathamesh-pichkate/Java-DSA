import java.util.ArrayList;

public class PathFromSrcToDest {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path, boolean[] visited) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        // Mark the current node as visited
        visited[src] = true;

        // Recursively call for all adjacent nodes
        for (Edge e : graph[src]) {
            if (!visited[e.dest]) { // Continue only if the node is unvisited
                printAllPaths(graph, e.dest, dest, path + src + " -> ", visited);
            }
        }

        // Backtrack: unmark the current node as visited
        visited[src] = false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // Call printAllPaths with a visited array to track visited nodes
        boolean[] visited = new boolean[V];
        printAllPaths(graph, 5, 1, "", visited);
    }
}

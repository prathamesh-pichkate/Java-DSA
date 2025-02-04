import java.util.*;

public class CheapestFlightWithKStops {
    static class Edge {
        int src;
        int dest;
        int wgt;

        public Edge(int src, int dest, int wgt) {
            this.src = src;
            this.dest = dest;
            this.wgt = wgt;
        }
    }

    public static void createGraph(int[][] flight, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flight) {
            int src = f[0];
            int dest = f[1];
            int wgt = f[2];

            graph[src].add(new Edge(src, dest, wgt));
        }
    }

    static class Info {
        int v;
        int wgt;
        int stop;

        public Info(int v, int wgt, int stop) {
            this.v = v;
            this.wgt = wgt;
            this.stop = stop;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stop > K) {
                continue;
            }

            for (Edge e : graph[curr.v]) {
                int v = e.dest;
                int newDist = curr.wgt + e.wgt;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    q.add(new Info(v, newDist, curr.stop + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flight = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dest = 3;
        int k = 1;

        int result = findCheapestPrice(n, flight, src, dest, k);
        System.out.println("Cheapest price: " + result);
    }
}

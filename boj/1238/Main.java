import java.util.*;
import java.io.*;

public class Main {
    
    public static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node (int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    static int N, M, X;
    static List<List<Node>> graph = new ArrayList<>();


    public static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));


        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int currentIdx = now.index;
            int currentDist = now.distance;

            if (currentDist > dist[currentIdx]) continue;

            for (Node other : graph.get(currentIdx)) {
                int newDist = dist[currentIdx] + other.distance;
                if (newDist < dist[other.index]) {
                    dist[other.index] = newDist;
                    pq.offer(new Node(other.index, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        int[] go = dijkstra(X);

        int maxTime = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int[] back = dijkstra(i);
            maxTime = Math.max(maxTime, go[i] + back[X]);
        }

        System.out.println(maxTime);
    }
}
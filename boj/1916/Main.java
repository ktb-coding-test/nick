import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph;
    static int[] dist;
    static boolean[] visited;

    public static void solution(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o1[1]);
        queue.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowV = now[0];
            int nowWeight = now[1];

            if (!visited[nowV]) {
                visited[nowV] = true;
                for (int[] next : graph.get(nowV)) {
                    int nextV = next[0];
                    int nextWeight = next[1];

                    if (dist[nextV] > dist[nowV] + nextWeight) {
                        dist[nextV] = dist[nowV] + nextWeight;
                        queue.offer(new int[]{nextV, dist[nextV]});
                    }
            }
            }
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<int[]>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<int[]>());
        }

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, weight});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        solution(start);

        System.out.println(dist[end]);

    }
}
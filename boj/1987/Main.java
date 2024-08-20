import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R;
    static int C;
    static char[][] graph;
    static boolean[][] visited;
    static Stack<Character> passedAlpha = new Stack<>();
    static int result = Integer.MIN_VALUE;

    static void dfs(int x, int y, int cnt) {
        result = Math.max(result, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                boolean isPassed = passedAlpha.contains(graph[nx][ny]);
                if (!isPassed) {
                    visited[nx][ny] = true;
                    passedAlpha.push(graph[nx][ny]);
                    dfs(nx, ny, cnt+1);
                    visited[nx][ny] = false;
                    passedAlpha.pop();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                graph[i][j] = row[j];
            }
        }

        passedAlpha.add(graph[0][0]);
        dfs(0, 0, 1);

        System.out.println(result);
    }
}
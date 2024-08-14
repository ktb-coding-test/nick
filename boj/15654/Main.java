import java.util.*;
import java.io.*;

public class Main {
    
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    
    public static void recursion(String str, int cnt) {
        
        if (cnt == M) {
            sb.append(str.trim() + "\n");
            return;
        }
        
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursion(str + arr[i] + " ", cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
      
        arr = new int[N];
        visited = new boolean[N];
      
        st = new StringTokenizer(br.readLine());
      
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
      
        recursion("", 0);
        
        bw.write(sb + "\n");
        bw.close();
      
    }
}
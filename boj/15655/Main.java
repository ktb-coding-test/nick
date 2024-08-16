import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    
    public static void recursion(int idx, int cnt, String str) {
        
        if (cnt == M) {
            sb.append(str.trim() + "\n");
            return;
        }
        
        if (idx >= N) return;
        
        recursion(idx+1, cnt+1, str + arr[idx] + " ");
        recursion(idx+1, cnt, str);
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        for (int i = 0; i < N; i++) {
            recursion(i+1, 1, arr[i]+" ");
        }
        
        bw.write(sb + "\n");
        bw.close();
      
    }
}
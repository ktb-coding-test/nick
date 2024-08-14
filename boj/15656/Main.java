import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void recursion(String str, int cnt) {
        
        if (cnt == M) {
            sb.append(str.trim() + "\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            recursion(str + arr[i] + " ", cnt+1);
        }
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
        
        recursion("", 0);
        
        bw.write(sb + "\n");
        bw.close();
        
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
    
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        int now = 0;
        int cnt = n - m;
        for (now = 0; now <= cnt; now++) {
            sb.append(now + " " + (now+1) + "\n");
        }
        
        for (now = now + 1; now < n; now++) {
            sb.append(1 + " " + now + "\n");
        }
    
        System.out.println(sb.toString().trim());
    }
}

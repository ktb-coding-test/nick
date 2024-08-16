import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static void lotto(int k, int idx, int[] arr, String str, int cnt) {
        if (cnt == 6) {
            sb.append(str.trim() + "\n");
            return;
        }

        if(idx >= k) return;

        lotto(k, idx + 1, arr, str + arr[idx] + " ", cnt + 1);
        lotto(k, idx + 1, arr, str, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            lotto(k, 0, arr, "", 0);
            sb.append("\n");
        }
        bw.write(sb + "\n");
        bw.close();
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] eggList;
    static int maxCnt = Integer.MIN_VALUE;

    static void recursion(int idx, int breakCnt) {

        if (idx >= N) {
            maxCnt = Math.max(maxCnt, breakCnt);
            return;
        }

        if (eggList[idx][0] <= 0 || breakCnt == N - 1) {
            recursion(idx+1, breakCnt);
            return;
        }


        for (int i = 0; i < N; i++) {
            if (eggList[i][0] > 0 && i != idx) {
                eggList[i][0] -= eggList[idx][1];
                eggList[idx][0] -= eggList[i][1];
                
                int nowBreakCnt = 0;
                if (eggList[i][0] <= 0) nowBreakCnt += 1;
                if (eggList[idx][0] <= 0) nowBreakCnt += 1;

                recursion(idx + 1, breakCnt + nowBreakCnt);

                eggList[i][0] += eggList[idx][1];
                eggList[idx][0] += eggList[i][1];
            } 
        }


        
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        eggList = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggList[i][0] = Integer.parseInt(st.nextToken());
            eggList[i][1] = Integer.parseInt(st.nextToken());
        }


        recursion(0, 0);

        bw.write(maxCnt + "\n");
        bw.close();
    }
}
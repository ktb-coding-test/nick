import java.util.*;
import java.io.*;

public class Main {

    static String result = null;
    static int N;

    static void recursion(int idx, int before, String nowStr) {

        if (idx >= N) {
            if (result == null || nowStr.compareTo(result) < 0) {
                result = nowStr;
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (nowStr.length() < 3 && before != i) {
                recursion(idx + 1, i, nowStr + i);
            }

            for (int k = 2; k < (nowStr.length() + 1) / 2 + 1; k++) {
                String right = nowStr.substring(idx - k + 1) + i;
                String left = nowStr.substring(idx - 2 * k + 1, idx - k + 1);
                if (right.equals(left)) {
                    continue;
                }
                if (before == i) {
                    continue;
                }
                recursion(idx + 1, i, nowStr + i);
            }
        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        recursion(1, 1, "1");

        bw.write(result + "\n");
        bw.close();
    }
}
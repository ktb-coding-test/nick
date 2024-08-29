import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static String answer = "";

    static void recursion(int idx, String nowStr) {

        if (idx >= N) {
            System.out.println(nowStr);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isPossible(nowStr + i)) {
                recursion(idx + 1, nowStr + i);
            }
            
        }

    }

    static boolean isPossible(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String right = str.substring(str.length() - i);
            String left = str.substring(str.length() - 2 * i, str.length() - i);
            if (right.equals(left)) return false;
        }
        return true;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        recursion(0, "");

        System.out.println(answer);
    }
}
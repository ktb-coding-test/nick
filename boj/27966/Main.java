import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());

        long minDist = (N - 1) + (N-1) * (N-2);

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            sb.append("1 " + i + "\n");
        }

        System.out.println(minDist);
        System.out.println(sb.toString().trim() + "\n");
    }
}
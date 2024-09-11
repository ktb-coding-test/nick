import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        while (true) {
            int now = Integer.parseInt(br.readLine());

            if (now == -1) {
                break;
            }

            if (now == 0) {
                queue.poll();
                continue;
            }

            if (queue.size() + 1 > N) {
                continue;
            }

            queue.offer(now);
        }
        if (queue.isEmpty()) {
            System.out.println("empty");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll() + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
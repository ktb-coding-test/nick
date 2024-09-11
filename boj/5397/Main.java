import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cursor = 0;
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            String str = br.readLine();

            for (char x : str.toCharArray()) {
                if (x == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (x == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                } else if (x == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(x);
                }
            }
            

            for (char x : list) {
                sb.append(x);
            }
            sb.append("\n");
            
        }
        
        System.out.println(sb);
    }
}
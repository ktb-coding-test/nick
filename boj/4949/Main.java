import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        while (true) {

            String str = br.readLine();
            
            if (str.length() == 1 && str.charAt(0) == '.') break;

            String isBalance = "yes";
            Stack<Character> stack = new Stack<>();

            for (char x : str.toCharArray()) {
                if (x == '[' || x == '(') {
                    stack.push(x);
                } else if (x == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalance = "no";
                    }
                } else if (x == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalance = "no";
                    }
                } else if (x == '.') {
                    if (!stack.isEmpty()) {
                        isBalance = "no";
                    }
                }  
            }
            sb.append(isBalance + "\n");
        }
        
        bw.write(sb + "\n");
        bw.close();

    }
}
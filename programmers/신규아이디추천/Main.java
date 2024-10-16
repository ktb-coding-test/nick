import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        StringBuilder sb = new StringBuilder();
        for (char x : new_id.toCharArray()) {
            if (x == '-' || x == '_' || x == '.') {
                sb.append(x);
            } else if (Character.isDigit(x) || Character.isAlphabetic(x)) {
                sb.append(x);   
            }
        }
        new_id = sb.toString();
        
        // 3단계
        sb = new StringBuilder();
        char before = ' ';
        for (char x : new_id.toCharArray()) {
            if (x == '.' && before == '.') continue;
            before = x;
            sb.append(x);
        }
        new_id = sb.toString();
        
        // 4단계
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        
        // 5단계
        if (new_id.equals("")) {
            new_id = "a";
        }
        
        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        if (new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 7단계
        if (new_id.length() <= 2) {
            sb = new StringBuilder();
            char last = new_id.charAt(new_id.length() - 1);
            for (int i = 0; i < 3 - new_id.length(); i++) {
                sb.append(last);
            }
            new_id = new_id + sb.toString();
        }
        
        return new_id;
    }
}
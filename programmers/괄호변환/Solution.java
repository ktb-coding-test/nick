import java.io.*;
import java.util.*;

class Solution {
    public boolean isCorrect(String str) {
        int leftCnt = 0;
        int rightCnt = 0;
        boolean result = true;
        
        for (char x: str.toCharArray()) {
            if (x == ')') {
                rightCnt++;
            } else if (x == '(') {
                leftCnt++;
            }
            
            if (leftCnt < rightCnt) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    
    public String solution(String p) {
        if (p.equals("")) return "";
        
        char[] charArr = p.toCharArray();
        int cutIdx = 0;
        int leftCnt = 0;
        int rightCnt = 0;
        
        // 자를 위치 찾기
        for (int i = 0; i < charArr.length; i++) {
            cutIdx++;
            if (charArr[i] == '(') {
                leftCnt++;
            } else if (charArr[i] == ')') {
                rightCnt++;
            }
            
            if (leftCnt == rightCnt) {
                break;
            }
        }
        
        String u = p.substring(0, cutIdx);
        String v = p.substring(cutIdx);
        
        // u가 올바르면 u에 v를 처음부터 돌린 결과를 합치기
        if (isCorrect(u)) return u + solution(v);
        
        // u가 올바르지 않으면
        String newStr = "(" + solution(v) + ")";
        // 문자열에 한글자씩 다 붙이는 것이므로 성능을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        
        for (char x : u.substring(1, u.length() - 1).toCharArray()) {
            if (x == '(') sb.append(')');
            else if (x == ')') sb.append('(');
        }
        
        return newStr + sb.toString();
        
    }
}
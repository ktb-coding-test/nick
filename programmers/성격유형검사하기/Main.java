import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            String nowSurvey = survey[i];
            int nowChoice = choices[i];

            if (nowChoice < 4) {
                char type = nowSurvey.charAt(0);
                map.put(type, map.get(type) + 4 - nowChoice );
            } else if (nowChoice > 4) {
                char type = nowSurvey.charAt(1);
                map.put(type, map.get(type) + nowChoice - 4);
            }
        }        
        
        StringBuilder sb = new StringBuilder();
        sb.append(map.get('R') >= map.get('T') ? "R" : "T");
        sb.append(map.get('C') >= map.get('F') ? "C" : "F");
        sb.append(map.get('J') >= map.get('M') ? "J" : "M");
        sb.append(map.get('A') >= map.get('N') ? "A" : "N");
        
        
        
        return sb.toString();
    }
}
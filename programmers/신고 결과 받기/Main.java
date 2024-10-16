import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 전체 신고를 중복 제거하고 map에 넣음
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> reportCntMap = new HashMap<>();


        for (String id : id_list) {
            map.put(id, new HashSet<>());
            reportCntMap.put(id, 0);
        }
        
        // 신고횟수를 기록한 reportCntMap
        for (String x : report) {
            String[] nowReport = x.split(" ");
            
            if (map.get(nowReport[0]).add(nowReport[1])) {
                reportCntMap.put(nowReport[1], reportCntMap.get(nowReport[1]) + 1);
            }
        }
        
        // 받은 메일 수를 기록
        for (int i = 0; i < id_list.length; i++) {
            String nowId = id_list[i];
            
            for (String key : reportCntMap.keySet()) {
                if (reportCntMap.get(key) >= k) {
                    if (map.get(nowId).contains(key)) {
                        answer[i]++;      
                    }
                }
            }
        }
        
        return answer;
    }
}
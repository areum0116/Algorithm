import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            map.replace(s, map.get(s) - 1);
            if(map.get(s) == 0) map.remove(s);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) answer = entry.getKey();
        }
        
        return answer;
    }
}
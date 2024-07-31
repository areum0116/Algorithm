import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        StringBuilder sb = new StringBuilder();
        int startIdx;
        int idx = 0;
        while (idx < s.length()) {
            if('a' <= s.charAt(idx) && s.charAt(idx) <= 'z') {
                startIdx = idx;
                for (int i = idx; i <= s.length(); i++) {
                    if(map.get(s.substring(startIdx, i)) != null) {
                        sb.append(map.get(s.substring(startIdx, i)));
                        idx = i;
                        break;
                    }
                }
            }
            else {
                sb.append(s.charAt(idx));
                idx++;
            }
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}
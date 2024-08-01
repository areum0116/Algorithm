import java.util.*;
class Solution {
    public String[] solution(String[] s, int n) {
        String[] answer = new String[s.length];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i].charAt(n) + s[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < s.length; i++) {
            answer[i] = list.get(i).substring(1);
        }
        return answer;
    }
}
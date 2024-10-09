import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            List<String> list = new ArrayList<>(hashMap.getOrDefault(clothes[i][1], new ArrayList<>(List.of("None"))));
            list.add(clothes[i][0]);
            hashMap.put(clothes[i][1], list);
        }

        for (List<String> value : hashMap.values()) {
            answer *= value.size();
        }
        return answer - 1;
    }
}
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> tmpMap = new HashMap<>(map);
            for (int j = i; j < i + 10; j++) {
                if(tmpMap.containsKey(discount[j])) {
                    tmpMap.put(discount[j], tmpMap.get(discount[j]) - 1);
                }
            }
            boolean isEmpty = true;
            for (Integer value : tmpMap.values()) {
                if(value > 0) {
                    isEmpty = false;
                    break;
                }
            }
            if(isEmpty)
                answer++;
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Arrays.sort(stages);
        int[] failure = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            failure[stages[i]]++;
        }
        int total = stages.length;
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (total == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) failure[i] / total);
                total -= failure[i];
            }
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        int idx = 0;
        for (Integer i : keySet) {
            answer[idx++] = i;
        }

        return answer;
    }
}
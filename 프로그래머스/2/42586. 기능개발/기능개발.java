import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int leftDates = (100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] != 0 ? 1 : 0);
            queue.add(leftDates);
        }
        int totalDates = 0;
        ArrayList<Integer> listAnswer = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (totalDates >= cur) {
                int index = listAnswer.size() - 1;
                listAnswer.set(index, listAnswer.get(index) + 1);
            } else {
                listAnswer.add(1);
                totalDates += cur - totalDates;
            }
        }
        answer = listAnswer.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
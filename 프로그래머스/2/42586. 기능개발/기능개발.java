import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int leftPercentage = 100 - progresses[i];
            int leftDays = (leftPercentage / speeds[i]) + (leftPercentage % speeds[i] == 0 ? 0 : 1);
            queue.add(leftDays);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int sum = 1;
        int value = queue.poll();
        while (!queue.isEmpty()) {
            int value2 = queue.poll();
            if(value >= value2) {
                sum++;
            } else {
                list.add(sum);
                value = value2;
                sum = 1;
            }
        }
        list.add(sum);

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
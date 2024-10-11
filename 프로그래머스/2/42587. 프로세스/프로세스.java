import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> sortedQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            sortedQueue.add(priorities[i]);
            queue.add(new int[] {i, priorities[i]});
        }

        HashMap<Integer, Integer> answerMap = new HashMap<>();
        int count = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(sortedQueue.peek() == poll[1]) {
                answerMap.put(poll[0], count++);
                sortedQueue.poll();
            } else {
                queue.add(poll);
            }
        }
        for (Map.Entry<Integer, Integer> entry : answerMap.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        answer = answerMap.get(location);
        return answer;
    }
}
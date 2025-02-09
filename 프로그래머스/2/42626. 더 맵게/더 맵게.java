import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : scoville) {
            queue.add(n);
        }
        while (queue.peek() < K) {
            if(queue.size() < 2) return -1;
            int fn = queue.poll();
            int sn = queue.poll();
            queue.add(fn + sn * 2);
            answer++;
        }
        return answer;
    }
}
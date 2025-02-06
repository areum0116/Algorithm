import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[1] == priorities[idx]) {
                idx--;
                answer++;
                if(poll[0] == location) break;
            } else {
                queue.add(poll);
            }
        }
        return answer;
    }
}
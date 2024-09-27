import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        
        for(int i = 0; i < answer.length; i++) {
            long row = (i + left) / n + 1;
            long col = (i + left) % n + 1;
            answer[i] = (int)Math.max(row, col);
        }
            
        return answer;
    }
}
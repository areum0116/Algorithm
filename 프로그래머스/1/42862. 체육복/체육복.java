import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] hasReverse = new boolean[n + 1];
        for (int r : reserve) {
            hasReverse[r] = true;
        }
        Arrays.sort(lost);
        for (int i = 0; i < lost.length; i++) {
            if (hasReverse[lost[i]]) {
                hasReverse[lost[i]] = false;
                lost[i] = -1;
                answer++;
            }
        }
        for (int l : lost) {
            if(l == -1) {
                continue;
            }
            if(l > 0 && hasReverse[l-1]) {
                hasReverse[l-1] = false;
                answer++;
            } else if(l < n && hasReverse[l+1]) {
                hasReverse[l+1] = false;
                answer++;
            }
        }
        return answer;
    }
}
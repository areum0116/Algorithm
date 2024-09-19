import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] countArr = new int[10000001];
        for (int t : tangerine) {
            countArr[t]++;
        }
        Arrays.sort(countArr);
        for (int i = countArr.length - 1; i >= 0; i--) {
            answer++;
            k -= countArr[i];
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}
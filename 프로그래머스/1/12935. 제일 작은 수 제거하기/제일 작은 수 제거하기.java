import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1) answer = new int[]{-1};
        else {
            answer = new int[arr.length - 1];
            int[] tmp = arr.clone();
            Arrays.sort(tmp);
            int idx = 0;
            for(int a : arr) {
                if(a == tmp[0]) continue;
                answer[idx++] = a;
            }
        }
        return answer;
    }
}
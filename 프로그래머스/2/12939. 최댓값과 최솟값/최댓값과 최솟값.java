import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");
        int[] intArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            intArr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(intArr);
        answer = intArr[0] + " " + intArr[split.length - 1];
        return answer;
    }
}
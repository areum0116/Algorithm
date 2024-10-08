import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] countX = new int[10];
        int[] countY = new int[10];
        for(char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        for(char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int minCnt = Math.min(countX[i], countY[i]);
            sb.append(String.valueOf(i).repeat(minCnt));
        }
        answer = sb.toString();
        if(answer.isEmpty()) return "-1";
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}
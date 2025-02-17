import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int len = number.length() - k;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < len; i++) {
            char biggest = '0';
            for (int j = start; j <= i + k; j++) {
                if (biggest < number.charAt(j)) {
                    biggest = number.charAt(j);
                    start = j + 1;
                }
            }
            sb.append(biggest);
        }
        answer = sb.toString();
        return answer;
    }
}
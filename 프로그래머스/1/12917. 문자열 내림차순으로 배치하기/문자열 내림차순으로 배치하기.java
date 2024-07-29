import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--)
            sb.append(charArr[i]);
        answer = sb.toString();
        return answer;
    }
}
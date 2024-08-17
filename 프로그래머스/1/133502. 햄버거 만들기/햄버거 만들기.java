import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ingredient.length; i++) {
            sb.append(ingredient[i]);
            int size = sb.length();
            if(size >= 4) {
                if(sb.charAt(size-4)=='1' && sb.charAt(size-3)=='2' && sb.charAt(size-2) == '3' && sb.charAt(size-1) == '1') {
                    answer++;
                    sb.delete(size-4, size);
                }
            }
        }
        return answer;
    }
}
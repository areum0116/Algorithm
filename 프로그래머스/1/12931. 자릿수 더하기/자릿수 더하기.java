import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String str_n = Integer.toString(n);
        char[] arr = str_n.toCharArray();
        int count = 0;
        for (char c : arr) {
            count += c - '0';
        }

        /*
        * int -> char array
        * char[] chars = ("" + i).toCharArray();
        * or
        * char[] chars = String.valueOf(i).toCharArray();
        */
        
        return count;
    }
}

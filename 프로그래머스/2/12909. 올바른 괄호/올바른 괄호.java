import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            if(c == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            else stack.push(c);
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
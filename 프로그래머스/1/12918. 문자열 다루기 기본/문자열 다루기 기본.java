class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;
        for (int i = 0; i < s.length(); i++) {
            if('a' <= s.charAt(i) && s.charAt(i) <= 'z' || 'A' <= s.charAt(i) && s.charAt(i) <= 'Z')
                return false;
        }
        return true;
    }
}
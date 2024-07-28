class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        char[] charArr = (x + "").toCharArray();
        int sum = 0;
        for(char c : charArr) {
            sum += c - '0';
        }
        if(x % sum != 0) answer = false;
        
        return answer;
    }
}
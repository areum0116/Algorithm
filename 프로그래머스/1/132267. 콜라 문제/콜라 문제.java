class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int bottleNum = (n / a) * b;
            answer += bottleNum;
            n = n % a + bottleNum;
        }
        return answer;
    }
}
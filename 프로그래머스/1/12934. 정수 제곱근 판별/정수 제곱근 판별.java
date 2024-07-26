class Solution {
    public long solution(long n) {
        long answer = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if((long)i * i == n) {
                answer = (long) (i + 1) * (i + 1);
                return answer;
            }
        }
        return -1;
    }
}
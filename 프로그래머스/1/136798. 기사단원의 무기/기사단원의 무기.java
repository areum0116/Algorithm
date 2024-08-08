
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int factor = getFactor(i);
            if (factor > limit) answer += power;
            else answer += factor;
        }
        return answer;
    }
    static int getFactor(int num) {
        int result = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if(i * i == num) result += 1;
            else if(num % i == 0) result += 2;
        }
        return result;
    }
}
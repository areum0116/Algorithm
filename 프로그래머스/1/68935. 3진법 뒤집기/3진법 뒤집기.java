class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.append(n % 3);
            n /= 3;
        }
        int idx = 0;
        for (int i = sb.length()-1; i >= 0; i--) {
            answer += (int) Math.pow(3, idx++) * (sb.charAt(i) - '0');
        }
        return answer;
    }
}
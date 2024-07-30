class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long int_p = Long.parseLong(p);
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            long int_t = Long.parseLong(t.substring(i, i+p.length()));
            if(int_t <= int_p) answer++;
        }
        return answer;
    }
}
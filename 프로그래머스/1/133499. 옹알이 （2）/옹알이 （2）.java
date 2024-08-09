class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] available = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            String s = babbling[i];
            if(s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) {
                continue;
            }
            for (String ava : available) {
                s = s.replace(ava, " ");
            }
            if(s.replace(" ", "") == "") answer++;
        }
        return answer;
    }
}
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char firstLetter = s.charAt(i);
            int firstCnt = 0, othersCnt = 0;
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(j) == firstLetter) firstCnt++;
                else othersCnt++;
                if(firstCnt == othersCnt) {
                    
                    i = j;
                    break;
                }
                if(j == s.length() - 1) i = j;
            }
            answer++;
        }
        return answer;
    }
}
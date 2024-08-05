class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < goal.length; i++) {
            if(idx1 < cards1.length && goal[i].equals(cards1[idx1]))
                idx1++;
            else if(idx2 < cards2.length && goal[i].equals(cards2[idx2]))
                idx2++;
        }
        if(idx1+idx2 == goal.length) answer = "Yes";
        else answer = "No";
        return answer;
    }
}
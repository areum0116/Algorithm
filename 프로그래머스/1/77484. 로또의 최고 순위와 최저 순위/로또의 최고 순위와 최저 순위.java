class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int winCnt = 0;
        int zeroCnt = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(win_nums[i] == lottos[j]) winCnt++;
            }
            if(lottos[i] == 0) zeroCnt++;
        }
        answer[0] = 7 - (winCnt + zeroCnt);
        answer[1] = 7 - winCnt;
        if(answer[0] == 7) answer[0] = 6;
        if(answer[1] == 7) answer[1] = 6;

        return answer;
    }
}
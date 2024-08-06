import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if(first[i % first.length] == answers[i]) scores[0]++;
            if(second[i % second.length] == answers[i]) scores[1]++;
            if(third[i % third.length] == answers[i]) scores[2]++;
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if(max < scores[i])
                max = scores[i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(max == scores[i])
                list.add(i+1);
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
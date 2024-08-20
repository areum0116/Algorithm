import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> scoreByType = new HashMap<>();
        int[] scoreByChoice = {0, 3, 2, 1, 0, 1, 2, 3};

        for (int i = 0; i < survey.length; i++) {
            int type = choices[i] < 4 ? 0 : 1;
            scoreByType.put(survey[i].charAt(type), scoreByType.getOrDefault(survey[i].charAt(type), 0) + scoreByChoice[choices[i]]);
        }

        if(scoreByType.getOrDefault('R', 0) >= scoreByType.getOrDefault('T', 0)) answer += 'R';
        else answer += 'T';
        if(scoreByType.getOrDefault('C', 0) >= scoreByType.getOrDefault('F', 0)) answer += 'C';
        else answer += 'F';
        if(scoreByType.getOrDefault('J', 0) >= scoreByType.getOrDefault('M', 0)) answer += 'J';
        else answer += 'M';
        if(scoreByType.getOrDefault('A', 0) >= scoreByType.getOrDefault('N', 0)) answer += 'A';
        else answer += 'N';
        return answer;
    }
}
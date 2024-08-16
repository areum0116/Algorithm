import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                int min = 999999999;
                boolean findKey = false;
                for (int k = 0; k < keymap.length; k++) {
                    int keyIdx = keymap[k].indexOf(targets[i].charAt(j));
                    if(keyIdx == -1) continue;
                    min = Math.min(min, keyIdx + 1);
                    findKey = true;
                }
                if(findKey)
                    answer[i] += min;
                else {
                    answer[i] = 0;
                    break;
                }
            }
            if(answer[i] == 0) answer[i] = -1;
        }
        return answer;
    }
}
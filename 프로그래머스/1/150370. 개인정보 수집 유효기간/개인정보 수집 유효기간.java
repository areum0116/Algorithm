import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }

        String[] split = today.split("\\.");
        int[] todayInt = new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])};

        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            String[] pDate = p[0].split("\\.");
            int[] pDateInt = new int[]{Integer.parseInt(pDate[0]), Integer.parseInt(pDate[1]), Integer.parseInt(pDate[2])};
            pDateInt[1] += map.get(p[1]);
            if(pDateInt[1] > 12) {
                pDateInt[0] += pDateInt[1] / 12;
                pDateInt[1] %= 12;
            }
            if(--pDateInt[2] == 0) {
                pDateInt[1]--;
                pDateInt[2] = 28;
            }
            if(pDateInt[1] == 0) {
                pDateInt[0]--;
                pDateInt[1] = 12;
            }

            if(todayInt[0] > pDateInt[0])
                answerList.add(i + 1);
            else if(todayInt[0] == pDateInt[0]) {
                if(todayInt[1] > pDateInt[1])
                    answerList.add(i + 1);
                else if(todayInt[1] == pDateInt[1] && todayInt[2] > pDateInt[2])
                    answerList.add(i + 1);
            }
        }

        answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
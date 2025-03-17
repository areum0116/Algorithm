import java.util.*;

class Solution {
    public int lowerBound(ArrayList<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if(arr.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public int upperBound(ArrayList<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if(arr.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [leftValue, rightValue]인 데이터의 개수 반환
    public int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
        int rightIdx = upperBound(arr, rightValue, 0, arr.size());
        int leftIdx = upperBound(arr, leftValue, 0, arr.size());
        return rightIdx - leftIdx;
    }

    public ArrayList<ArrayList<String>> arr = new ArrayList<>();
    public ArrayList<ArrayList<String>> reverseArr = new ArrayList<>();
    
    public int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            arr.get(word.length()).add(word);   // 단어를 삽입
            word = (new StringBuffer(word)).reverse().toString();
            reverseArr.get(word.length()).add(word);    // 단어를 뒤집어서 삽입
        }

        for (int i = 0; i < 10001; i++) {
            Collections.sort(arr.get(i));
            Collections.sort(reverseArr.get(i));
        }

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int res = 0;
            if (q.charAt(0) != '?') {
                res = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            } else {
                q = (new StringBuffer(q)).reverse().toString();
                res = countByRange(reverseArr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            }
            ans.add(res);
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
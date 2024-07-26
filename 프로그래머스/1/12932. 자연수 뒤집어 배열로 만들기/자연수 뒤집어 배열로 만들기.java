class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        char[] char_arr = Long.toString(n).toCharArray();
        answer = new int[char_arr.length];
        int idx = 0;
        for (int i = char_arr.length-1; i >= 0; i--) {
            answer[idx] = char_arr[i] - '0';
            idx++;
        }
        return answer;
    }
}
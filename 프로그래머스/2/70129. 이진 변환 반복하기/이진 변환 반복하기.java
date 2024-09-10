class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int removed0 = 0;
        int count = 0;

        while(!s.equals("1")) {
            int len = s.replace("0", "").length();
            removed0 += s.length() - len;
            StringBuilder sb = new StringBuilder();
            while(len > 0) {
                sb.append(len % 2);
                len /= 2;
            }
            s = sb.reverse().toString();
            count++;
        }
        answer = new int[]{count, removed0};
        return answer;
    }
}
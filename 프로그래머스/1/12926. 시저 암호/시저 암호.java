class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append(' ');
            }
            else {
                char c = s.charAt(i);
                for (int j = 0; j < n; j++) {
                    if(c == 'z') {
                        c = 'a';
                    }
                    else if(c == 'Z') {
                        c = 'A';
                    }
                    else {
                        c += 1;
                    }
                }
                sb.append(c);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
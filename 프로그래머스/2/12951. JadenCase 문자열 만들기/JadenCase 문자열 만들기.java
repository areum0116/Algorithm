class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                isFirst = true;
                sb.append(s.charAt(i));
                continue;
            }
            if(isFirst) {
                sb.append(Character.toUpperCase(s.charAt(i)));
                isFirst = false;
                continue;
            }
            sb.append(Character.toLowerCase(s.charAt(i)));
        }
        answer = sb.toString();
        return answer;
    }
}
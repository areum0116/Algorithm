class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            for (int j = 0; j < index; j++) {
                if(tmp == 'z') tmp = 'a';
                else tmp = (char)(tmp + 1);

                if(skip.indexOf(tmp) != -1) j--;
            }
            sb.append(tmp);
        }
        answer = sb.toString();
        return answer;
    }
}
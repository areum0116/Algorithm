class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(phone_number.length()-4)).append(phone_number.substring(phone_number.length()-4));
        answer = sb.toString();
        return answer;
    }
}
import java.time.LocalDate;
class Solution {
    private String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    public String solution(int a, int b) {
        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);
        int dayOfWeek = date.getDayOfWeek().ordinal();
        answer = week[dayOfWeek];
        return answer;
    }
}
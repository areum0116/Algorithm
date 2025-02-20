import java.util.*;

class Solution {
    public int solution(String s) {
        int minLength = s.length(); // 초기값: 압축하지 않은 문자열 길이

        for (int k = 1; k <= s.length() / 2; k++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, k); // 첫 번째 블록
            int count = 1;

            for (int i = k; i <= s.length(); i += k) {
                String curr = (i + k <= s.length()) ? s.substring(i, i + k) : s.substring(i);

                if (prev.equals(curr)) {
                    count++; // 동일 블록 반복 카운트 증가
                } else {
                    if (count > 1) compressed.append(count);
                    compressed.append(prev);
                    prev = curr;
                    count = 1;
                }
            }

            compressed.append(prev); // 마지막 문자열 추가
            minLength = Math.min(minLength, compressed.length()); // 최소 길이 갱신
        }

        return minLength;
    }
}

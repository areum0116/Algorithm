import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 몸무게 정렬
        int left = 0, right = people.length - 1;
        int answer = 0;

        while (left <= right) { // 왼쪽과 오른쪽이 만나기 전까지 반복
            if (people[left] + people[right] <= limit) { 
                left++; // 가벼운 사람 태우기
            }
            right--; // 무거운 사람은 항상 태움
            answer++; // 보트 사용
        }

        return answer;
    }
}

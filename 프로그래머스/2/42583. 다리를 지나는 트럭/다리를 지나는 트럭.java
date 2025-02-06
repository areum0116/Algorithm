import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int totalWeight = 0;
        int answer = 0;

        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true) {
                if(queue.isEmpty()) {
                    queue.add(truck);
                    totalWeight += truck;
                    answer++;
                    break;
                } else if(queue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우
                    totalWeight -= queue.poll();
                } else  { // 다리 길이만큼 큐가 차지않았음
                    // weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                    if(totalWeight + truck <= weight) {
                        queue.add(truck);
                        totalWeight += truck;
                        answer++;
                        break;
                    } else {
                        // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }

        // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야하기에 + 다리 길이
        return answer + bridge_length;
    }
}
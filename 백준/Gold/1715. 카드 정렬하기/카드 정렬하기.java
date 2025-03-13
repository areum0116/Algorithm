import java.util.*;


class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }
        int answer = 0;
        while (pq.size() > 1) {
            Integer n1 = pq.poll();
            Integer n2 = pq.poll();
            pq.add(n1 + n2);
            answer += n1 + n2;
        }
        System.out.println(answer);
    }
}

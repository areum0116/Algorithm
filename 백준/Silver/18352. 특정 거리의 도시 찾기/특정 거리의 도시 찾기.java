import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] A = new ArrayList[N+1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }

        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(X);
        visited[X] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : A[now]) {
                if(!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    distance[i] = distance[now] + 1;
                }
            }
        }
        boolean isAnswer = false;
        for (int i = 1; i <= N; i++) {
            if(distance[i] == K){
                System.out.println(i);
                isAnswer = true;
            }
        }
        if(!isAnswer) System.out.println(-1);
    }
}

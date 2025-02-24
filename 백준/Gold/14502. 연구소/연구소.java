import java.util.*;

public class Main {

    private static int[][] lab;
    private static int N, M;

    public static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] tmpLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpLab[i][j] = lab[i][j];
                if (lab[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(tmpLab[nx][ny] == 0) {
                    tmpLab[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return countSafeArea(tmpLab);
    }

    public static int countSafeArea(int[][] arr) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) safeArea++;
            }
        }
        return safeArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lab = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab[i][j] = sc.nextInt();
            }
        }

        List<int[]> position = new ArrayList<>();
        // 2차원 좌표를 1차원 리스트로 변환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                position.add(new int[]{i, j});
            }
        }
        int total = position.size();
        int answer = 0;
        for (int a = 0; a < total; a++) {
            for (int b = a + 1; b < total; b++) {
                for (int c = b + 1; c < total; c++) {
                    int[] p1 = position.get(a);
                    int[] p2 = position.get(b);
                    int[] p3 = position.get(c);
                    if(lab[p1[0]][p1[1]] != 0 || lab[p2[0]][p2[1]] != 0 || lab[p3[0]][p3[1]] != 0) continue;
                    lab[p1[0]][p1[1]] = 1;
                    lab[p2[0]][p2[1]] = 1;
                    lab[p3[0]][p3[1]] = 1;
                    int bfs = BFS();
                    answer = Math.max(answer, bfs);
                    lab[p1[0]][p1[1]] = 0;
                    lab[p2[0]][p2[1]] = 0;
                    lab[p3[0]][p3[1]] = 0;
                }
            }
        }
        System.out.println(answer);
    }
}
import java.util.*;

class Main {
    static int n, l, r;
    static int[][] A;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        A = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        while (true) {
            boolean[][] visited = new boolean[n][n];
            boolean moved = false; // 인구 이동 발생 여부 체크

            // 모든 좌표에 대해 BFS 수행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> list = new ArrayList<>();
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                        list.add(new int[]{i, j});
                        int peopleCnt = A[i][j]; // 첫 나라의 인구 포함

                        // BFS 수행
                        while (!queue.isEmpty()) {
                            int[] now = queue.poll();
                            int x = now[0], y = now[1];

                            for (int d = 0; d < 4; d++) {
                                int nx = x + dx[d];
                                int ny = y + dy[d];

                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                                if (visited[nx][ny]) continue;

                                int diff = Math.abs(A[x][y] - A[nx][ny]);
                                if (diff >= l && diff <= r) {
                                    queue.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                    list.add(new int[]{nx, ny});
                                    peopleCnt += A[nx][ny];
                                }
                            }
                        }

                        // 연합이 2개 이상인 경우 인구 이동 수행
                        if (list.size() > 1) {
                            moved = true;
                            int newPeople = peopleCnt / list.size();
                            for (int[] pos : list) {
                                A[pos[0]][pos[1]] = newPeople;
                            }
                        }
                    }
                }
            }

            // 인구 이동이 발생하지 않으면 종료
            if (!moved) break;
            answer++;
        }

        System.out.println(answer);
    }
}

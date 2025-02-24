import java.util.*;

class Virus implements Comparable<Virus> {
    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public int getSecond() {
        return second;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 정렬 기준 : 번호가 낮은 순서
    @Override
    public int compareTo(Virus o) {
        return this.index - o.index;
    }
}

public class Main {

    public static int n, k;
    public static int[][] graph = new int[200][200];
    public static ArrayList<Virus> viruses = new ArrayList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] != 0)
                    // (바이러스 종류, 시간, 위치 X, 위치 Y) 삽입
                    viruses.add(new Virus(graph[i][j], 0, i, j));
            }
        }
        
        // 정렬 이후에 큐로 옮기기 (낮은 번호의 바이러스가 먼저 증식하므로)
        Collections.sort(viruses);
        Queue<Virus> queue = new LinkedList<>();
        for (int i = 0; i < viruses.size(); i++) {
            queue.offer(viruses.get(i));
        }
        
        int S = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();
            // 정확히 second 만큼 초가 지나거나, 큐가 빌 때까지 반복
            if(virus.getSecond() == S) break;
            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virus.getIndex();
                        queue.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                    }
                }
            }
        }
        System.out.println(graph[X-1][Y-1]);
    }
}
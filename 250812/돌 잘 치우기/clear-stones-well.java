import java.util.Scanner;
import java.util.*;

class Pair {
    int y, x;
    public Pair(int y, int x) {
        this.x = x;
        this.y = y;
    }
}


public class Main {
    public static final int MAX_N = 100;
    public static final int[] dy = {-1, 0, 1, 0};
    public static final int[] dx = {0, 1, 0, -1};

    public static int n, k, m;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static Pair[] startPoints;

    public static int max;

    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static List<Pair> stones = new ArrayList<>();

    public static boolean inRange(int y, int x) {
        return 0<=x&&x<n && 0<=y&&y<n;
    } 

    public static boolean canGo(int y, int x) {
        return inRange(y, x) && grid[y][x] == 0 && !visited[y][x];
    }

    public static void removeStone(int depth, int idx) {
        if (depth == m) {
            // k개의 시작점에서 탐색

            // 탐색을 위한 방문 여부 체크 배열 초기화
            visited = new boolean[n][n]; 
            for(int i=0;i<k;i++) {
                bfs(startPoints[i].y, startPoints[i].x);
            }

            // 최댓값 갱신
            int result = 0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if (visited[i][j]) {
                        result++;
                    }
                }
            }
            max = Math.max(result, max);
            
            return;
        }

        // 다음 돌 없으면 재귀 종료        
        if (idx >= stones.size()) {
            return;
        }

        int y = stones.get(idx).y;
        int x = stones.get(idx).x;
        
        // 돌 치우고 탐색
        grid[y][x] = 0;
        removeStone(depth+1, idx+1);
        // 돌 안치우고 탐색
        grid[y][x] = 1;
        removeStone(depth, idx+1);
    }

    public static void bfs(int y, int x) {
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(y, x));
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0;i<4;i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (canGo(ny, nx)) {
                    queue.offer(new Pair(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    // public static 
    // public static 
    // public static 
    // public static 
    // public static 
    // public static 

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        
        grid = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    stones.add(new Pair(i,j));
                }
            }
        }
        
        startPoints = new Pair[k];

        for (int i = 0; i < k; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            startPoints[i] = new Pair(y, x);
        }

        removeStone(0, 0);

        System.out.println(max);
    }
}
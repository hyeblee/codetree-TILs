import java.util.Scanner;
import java.util.*;

// 1. 치울 돌 m개를 선택한다.
// 2. m개를 선택했으면, 모든 시작점에서 탐색을 진행한다.
// 3. 모든 시작점에서 탐색이 끝나면, 최댓값을 갱신한다.

// int[][] grid;
// Pair[] startPoints;
// List<Pair> stones; // 돌 위치

class Pair {
    int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    public static final int[] dy = {-1,0,1,0};
    public static final int[] dx = {0,1,0,-1};
    
    public static int n, m, k; 
    
    public static int[][] grid;
    public static boolean[][] visited;
    public static Pair[] startPoints;
    public static int max = 0; // 정답 최댓값
    
    public static List<Pair> stones = new ArrayList<>();
    
    public static boolean inRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<n;
    }

    public static void bfs(int y, int x) {
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(y, x));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0;i<4;i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (inRange(ny, nx) && !visited[ny][nx] && grid[ny][nx] == 0) {
                    queue.offer(new Pair(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    public static void removeStone(int depth, int idx) {
        if (depth == m) {
            
            visited = new boolean[n][n];
            for(int i=0;i<k;i++) {
                bfs(startPoints[i].y, startPoints[i].x);
            }

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

        if (idx >= stones.size()) {
            return;
        }

        int y = stones.get(idx).y;
        int x = stones.get(idx).x;
        
        // 돌 치우고 다음 탐색
        grid[y][x] = 0;
        removeStone(depth+1, idx + 1);

        // 돌 안치우고 다음 탐색
        grid[y][x] = 1;
        removeStone(depth, idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    stones.add(new Pair(i, j));
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
        // Please write your code here.
    }
}
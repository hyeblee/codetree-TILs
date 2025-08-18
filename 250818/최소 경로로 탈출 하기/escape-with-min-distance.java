import java.util.*;

public class Main {
    public static int n, m; 
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};

    public static class Pair{
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    } 
    public static boolean isInRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<m;
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
                if (!isInRange(ny, nx)) {
                    continue;
                }

                if (!visited[ny][nx] && grid[ny][nx]!=0) {
                    grid[ny][nx] = grid[cur.y][cur.x] + 1;
                    visited[ny][nx] = true;
                    queue.offer(new Pair(ny, nx));
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        bfs(0,0);
        int result = grid[n-1][m-1];
        if (result == 1) {
            System.out.println("-1");
        } else {
            System.out.println(result-1);
        }
        // Please write your code here.
    }
}
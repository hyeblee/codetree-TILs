import java.util.*;
public class Main {
    public static int n, r1, c1, r2, c2; 
    public static int[][] grid;
    public static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static boolean inRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<n;
    }
    public static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    public static int[] dy = {-1,-2,-2,-1,1,2,2,1};
    public static void bfs() {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(r1,c1));
        grid[r1][c1] = 1;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0;i<8;i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(!inRange(ny,nx)) {
                    continue;
                }
                if (grid[ny][nx]==0) {
                    grid[ny][nx] = grid[cur.y][cur.x]+1;
                    queue.offer(new Pair(ny, nx));
                }
            }
        }
    }
    // public static 


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;
        bfs();
        int result = grid[r2][c2];
        if (result==0) {
            System.out.println("-1");
        } else {
            System.out.println(result-1);
        }
        // Please write your code here.
    }
}
import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};
    
    public static int n, m;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int canEscape = 0;

    public static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static boolean inRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<m;
    }

    public static void BFS(int y, int x) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y,x));

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.y==n-1 && cur.x==m-1) {
                canEscape = 1;
                return;
            }

            

            visited[cur.y][cur.x] = true;
            
            for (int i=0;i<4;i++) {
                int curY = cur.y+dy[i];
                int curX = cur.x+dx[i];
                if (!inRange(curY, curX)|| grid[curY][curX]==0)
                    continue;
                if (!visited[curY][curX])
                    queue.offer(new Node(curY, curX));
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
        // Please write your code here.
        BFS(0,0);
        System.out.println(canEscape);
    }
}
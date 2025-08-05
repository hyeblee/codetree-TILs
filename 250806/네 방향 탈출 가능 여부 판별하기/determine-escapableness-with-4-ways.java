import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};
    
    public static int n, m;
    public static int[][] grid;
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

            grid[cur.y][cur.x] = -1;
            
            for (int i=0;i<4;i++) {
                int curY = cur.y+dy[i];
                int curX = cur.x+dx[i];
                if (!inRange(curY, curX)|| grid[curY][curX]==0)
                    continue;
                if (grid[curY][curX]!=-1)
                    queue.offer(new Node(curY, curX));
            }
        }

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
        // Please write your code here.
        BFS(0,0);
        System.out.println(canEscape);
    }
}
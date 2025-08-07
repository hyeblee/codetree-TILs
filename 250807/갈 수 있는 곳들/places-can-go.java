import java.util.Scanner;
import java.util.*;
public class Main {
    // bfs는 큐에 넣어주고 방문표시한다.
    // 그래야 중복으로 넣는 것 방지
    public static int n, k;
    // 이동할 수 있으면 0, 방문했으면(카운팅에 포함 할거면) -1, 아예못가면 1
    public static int[][] grid;
    public static boolean[][] visited;
    
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static boolean inRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<n;
    }

    public static void bfs(int y, int x) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y, x));
        visited[y][x] = true;
            
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            grid[cur.y][cur.x] = -1;
            for(int i=0;i<4;i++) {
                int newY = cur.y+dy[i];
                int newX = cur.x+dx[i];
                if (!inRange(newY, newX)) {
                    continue;
                }
                if (!visited[newY][newX] && grid[newY][newX]!=1) {
                    visited[newY][newX] = true;
                    queue.offer(new Node(newY, newX));
                }
            }
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt();
            starts[i][1] = sc.nextInt();
            if (grid[starts[i][0]-1][starts[i][1]-1] == 1)
                continue;
            visited = new boolean[n][n];
            bfs(starts[i][0]-1, starts[i][1]-1);
        }

        int result = 0;
         for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==-1)
                    result++;
            }
        // Please write your code here.
        System.out.println(result);
    }

}
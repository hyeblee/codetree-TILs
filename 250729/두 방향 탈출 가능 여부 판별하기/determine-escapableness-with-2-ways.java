import java.util.*;
public class Main {
    public static int[] dx = {0,1};
    public static int[] dy = {+1,0};
    public static int n, m;
    public static int[][] grid;
    public static boolean[][] visited;
    public static boolean isPossible;

    public static boolean isInRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<m;
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        if (y==n-1 && x==m-1) {
            // System.out.println(y+", "+x);
            isPossible = true;
            return;
        }
        if(isPossible)
            return;

        for(int i=0;i<2;i++){
            int curY = y+dy[i];
            int curX = x+dx[i];
            if(!isPossible && isInRange(curY,curX) && !visited[curY][curX] && grid[curY][curX]==1) {
                dfs(curY,curX);
            }
        }
    }
    


    public static void main(String[] args) {
        // Please write your code here
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        dfs(0,0);

        if (isPossible) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
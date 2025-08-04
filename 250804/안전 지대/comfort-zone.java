import java.util.Scanner;
import java.util.*;
public class Main {
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static int n,m;
    public static int[][] grid;
    public static boolean[][]visited;
    
    public static int safeArea = 0;
    public static int maxSafeArea = 0;
    public static int maxK = 0;

    public static boolean inRange(int y, int x) {
        return 0<=y && y < n && 0<= x && x<m;
    }
    public static void dfs(int y, int x, int k) {
        visited[y][x] = true;

        for(int i=0;i<4;i++){
            int curY = y+dy[i];
            int curX = x+dx[i];
            
            if (!inRange(curY, curX)) {
                continue;
            }

            if (!visited[curY][curX] && grid[curY][curX] > k) {
                dfs(curY,curX, k);
            }


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                // System.out.print(grid[i][j]+" ");
                max = Math.max(grid[i][j],max);
            }
            // System.out.println();
        }
        // System.out.println(max);
        for(int t=1;t<=max;t++) {
            visited = new boolean[n][m];
            safeArea = 0;
            for(int i=0;i<n;i++){
                // System.out.println("================");
                for(int j=0;j<m;j++){
                    if (!visited[i][j] && grid[i][j] > t) {
                        dfs(i,j, t);
                        safeArea++;
                    }
                }
            }
            if (safeArea > maxSafeArea){
                maxSafeArea = safeArea;
                maxK = t;
            }
        }
        System.out.println(maxK + " "+maxSafeArea);
    }
}
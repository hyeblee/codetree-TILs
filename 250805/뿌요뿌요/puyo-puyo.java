import java.util.*;
import java.util.Scanner;

public class Main {
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};
    
    public static int n;
    public static int blockSize = 0;
    public static int maxSize = 0;
    public static int bombedBlock = 0;

    public static int[][] grid;
    public static boolean visited[][];

    public static boolean inRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<n;
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        blockSize++;

        for(int i=0;i<4;i++) {
            int curY = y+dy[i];
            int curX = x+dx[i];
            if (!inRange(curY, curX)){
                continue;
            }
            if (!visited[curY][curX] && grid[curY][curX]==grid[y][x]) {
                dfs(curY,curX);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]) {
                    blockSize = 0;
                    dfs(i,j);
                    if (blockSize >= 4)
                        bombedBlock++;
                    maxSize = Math.max(maxSize, blockSize);
                }
            }
        }

        System.out.println(bombedBlock+" "+maxSize);
        // 터지게 되는 블럭 영역 갯수, 가장 큰 블럭의 크기 출력
    }
}
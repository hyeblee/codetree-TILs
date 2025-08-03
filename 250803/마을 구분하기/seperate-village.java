import java.util.Scanner;
import java.util.*;

public class Main {
    // 위에서부터 시계방향
    public static final int[] dx = {0,1,0,-1};
    public static final int[] dy = {-1,0,1,0};
    public static boolean[][] visited;
    public static int[][] grid;
    public static int n;
    
    public static List<Integer> list = new ArrayList<>();
    public static int town;
    public static int people;

    public static boolean isInRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<n;
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        people++;
        for(int i=0;i<4;i++) {
            int curY = y + dy[i];
            int curX = x + dx[i];
            if (!isInRange(curY,curX)){
                continue;
            }
            if (!visited[curY][curX] && grid[curY][curX]==1) {
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
                if (!visited[i][j] && grid[i][j]==1) {
                    people = 0;
                    town++;
                    dfs(i,j);
                    int tmp = people;
                    list.add(tmp);
                }
            }
        }
        System.out.println(town);
        Collections.sort(list);
        for(int v: list){
            System.out.println(v);
        }
        // Please write your code here.
    }
}
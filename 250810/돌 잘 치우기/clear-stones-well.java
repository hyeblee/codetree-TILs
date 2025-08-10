import java.util.Scanner;
import java.util.*;
public class Main {
    public static int n, m, k;
    public static boolean[][] visited;
    public static int[][] grid;
    public static int[][] startPoints;
    public static List<int[]> stones = new ArrayList<>();
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};
    public static int max = 0;
    public static Queue<int[]> queue = new ArrayDeque<>();

    public static boolean inRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<n;
    }
    public static void removeStone(int depth, int idx) {
        if (depth==m) {
            // 모든 시작점에 대해 탐색한다. -> 모든 시작점을 큐에 넣고 탐색한다.
            visited = new boolean[n][n];
            for(int i=0;i<k;i++) {
                visited[startPoints[i][0]][startPoints[i][1]] = true;
                queue.offer(startPoints[i]);
            }
            bfs();
            // 갯수세서 max 갱신하기;
            int cnt = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {
                    if (visited[i][j]) {
                        cnt++;
                    }
                }
            }
            max = Math.max(cnt,max);
            return;
        }
        if (idx >= stones.size()) {
            return;
        }
        
        // 돌을 치우고 다음 조합을 구한다.
        int[] targetStone = stones.get(idx);
        grid[targetStone[0]][targetStone[1]] = 0;
        removeStone(depth+1, idx+1);
        // 돌을 치우지 않고 다음 조합을 구한다.
        grid[targetStone[0]][targetStone[1]] = 1;
        removeStone(depth, idx+1);
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0;i<4;i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (!inRange(ny,nx) || visited[ny][nx]) {
                    continue;
                }
                if (grid[ny][nx]==0) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny,nx});
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j]==1) {
                    stones.add(new int[]{i,j});
                }
            }
        }
       startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt()-1;
            startPoints[i][1] = sc.nextInt()-1;
        }

        // m개 돌 치운 조합을 구한다.
        // 각 조합에 대하여, 모든 출발점에서 방문가능한 전체 칸 수를 구한다.
        // 한 조합이 끝나면, visited와 removed는 fasle로 초기화
        removeStone(0,0);
        System.out.println(max);
    }
}
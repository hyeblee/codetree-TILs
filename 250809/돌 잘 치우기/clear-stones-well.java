import java.util.*;

public class Main {
    public static int n, k, m;
    public static int[][] grid;
    public static boolean[][] visited;
    public static List<int[]> rock = new ArrayList<>();
    public static int[][] startPoints;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int max = 0;

    public static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    // 돌 m개 치우는 조합 생성
    public static void getCombination(int depth, int idx) {
        if (depth == m) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += bfs(startPoints[i][0], startPoints[i][1]);
            }
            max = Math.max(max, cnt);
            return;
        }
        if (idx >= rock.size()) return;

        int[] targetRock = rock.get(idx);
        grid[targetRock[0]][targetRock[1]] = 0; // 돌 제거
        getCombination(depth + 1, idx + 1);
        grid[targetRock[0]][targetRock[1]] = 1; // 원상복구
        getCombination(depth, idx + 1);
    }

    public static int bfs(int y, int x) {
        if (grid[y][x] == 1 || visited[y][x]) return 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (!inRange(ny, nx)) continue;
                if (!visited[ny][nx] && grid[ny][nx] != 1) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                    cnt++;
                }
            }
        }
        return cnt;
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
                if (grid[i][j] == 1) {
                    rock.add(new int[]{i, j});
                }
            }
        }

        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt() - 1;
            startPoints[i][1] = sc.nextInt() - 1;
        }

        getCombination(0, 0);
        System.out.println(max);
    }
}

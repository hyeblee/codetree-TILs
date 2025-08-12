import java.util.*;

class Pair {
    int y, x;
    public Pair(int y, int x) { this.y = y; this.x = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return y == p.y && x == p.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

public class Main {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int n, m;
    static int[][] grid;
    static boolean[][] notBlockWater;
    static List<Pair> ices = new ArrayList<>();

    static int second = 0;
    static int lastSize = 0;

    static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    // 외부 물 영역 BFS
    static void getNonBlockArea() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(notBlockWater[i], false);
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0));
        notBlockWater[0][0] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (inRange(ny, nx) && grid[ny][nx] == 0 && !notBlockWater[ny][nx]) {
                    notBlockWater[ny][nx] = true;
                    q.offer(new Pair(ny, nx));
                }
            }
        }
    }

    static boolean canMelt(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (inRange(ny, nx) && grid[ny][nx] == 0 && notBlockWater[ny][nx]) {
                return true;
            }
        }
        return false;
    }

    static void meltIce() {
        while (!ices.isEmpty()) {
            second++;
            getNonBlockArea();

            lastSize = ices.size();
            List<Pair> nextList = new ArrayList<>();
            Set<Pair> nextSet = new HashSet<>();

            // 녹일 얼음 결정
            for (Pair ice : ices) {
                if (!canMelt(ice.y, ice.x)) {
                    nextList.add(ice);
                    nextSet.add(ice);
                }
            }

            if (nextList.isEmpty()) break;

            // grid에서 녹은 얼음 제거
            for (Pair p : ices) {
                if (!nextSet.contains(p)) {
                    grid[p.y][p.x] = 0;
                }
            }

            ices = nextList;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        notBlockWater = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    ices.add(new Pair(i, j));
                }
            }
        }

        if (ices.isEmpty()) {
            System.out.println("0 0");
            return;
        }

        meltIce();
        System.out.println(second + " " + lastSize);
    }
}

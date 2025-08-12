import java.util.Scanner;
import java.util.*;

// 현재 배열, 다음 배열 필요. -> 굳이...? 우선 만들어.
// 다 녹았는지 판단 필요 -> 빙하 List 사이즈 0이면 종료
// 탐색 기준은 빙하 기준으로. -> 빙하 List로 관리하기
// 다음 배열에 1 없으면(다 녹았으면), 현재 배열 탐색해서 1개수와 시간 반환하기

class Pair {
    int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "("+x + ", " + y + ") ";
    }
}

public class Main {

    public static final int[] dy = {-1,0,1,0}; 
    public static final int[] dx = {0, 1, 0, -1};

    public static int n, m;

    public static int[][] grid; 
    // public static int[][] nextGrid;
    // public static boolean[][] visited;

    public static List<Pair> ices = new ArrayList<>();
    public static List<Pair> nextIces = new ArrayList<>();

    public static int second = 0; 
    public static int lastSize = 0;

    

    // public static 
    // public static 
    // public static 

    public static boolean inRange(int y, int x) {
        return 0<=y&&y<n && 0<=x&&x<m;
    }

    public static boolean isSurroundedByOne(int y, int x) {
        
        for(int i=0;i<4;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (inRange(ny, nx) && grid[ny][nx] == 0) {
                return false;
            }
        }

        return true;
    
    }

    public static boolean canMelt(int y, int x) {
        
        for(int i=0;i<4;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (inRange(ny, nx) && grid[ny][nx] == 0 && !isSurroundedByOne(ny, nx)) {
                return true;
            }
        }

        return false;
    }

    public static void meltIcePerSecond() {

        second++;
        
        nextIces = new ArrayList<>();
        for(Pair ice: ices) {
            if (canMelt(ice.y, ice.x)) {
                continue;
            }
            System.out.println(ice);
            nextIces.add(ice);
        }
        
        // System.out.println(nextIces.toString());
        if (nextIces.size()==0) {
            lastSize = ices.size();
            return;
        }

        ices = nextIces;
        meltIcePerSecond();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1) {
                    ices.add(new Pair(i, j));
                }
            }
        }

        meltIcePerSecond();
        System.out.println(second+" "+lastSize);
    }
}
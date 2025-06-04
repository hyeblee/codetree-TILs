import java.util.Scanner;
import java.util.*;

public class Main {

  public static final int[] dx = {1, -1, -1, 1}; // 1, 2, 3, 4 이동
  public static final int[] dy = {-1, -1, 1, 1};

  public static int n;
  public static int max_size;
  public static int[][] grid;

  public static boolean isInRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  public static int getRectangle(int y, int x, int one, int two) {
    int curY = y;
    int curX = x;
    int sum = 0;
    int[] moveNum = new int[]{one, two, one, two}; // 1,2,3,4 방향 탐색 갯수

    for (int i = 0; i < 4; i++) { // 4방향 전부 탐색
      for (int j = 0; j < moveNum[i]; j++) { // moveNum갯수만큼 탐색
        curY += dy[i];
        curX += dx[i];
        if (!isInRange(curY, curX)) {
          return -1;
        }
        sum += grid[curY][curX];
      }


    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    max_size = n - 2;

    grid = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }

    int max = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) { // 시작 위치
        for (int k = 1; k <= max_size; k++) {
          for (int l = 1; l <= max_size; l++) {
            int result = getRectangle(i, j, k, l);
            max = Math.max(max, result);
          }
        }
      }
    }

    System.out.println(max);
  }

}
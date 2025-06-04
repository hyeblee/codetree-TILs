import java.util.Scanner;
import java.util.*;
public class Main {

  public static final int[] dx = {1, -1, -1, 1}; // 1, 2, 3, 4 이동
  public static final int[] dy = {-1, -1, 1, 1};

  public static int n;
  public static int max_size;
  public static int[][] grid;

  public static boolean isInRange(int y, int x) {
    return 0<=y&&y<n && 0<=x&&x<n;
  }

  public static int getRectangle(int y, int x, int one, int two) {
    int curY = y;
    int curX = x;
    int sum = 0;

    // System.out.printf("%d %d %d\n",curX, curY, sum);
    for(int i=0;i<one;i++) { // 1방향으로 탐색

    //   System.out.printf("%d %d %d\n",curX, curY, sum);
      curX += dx[0];
      curY += dy[0];
      if (!isInRange(curY, curX)) {
        // System.out.println("1");
        return -1;
      }
      sum += grid[curY][curX];
    }

    for(int i=0;i<two;i++) { // 2방향으로 탐색
    //   System.out.printf("%d %d %d\n",curX, curY, sum);
      curX += dx[1];
      curY += dy[1];
      if (!isInRange(curY, curX)) {
        // System.out.println("2");
        return -1;
      }
      sum += grid[curY][curX];
    }


    for(int i=0;i<one;i++) { // 3방향으로 탐색
    //   System.out.printf("%d %d %d\n",curX, curY, sum);
      curX += dx[2];
      curY += dy[2];
      if (!isInRange(curY, curX)) {
        // System.out.println("3");
        return -1;
      }
      sum += grid[curY][curX];
    }


    for(int i=0;i<two;i++) { // 4방향으로 탐색
    //   System.out.printf("%d %d %d\n",curX, curY, sum);
      curX += dx[3];
      curY += dy[3];
      if (!isInRange(curY, curX)) {
        // System.out.println("4");
        return -1;
      }
      sum += grid[curY][curX];
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

//   System.out.println( getRectangle(4,1,3,1));
     for (int i = 0; i < n; i++) {
     	for (int j = 0; j< n; j++) { // 시작 위치
     		for(int k=1; k<=max_size;k++) {
     			for(int l=1; l<=max_size;l++) {
     				int result = getRectangle(i,j,k,l);
     				// System.out.printf("%d %d %d %d = %d\n", j,i, l,k,result);

     				max = Math.max(max, result);
     			}
     		}
     	}
     }

    System.out.println(max);
  }

}
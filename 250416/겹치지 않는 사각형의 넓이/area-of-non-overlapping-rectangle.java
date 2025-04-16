import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 1,3을 가로로 하는 직사각형을 만들려면 1,2만 기록하면 된다.
public class Main {

  public static final int MAX_SIZE = 1000;
  public static int[][] grid = new int[MAX_SIZE * 2 + 1][MAX_SIZE * 2 + 1];

  public static void makeRectangle(int x1, int y1, int x2, int y2) {
    for (int i = y1; i < y2; i++) {
      for (int j = x1; j < x2; j++) {
        grid[i][j] = 1;
      }
    }
  }

  public static void deleteRectangle(int x1, int y1, int x2, int y2) {
    for (int i = y1; i < y2; i++) {
      for (int j = x1; j < x2; j++) {
        grid[i][j] = 0;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 2; i++) {
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();
      makeRectangle(x1 + MAX_SIZE, y1 + MAX_SIZE, x2 + MAX_SIZE, y2 + MAX_SIZE);
    }

    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();
    deleteRectangle(x1 + MAX_SIZE, y1 + MAX_SIZE, x2 + MAX_SIZE, y2 + MAX_SIZE);

    int result = 0;
    for (int i = 0; i <= MAX_SIZE * 2; i++) {
      for (int j = 0; j <= MAX_SIZE * 2; j++) {
        if (grid[i][j] == 1) {
          result++;
        }
      }
    }

    System.out.println(result);
  }
}
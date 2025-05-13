import java.util.*;

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

  public static void eraseRectangle(int x1, int y1, int x2, int y2) {
    for (int i = y1; i < y2; i++) {
      for (int j = x1; j < x2; j++) {
        grid[i][j] = 0;
      }
    }
  }

  // 1이 있는 영역의 최소최대 행, 최소최대 열 구하기
  public static int getMinSize() {
    // 경계의 시작은 더 작은값으로 갱신
    int colS = 2 * MAX_SIZE;
    int rowS = 2 * MAX_SIZE;
    // 경계의 끝은 더 큰 값으로 갱신
    int colE = 0;
    int rowE = 0;

    for (int i = 0; i <= 2 * MAX_SIZE; i++) {
      for (int j = 0; j <= 2 * MAX_SIZE; j++) {
        if (grid[i][j] == 1) {
          colS = Math.min(colS, j);
          rowS = Math.min(rowS, i);
          colE = Math.max(colE, j);
          rowE = Math.max(rowE, i);
        }
      }
    }

    // System.out.println(rowS-1000);
    // System.out.println(rowE-1000);


    // System.out.println(colS-1000);
    // System.out.println(colE-1000);
    return (rowE - rowS + 1) * (colE - colS + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int rect1_x1 = sc.nextInt() + MAX_SIZE;
    int rect1_y1 = sc.nextInt() + MAX_SIZE;
    int rect1_x2 = sc.nextInt() + MAX_SIZE;
    int rect1_y2 = sc.nextInt() + MAX_SIZE;
    int rect2_x1 = sc.nextInt() + MAX_SIZE;
    int rect2_y1 = sc.nextInt() + MAX_SIZE;
    int rect2_x2 = sc.nextInt() + MAX_SIZE;
    int rect2_y2 = sc.nextInt() + MAX_SIZE;

    // rect2 안에 rect1이 들어있으면 0 출력 후 종료(전부 0인 경우)
    if (rect2_x1 <= rect1_x1 && rect1_x2 <= rect2_x2 && rect2_y1 <= rect1_y1
        && rect1_y2 <= rect2_y2) {
      System.out.println("0");
      return;
    }

    makeRectangle(rect1_x1, rect1_y1, rect1_x2, rect1_y2);
    eraseRectangle(rect2_x1, rect2_y1, rect2_x2, rect2_y2);
    int result = getMinSize();
    System.out.println(result);
  }
}


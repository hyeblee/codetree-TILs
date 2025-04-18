import java.util.*;

public class Main {
  public static final int MAX_SIZE = 1000;
  public static int[][] grid = new int[MAX_SIZE*2+1][MAX_SIZE*2+1];

  public static void makeRectangle(int x1, int y1, int x2, int y2) {
    for (int i = y1; i <= y2; i++) {
      for(int j = x1; j <= x2; j++) {
        grid[i][j] = 1;
      }
    }
  }

  public static void eraseRectangle(int x1, int y1, int x2, int y2) {
    for (int i = y1; i <= y2; i++) {
      for(int j = x1; j <= x2; j++) {
        grid[i][j] = 0;
      }
    }
  }

  public static int getMinSize(int x1, int y1, int x2, int y2) {
    int colS = x1;
    int rowS = y1;
    int colE = x2;
    int rowE = y2;

    for (int i = y1; i <= y2; i++) {
      for(int j = x1; j <= x2; j++) {
        if(grid[i][j] == 1) {
          colS = Math.max(colS,j);
          colE = Math.min(colE,j);
          rowS = Math.max(rowS,i);
          rowE = Math.min(rowE,i);
        }
      }
    }
    return (rowE-rowS)*(colE-colS);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int rect1_x1 = sc.nextInt()+MAX_SIZE;
    int rect1_y1 = sc.nextInt()+MAX_SIZE;
    int rect1_x2 = sc.nextInt()+MAX_SIZE;
    int rect1_y2 = sc.nextInt()+MAX_SIZE;
    int rect2_x1 = sc.nextInt()+MAX_SIZE;
    int rect2_y1 = sc.nextInt()+MAX_SIZE;
    int rect2_x2 = sc.nextInt()+MAX_SIZE;
    int rect2_y2 = sc.nextInt()+MAX_SIZE;

    makeRectangle(rect1_x1, rect1_y1, rect1_x2, rect1_y2);
    eraseRectangle(rect2_x1, rect2_y1, rect2_x2, rect2_y2);
    int result = getMinSize(rect1_x1, rect1_y1, rect1_x2, rect1_y2);
    System.out.println(result);
  }
}
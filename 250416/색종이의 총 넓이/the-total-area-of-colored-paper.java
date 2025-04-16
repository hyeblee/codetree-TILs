import java.util.*;

public class Main {

  public static final int MAX_SIZE = 100;
  public static int[][] grid = new int[MAX_SIZE * 2 + 1][MAX_SIZE * 2 + 1];

  public static void makeRectangle(int x, int y) {
    for(int i=y;i<y+7;i++){
      for(int j=x;j<x+7;j++){
        grid[i][j] = 1;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];

    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      makeRectangle(x[i], y[i]);
    }
    int count = 0;
    for (int i = 0; i < 2*MAX_SIZE+1; i++) {
      for (int j = 0; j < 2 * MAX_SIZE + 1; j++) {
        if(grid[i][i] == 1){
          count++;
        }
      }
    }

    System.out.println(count);
  }
}
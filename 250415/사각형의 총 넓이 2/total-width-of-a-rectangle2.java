import java.io.*;
import java.util.*;


public class Main {

  public static int[][] grid = new int[201][201];

  public static void makeRectangle(int x1, int y1, int x2, int y2) {
    for (int i = x1; i < x2; i++) {
      for (int j = y1; j < y2; j++) {
        grid[i][j] = 1;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] x1 = new int[n];
    int[] y1 = new int[n];
    int[] x2 = new int[n];
    int[] y2 = new int[n];

    for (int i = 0; i < n; i++) {
      x1[i] = sc.nextInt();
      y1[i] = sc.nextInt();
      x2[i] = sc.nextInt();
      y2[i] = sc.nextInt();
      makeRectangle(x1[i], y1[i], x2[i], y2[i]);
    }
    int size = 0;
    for (int i = 0; i <= 200; i++) {
      for (int j = 0; j <= 200; j++) {
        if (grid[i][j] == 1) {
          size++;
        }
      }
    }
    System.out.println(size);
  }
}
import java.io.*;
import java.util.*;


public class Main {

  public static final int MAX_SIZE = 2000;

  public static int N;
  public static int[] result = new int[MAX_SIZE + 1];

  public static void move(int cur, int x) {
    if (x > 0) {
      for (int i = cur; i < cur + x; i++) {
        result[i]++;
      }
    } else {
      for (int i = cur; i > cur + x; i--) {
        result[i]++;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int cur = 1000;

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      char ch = sc.next().charAt(0);
      if (ch == 'L') {
        x *= -1;
      }
      move(cur, x);
      cur += x;
    }
    int cnt = 0;
    for (int i = 0; i <= MAX_SIZE; i++) {
      if (result[i] >= 2) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
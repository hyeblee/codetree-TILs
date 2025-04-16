import java.io.*;
import java.util.*;


public class Main {

  public static final int MAX_SIZE = 1000;

  public static int N;
  public static int[] arr = new int[MAX_SIZE * 2 + 1];

  public static void write(int start, int end) {
    for (int i = start; i <= end; i++) {
      arr[i]++;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    int cur = MAX_SIZE;

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      char ch = sc.next().charAt(0);
      if (ch == 'L') {
        write(cur - x, cur - 1);
        cur -= x;
      } else if (ch == 'R') {
        write(cur, cur + x - 1);
        cur += x;
      }
    }
    int count = 0;
    for (int i = 0; i <= MAX_SIZE * 2; i++) {
      if (arr[i] >= 2) {
        count++;
      }
    }

    System.out.println(count);
  }
}
import java.io.*;
import java.util.*;


public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[2001];
    int cur = 1000;
    arr[cur] = 0;
    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      char dir = sc.next().charAt(0);
      if (dir == 'L') {
        for (int j = cur - x; j < cur; j++) {
          arr[j]++;
        }
        cur -= x;
      } else if (dir == 'R') {
        for (int j = cur; j < cur + x; j++) {
          arr[j]++;
        }
        cur += x;
      }
    }

    int cnt = 0;
    for (int i = 0; i < 2001; i++) {
      if (arr[i] >= 2) {
//          System.out.println(i - 1000);
        cnt++;

      }
    }
    System.out.println(cnt);
  }
}
import java.io.*;
import java.util.*;

public class Main {

  public static int getMinute(int d, int h, int m) {
    int day = d - 11;
    int minute = h * 60 + m;
    minute -= 11 * 60 + 11;
    if (minute < 0) {
      day--;
      minute += 24 * 60;
    }
    minute += day * 24 * 60;
    return minute;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(getMinute(A, B, C));
  }
}
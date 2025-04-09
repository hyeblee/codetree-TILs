import java.io.*;
import java.util.*;

public class Main {

  public static int getMinute(int h, int m) {
    return h * 60 + m;
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    A -= 11;
    int minute = getMinute(B, C) - getMinute(11, 11);
    if (minute < 0) {
      minute += 24 * 60;
      A--;
    }
    minute += A * 24 * 60;
    System.out.println(minute);
  }
}
import java.io.*;
import java.util.*;

public class Main {

  public static int getMinute(int h, int m) {
    return h * 60 + m;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    // Please write your code here.

    System.out.println(getMinute(c,d)-getMinute(a, b));
  }
}
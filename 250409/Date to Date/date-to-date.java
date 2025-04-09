import java.io.*;
import java.util.*;

public class Main {

  //  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
  public static int[] endOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public static int getDay(int m, int d) {
    int elapsedDays = 0;
    int month = 1;
    int day = 1;
    while (true) {
      if (month == m && day == d) {
        return elapsedDays;
      }
      day++;
      if (day > endOfMonth[month]) {
        month++;
        day = 1;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m1 = sc.nextInt();
    int d1 = sc.nextInt();
    int m2 = sc.nextInt();
    int d2 = sc.nextInt();

    System.out.println(getDay(m2, d2) - getDay(m1, d1));
  }
}
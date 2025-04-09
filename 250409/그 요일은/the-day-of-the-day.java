import java.io.*;
import java.util.*;

public class Main {

  public static int[] endOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  public static String[] dayOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

  public static int getDay(int m, int d) {
    int elapsedDays = 0;
    for (int i = 1; i < m; i++) {
      elapsedDays += endOfMonth[i];
    }
    elapsedDays += d;
    return elapsedDays;
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m1 = sc.nextInt();
    int d1 = sc.nextInt();
    int m2 = sc.nextInt();
    int d2 = sc.nextInt();
    String A = sc.next();

    int n = 0;
    for (int i = 0; i < dayOfWeek.length; i++) {
      if (A.equals(dayOfWeek[i])) {
        n = i;
        break;
      }
    }
    d1 += n;
    if (d1 > endOfMonth[m1]) {
      d1 -= endOfMonth[m1];
      m1++;
    }
    int diff = getDay(m2, d2) - getDay(m1, d1);
    if(diff<0){
      System.out.println(0);
      return;
    }
    diff /= 7;
    System.out.println(diff+1);

  }
}
import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] x1 = new int[n];
    int[] x2 = new int[n];

    int[] total = new int[201];

    for (int i = 0; i < n; i++) {
      x1[i] = sc.nextInt();
      x2[i] = sc.nextInt();
      int s = x1[i]+100;
      int e = x2[i]+100;
      for(int j = s;j<=e;j++){
        total[j]++;
      }
    }
    Arrays.sort(total);
    System.out.println(total[200]);


  }
}
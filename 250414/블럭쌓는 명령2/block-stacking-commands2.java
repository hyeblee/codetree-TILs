import java.io.*;
import java.util.*;

import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] arr = new int[N+1];
    for (int i = 0; i < K; i++) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      for(int j=A;j<=B;j++){
        arr[j]++;
      }
    }
    Arrays.sort(arr);
    System.out.println(arr[arr.length-1]);

  }
}
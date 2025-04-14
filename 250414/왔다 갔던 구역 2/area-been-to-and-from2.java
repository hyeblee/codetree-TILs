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
      if(dir == 'L'){
        cur-=x;
      } else if(dir == 'R'){
        cur+=x;
      }
      arr[cur]++;
    }
    int cnt = 0;
    for (int i = 0; i < 2000; i++) {
      if(arr[i] >0){
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
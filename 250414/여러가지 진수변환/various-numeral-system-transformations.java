import java.io.*;
import java.util.*;

public class Main {
  public static int N, B;

  public static void decimalToB(){
    int[] arr = new int[10];
    int cnt = 0;
    while(true){
      arr[cnt++] = N%B;
      N/=B;
      if(N<=0)
        break;
    }
    for(int i=cnt-1;i>=0;i--){
      System.out.print(arr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    B = sc.nextInt();

    decimalToB();
  }
}
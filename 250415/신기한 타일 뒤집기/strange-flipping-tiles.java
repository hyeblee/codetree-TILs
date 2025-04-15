import java.io.*;
import java.util.*;


public class Main {

  public static final int MAX_SIZE = 100000;
  public static int N;
  public static int[] tiles = new int[MAX_SIZE * 2 + 1]; // 1은 백, 2는 흑

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cur = MAX_SIZE;

    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      char d = sc.next().charAt(0);
      if(d=='R'){
        for(int j=cur;j<cur+x;j++){
          tiles[j] = 2;
        }
        cur+=x-1;
      } else if(d=='L'){
        for(int j=cur-x+1;j<=cur;j++){
          tiles[j] = 1;
        }
        cur-=x-1;
      }
    }
    int w = 0;
    int b = 0;
    for(int i=0;i<=MAX_SIZE*2;i++){
      if(tiles[i]==1) w++;
      if(tiles[i]==2) b++;
    }
    System.out.println(w + " "+ b);
  }
}

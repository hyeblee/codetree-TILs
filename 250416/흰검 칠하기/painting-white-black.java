import java.util.*;


public class Main {
  // n칸 움직이면, 현재 좌표에서 n-1을 움직여주면 된당.
  public static final int MAX_SIZE = 100000;

  public static Tile[] tiles = new Tile[MAX_SIZE * 2 + 1];
  public static int[] result = new int[MAX_SIZE * 2 + 1]; // 1이면 흑, 2이면 백
  public static int N;


  public static class Tile {

    int w;
    int b;
  }

  public static void paintBlack(int start, int end) {
    for (int i = start; i <= end; i++) {
      tiles[i].b++;
      result[i] = 1;
    }
  }

  public static void paintWhite(int start, int end) {
    for (int i = start; i <= end; i++) {
      tiles[i].w++;
      result[i] = 2;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    for (int i = 0; i <= MAX_SIZE * 2; i++) {
      tiles[i] = new Tile();
    }

    int cur = MAX_SIZE;
    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      x--;
      char ch = sc.next().charAt(0);
      if (ch == 'L') {
        paintWhite(cur - x, cur);
        cur -= x;
      } else if (ch == 'R') {
        paintBlack(cur, cur + x);
        cur += x;
      }
    }
    int w = 0;
    int b = 0;
    int g = 0;

    for (int i = 0; i <= MAX_SIZE * 2; i++) {
      if (tiles[i].b >= 2 && tiles[i].w >= 2) {
        g++;
      } else if (result[i] == 1) {
        b++;
      } else if (result[i] == 2) {
        w++;
      }

    }

    System.out.println(w + " " + b + " " + g);
  }

}
import java.io.*;
import java.util.*;


public class Main {

  public static int N;
  public static Tile[] tiles = new Tile[1000010];

  public static class Tile {

    int w;
    int b;
    char cur;

    @Override
    public String toString() {
      return "Tile{" +
          "w=" + w +
          ", b=" + b +
          ", cur=" + cur +
          '}';
    }
  }

  public static void paintWhite(int start, int end) {
    for (int i = start; i <= end; i++) {
      tiles[i].w++;
      tiles[i].cur = 'w';
    }
  }

  public static void paintBlack(int start, int end) {
    for (int i = start; i <= end; i++) {
      tiles[i].b++;
      tiles[i].cur = 'b';
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    for (int i = 0; i < 1000010; i++) {
      tiles[i] = new Tile();
    }

    int cur = 50000;

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      char ch = sc.next().charAt(0);
      if (ch == 'R') {
        paintBlack(cur, cur + x - 1);
        cur += x - 1;
      } else if (ch == 'L') {
        paintWhite(cur - x + 1, cur);
        cur -= x - 1
      }
    }

    int white = 0;
    int black = 0;
    int grey = 0;
    for (int i = 0; i < 1000010; i++) {
      if (tiles[i].w >= 2 && tiles[i].b >= 2) {
        grey++;
      } else if (tiles[i].cur == 'w') {
        white++;
      } else if (tiles[i].cur == 'b') {
        black++;
      }
    }
    System.out.println(white + " " + black + " " + grey);
  }
}

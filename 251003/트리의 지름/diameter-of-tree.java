import java.util.Scanner;
import java.io.*;

// 트리의 지름 구하기
// 1에서 출발하여 제일 먼 정점 x를 구한다 (dfs)
// x에서 출발하여 제일 먼 정점까지의 거리가 트리의 지름 (dfs)

public class Main {
    public static List<List<Integer>> adjsList;
    public static int n;
    public static boolean[] visited;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
        }


    }
}
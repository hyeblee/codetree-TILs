import java.util.Scanner;
import java.util.*;

public class Main {
    public static List<List<Integer>> tree = new ArrayList<>();
    public static int n;
    public static boolean[] visited;
    public static int[] parent;

    public static void dfs(int start) {

        visited[start] = true;
        for(int next: tree.get(start)) {
            if (!visited[next]) {
                parent[next] = start;
                dfs(next);                
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        visited = new boolean[n+1];
        parent = new int[n+1];

        for(int i=0;i<n+1;i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        for(int i=1;i<=n;i++) {
            if (!visited[i])
                dfs(i);
        }

        for(int i=2;i<=n;i++) {
            System.out.println(parent[i]);
        }
        
    }

}
import java.util.*;

public class Main {
    // 1. DFS로 깊이 기록
    // 2. 둘이 depth 맞춤
    // 3. 둘이 같아질때까지 올라감
    public static List<Integer>[] adjList;
    public static int[] depth, parent;
    public static boolean[] visited;
    // public static 
    // public static
    // public static
    // public static
    // public static
    // public static
    public static void dfs(int cur, int d) {
        depth[cur] = d;
        visited[cur] = true;

        for(int next: adjList[cur]) {
            if (visited[next])
                continue;
            dfs(next, d+1);
        }
    } 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n+1];
        depth = new int[n+1];
        adjList = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0;i<n+1;i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n - 1; i++) {
            int p = sc.nextInt();
            int x = sc.nextInt();
            parent[x] = p;
            adjList[p].add(x);
        }
        
        int root = 0;
        
        for(int i=1;i<=n;i++) {
            if (parent[i] == 0) {
                root = i;
                break;
            }
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        dfs(root, 0);

        int depthA = depth[a];
        int depthB = depth[b];

        while(depthA > depthB) {
            a = parent[a];
            depthA = depth[a];
        }
        while(depthB > depthA) {
            b = parent[b];
            depthB = depth[b];
        }

        while (a!=b) {
            a = parent[a];
            b = parent[b];
        }

        System.out.println(a);
    }
}
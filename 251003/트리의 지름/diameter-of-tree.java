import java.util.*;
import java.io.*;

// 트리의 지름 구하기
// 1에서 출발하여 제일 먼 정점 x를 구한다 (dfs)
// x에서 출발하여 제일 먼 정점까지의 거리가 트리의 지름 (dfs)

public class Main {

    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static List<Edge>[] tree;
    public static int n;
    public static boolean[] visited;
    public static int x = 0;
    public static int max = 0;
    public static int sum = 0;


    public static void dfs(int start) {
        // 현재 정점을 방문처리한다.
        visited[start] = true;

        // 다음 정점으로 향한다 (start의 인접리스트들)
        for(int i=0;i<tree[start].size();i++) {
            int to = tree[start].get(i).to;
            int weight = tree[start].get(i).weight;
            // 거리 총합을 업데이트해서 최댓값을 갱신한다.
            // 만약 최댓값이면 해당 정점을 x로 업데이트 한다.
            if (!visited[to]) {
                sum += weight;
                if (sum > max) {
                    max = sum;
                    x = to;
                }
                dfs(to);
                sum -= weight;
                visited[to] = false;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        visited = new boolean[n+1];
        tree = new ArrayList[n+1];
        
        for(int i=0;i<n+1;i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            tree[u].add(new Edge(v,w));
            tree[v].add(new Edge(u,w));
        }

        dfs(1);

        // System.out.println(x);

        Arrays.fill(visited, false);
        dfs(x);
        System.out.println(max);

    }

}
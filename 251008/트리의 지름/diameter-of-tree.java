import java.util.*;
import java.io.*;

class Edge {
    int to, weight;

    public Edge (int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    public static int n;
    public static ArrayList<Edge>[] edges;
    public static boolean[] visited;
    public static int[] dist; // start에서 i까지 떨어진 거리
    public static int furthestDist = 0; // start에서 제일 멀리 떨어진 거리
    public static int furthestVertext = 1; // start에서 제일 멀리 떨어진 정점

    // start로부터 떨어진 거리를 계산하여 dist에 저장한다.
    public static void dfs(int start, int totalDist) {
        visited[start] = true;

        for(int i=0;i<edges[start].size();i++) {
            int to = edges[start].get(i).to;
            int weight = edges[start].get(i).weight;

            if(visited[to]) { // 방문한 정점은 탐색하지 않는다.
                continue;
            }

            dist[to] = totalDist + weight;
            dfs(to, totalDist + weight);
        }
    }

    // 시작점으로부터 제일 멀리 떨어진 정점 찾아준다.
    public static void findFurthest(int start) {

        Arrays.fill(visited, false);
        Arrays.fill(dist, 0);

        visited[start] = true;
        dist[start] = 0;
        dfs(start, 0);

        furthestDist = 0;
        furthestVertext = start;
        for(int i=1;i<=n;i++) {
            if (dist[i] > furthestDist) {
                furthestDist = dist[i];
                furthestVertext = i;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n+1];
        edges = new ArrayList[n+1];
        dist = new int[n+1];
        
        for(int i=0;i<n+1;i++) {
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            edges[a].add(new Edge(b,w));
            edges[b].add(new Edge(a,w));
        }

        findFurthest(1);
        findFurthest(furthestVertext);
        System.out.println(furthestDist);
    }


}
import java.util.*;
import java.io.*;


// 트리의 지름 구하기
// 임의의 정점에서 제일 먼 정점 x구하기
// x에서 제일 먼 정점(p)까지의 거리가 트리의 지름

public class Main {
    public static int n;
    public static int x = 1;
    public static int d = 0; // dfs 탐색 때 쓸 누적 거리
    public static int r = 0; // 최대 누적 거리

    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static List<Edge>[] tree;
    public static boolean[] visited;
    
    // start에서 출발하여 제일 먼 정점을 x로 갱신한다.
    // 그 거리를 r로 갱신한다.
    public static void dfs(int start) {

        visited[start] = true;

        for(int i=0;i<tree[start].size();i++) {
            int next = tree[start].get(i).to;
            
            if (visited[next]) {
                continue;
            }
            
            int weight = tree[start].get(i).weight;
            d += weight;
            if (d > r) {
                r = d;
                x = next;
            }
            dfs(next);
            d -= weight;

        }

    }
    // public static 
    // public static

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        tree = new List[n+1];
        for(int i=0;i<n+1;i++) {
            tree[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for(int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[a].add(new Edge(b, weight));
            tree[b].add(new Edge(a, weight));    
        }

        dfs(1);

        Arrays.fill(visited, false);
        dfs(x);

        System.out.print(r);
    }


}
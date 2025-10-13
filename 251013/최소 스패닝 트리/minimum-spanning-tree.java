import java.util.*;
import java.io.*;

public class Main {
    // 크루스칼 알고리즘
    // 간선의 가중치가 작은 간선부터 차례로 선택합니다.
    // 사이클이 만들어지는 간선(루트 노드가 같은 간선)은 선택하지 않습니다.
    // 선택한 간선을 mst에 넣어줍니다.
    public static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        public Edge (int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(w, e.w);
        }
    }

    public static List<Integer> mst = new ArrayList<>();
    public static int[] uf;

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            uf[rootA] = rootB;
        }
    }

    public static int find(int x) {
        if (uf[x] == x) {
            return x;
        }

        return uf[x] = find(uf[x]);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Edge[] edges = new Edge[m];
        uf = new int[n+1];
        for(int i=1;i<=n;i++) {
            uf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        // 간선을 가중치로 정렬
        Arrays.sort(edges);

        // 하나씩 선택. 근데 부모 같으면 선택 안함.
        int result = 0;
        for(int i=0;i<m;i++) {
            int u = edges[i].u;
            int v = edges[i].v;

            if (find(u)!=find(v)) {
                union(u, v);
                result += edges[i].w;
            }
        }

        System.out.println(result);
    }
}
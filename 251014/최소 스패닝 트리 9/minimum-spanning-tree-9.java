import java.util.*;

public class Main {
    // MST 구하기 - 프림 알고리즘
    // MST를 확장시키며 가장 가까운 정점들을 잇는 간선을 하나씩 선택.
    // 1. 임의의 정점을 시작점으로 선택한다.
    // 2. dist[start] = 0, 그 외는 (int)1e9로 설정하고 모든 정점을 pq에 넣는다.
    //    (Integer.MAX_VALUE하면 덧셈 연산 시, 오버플로우 발생 가능)
    // 3. pq에서 dist 제일 작은 정점을 꺼내서 MST에 추가한다.
    //    (사이클을 만드는 정점은 선택하지 않는다.)
    // 4. u와 연결된 정점 v에 대해, dist[v] 와 Node(u,v) 를 비교하여 갱신한다.
    //    (MST에 포함된 v는 탐색하지 않는다.)
    //    (MST와 연결된 정점과의 최소 거리이므로 dist[u]+Node(u,v)가 아니라 Node(u,v)임 )
    // 5. 모든 정점에 MST에 포함될때까지 3~4을 반복한다.
    // MST의 크기만 구하면 되면, dist만 기록하면 된다.
    // MST를 이루는 간선이 필요하면, parent[v] = u로 기록한다.

    public static class Node implements Comparable<Node>{
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(w, node.w);
        }

    }

    public static int n, m;
    public static List<Node>[] nodes;
    public static int[] dist;
    public static boolean[] visited;
    public static List<Integer> mst = new ArrayList<>();



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        visited = new boolean[n+1];
        nodes = new ArrayList[n+1];
        for(int i=0;i<n+1;i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            nodes[u].add(new Node(v,w));
            nodes[v].add(new Node(u,w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Node(1, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int to = cur.to;
            if (visited[to]) {
                continue;
            }
            visited[to] = true;
            sum += cur.w;

            for(Node next: nodes[to]) {
                int v = next.to;
                int w = next.w;
                if (visited[v]) {
                    continue;
                }
                if (w < dist[v]) {
                    dist[v] = w;
                    pq.add(new Node(v, w));
                }
            }
        }

        System.out.println(sum);

    }
}
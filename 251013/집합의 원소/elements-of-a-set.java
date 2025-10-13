import java.util.Scanner;
public class Main {
    // 0 a b: a집합에 b 집합 포함
    // 1 a b: a,b 같은 집합이면 1 아니면 0 출력
    public static int [] uf;

    public static int find(int x) {
        if (uf[x] == x) {
            return x;
        }

        return uf[x] = find(uf[x]); // x의 root의 최종 root를 uf[x]로 업데이트.
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        uf[rootA] = rootB;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        uf = new int[n+1];
        for(int i=1;i<=n;i++) {
            uf[i] = i;
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < m; i++) {
            int qType = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (qType == 0) {
                union(a,b);
            } else {
                if (find(a) == find(b))
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            }
        }

        System.out.println(sb);
    }
}
import java.util.*;
public class Main {
    static int n, m;
    static int[] points;

    static boolean isPossible(int d) {
        int cnt = 1;
        int last = points[0];

        for(int i=1;i<n;i++) {
            if (points[i] - last >= d) {
                cnt++;
                last = points[i];
            }
            if (cnt >= m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);

        // 물건을 m개의 점을 선택하여 놓는다.
        // 가장 인접한 두 물건의 거리를 가능한 크게 설치한다.
        int l = 1;
        int r = points[n-1] - points[0];
        

        // 조건을 만족하는 거리 중, 최댓값 구하기 -> upper bound 에서 -1하기
        while (l < r) {
            int mid = (l + r) / 2;
            if (isPossible(mid)) { // 목표값을 초과할때만 버린다.
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(l-1);


    }
}
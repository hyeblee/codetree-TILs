import java.util.*;

public class Main {

    static int n, m;
    static long[] start, end;

    // mid 이상의 간격으로 n개의 점을 놓을 수 있는지 확인하는 함수
    static boolean possible(long mid) {
        long last = Long.MIN_VALUE / 2;
        long cnt = 0;

        for (int i = 0; i < m; i++) {
            long s = start[i];
            long e = end[i];

            // 현재 구간에서 첫 배치 가능한 위치
            long pos = Math.max(s, last + mid);

            if (pos > e) continue;

            // 이 구간에서 놓을 수 있는 점 개수
            long can = (e - pos) / mid + 1;
            cnt += can;

            if (cnt >= n) return true;

            // 마지막으로 놓은 점 위치 갱신
            last = pos + (can - 1) * mid;
        }

        return cnt >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        start = new long[m];
        end = new long[m];

        for (int i = 0; i < m; i++) {
            start[i] = sc.nextLong();
            end[i] = sc.nextLong();
        }

        // 구간을 좌측 기준으로 정렬
        long[][] range = new long[m][2];
        for (int i = 0; i < m; i++) {
            range[i][0] = start[i];
            range[i][1] = end[i];
        }
        Arrays.sort(range, Comparator.comparingLong(a -> a[0]));
        for (int i = 0; i < m; i++) {
            start[i] = range[i][0];
            end[i] = range[i][1];
        }

        long l = 0;
        // 전체 좌표 범위로 상한 설정
        long r = 1_000_000_000_000_000_000L;

        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (possible(mid)) l = mid;
            else r = mid - 1;
        }

        System.out.println(l);
    }
}

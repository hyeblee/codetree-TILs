import java.util.*;

public class Main {
    // upper bound: 초과하는 첫 값을 찾는다. (조건 만족 중 제일 큰 값 찾기에 사용)
    // lower bound: 이상인 첫 값을 찾는다.
    static int n, m;
    static int[] arr;

    static boolean isPossible(long second) {
        long cnt = 0;
        for (int i = 0; i < m; i++) {
            long possibleCount = second / arr[i];
            cnt += possibleCount;
            if (cnt >= n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        long l = 0;
        long r = (long) arr[m-1] * n;

        while (l < r) {
            long mid = (l + r) / 2;

            if (isPossible(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(r+1);

    }
}

import java.util.*;
public class Main {

    static int n, m;
     // 점 놓을 수 있는 좌표
    static long[] arr;

    // 두 점 사이의 거리가 mid 이상이어야 함.
    static boolean possible(long mid) {
        int cnt = 1;

        for(int i=0;i<arr.length;i++) {
            if (arr[i] >= mid) {
                cnt++;
            }
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
        
        long[] start = new long[m];
        long[] end = new long[m];

        Set<Long> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            start[i] = sc.nextLong();
            end[i] = sc.nextLong();
            for(long j=start[i]; j<=end[i]; j++) {
                set.add(j);
            }
        }

        long[] tmp = new long[set.size()];

        int cnt=0;
        for(long v: set) {
            tmp[cnt++] = v;
        }
        Arrays.sort(tmp);
        arr = new long[cnt-1];

        cnt = 0;
        for(int i=1;i<set.size();i++) {
            arr[cnt++] = tmp[i] - tmp[i-1];
        }

        Arrays.sort(arr);


        long l = 0;
        long r = 1_000_000_000_000_000_000L;

        long answer = 1_000_000_000_000_000_000L;

        while (l < r) {
            long mid = (l + r) / 2;

            if (possible(mid)) {
                l = mid + 1;
                answer = Math.min(mid, answer);
            } else {
                r = mid;
            }
        }

        System.out.println(answer); 
    }
}
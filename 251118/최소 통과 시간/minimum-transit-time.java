import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    // 주어진 시간 안에 n명 모두 통과 가능한지 체크
    static boolean isPossible(long seconds) {
        long count = 0;
        for (int i = 0; i < m; i++) {
            count += seconds / arr[i]; // 각 통로에서 가능한 인원
            if (count >= n) return true; // 이미 n명 이상이면 가능
        }
        return count >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 사람 수
        m = sc.nextInt(); // 통로 수

        arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr); // 속도 오름차순 정렬

        long left = 1;                 // 최소 시간
        long right = (long) arr[m - 1] * n; // 최대 시간 (가장 느린 통로로 모두 통과)
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isPossible(mid)) {
                answer = mid;      // 가능한 최소 시간 갱신
                right = mid - 1;   // 더 줄일 수 있는지 탐색
            } else {
                left = mid + 1;    // 부족하면 시간 늘리기
            }
        }

        System.out.println(answer);
    }
}

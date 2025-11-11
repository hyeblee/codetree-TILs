import java.util.Scanner;
public class Main {

    static int n, m;
    static int[] arr;

    // 이분탐색은 항상 반 열린구간
    public static int binarySearch(int x) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            // 오른쪽 버리기
            if (arr[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (arr[l] == x) {
            return l;
        }
        return -2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            System.out.println(binarySearch(x) + 1);
        }
    }
}
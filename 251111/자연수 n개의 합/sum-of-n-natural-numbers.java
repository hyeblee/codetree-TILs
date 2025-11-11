import java.util.Scanner;

public class Main {

    static final int MAX = (int)10e6;
    static long[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        // Please write your code here.
        sum = new long[MAX+1];
        
        for(int i=1;i<=MAX;i++) {
            sum[i] = sum[i-1] + i;
            // System.out.print(sum[i] + " ");
        }
        int l = 0;
        int r = MAX + 1;

        // 가능한 수 중 최댓값
        int maxN = 0;

        while (l < r) {
            int mid = (l+r) / 2;
            if (sum[mid] <= s) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        maxN = l-1;

        System.out.println(maxN);
    }
}
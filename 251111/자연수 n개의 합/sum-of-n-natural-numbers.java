import java.util.Scanner;

public class Main {

    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        // Please write your code here.

        long l = 0;
        long r = (long)MAX + 1L;

        // 가능한 수 중 최댓값

        while (l < r) {
            long mid = (l+r) / 2;
            long sum = (1+mid)*mid/2;
            if (sum <= s) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }


        System.out.println(l-1);
    }
}

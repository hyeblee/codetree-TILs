import java.util.Scanner;
public class Main {

    static long getCnt(long number) {
        return number/3 + number/5 - number/15;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        // number까지의 moo 갯수 = number/3 + number/5 - number/15
        long l = 1;
        long r = 3_000_000_000L;

        while (l < r) {
            long mid = (l + r) / 2;
            if (getCnt(mid) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        while (l % 3 == 0 || l % 5 == 0) {
            l--;
        }

        System.out.println(l-1);
    }
}
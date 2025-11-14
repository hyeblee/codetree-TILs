import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long k = sc.nextLong();

        long l = 1;
        long r = k + 1;
        long result = l;

        while (l < r) {
            long mid = (l + r) / 2;
            int count = 0;
            for(int i=1;i<=n;i++) {
                count += Math.min(mid/i, n);
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(l);


        
    }


}
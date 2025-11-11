import java.util.*;

public class Main {
    static int[] arr;
    static int n, m;

    static boolean possible(int k) {
        int cnt = 0;
        for(int v: arr) {
            cnt += v / k;
        }
        if (cnt >= m) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        int l = 1;
        int r = arr[n-1];


        while (l < r) {
            int mid = (l+r)/2;
            if (possible(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }


        System.out.println(l-1);
        
    }
}
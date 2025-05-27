import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int cnt = 0;
        int maxCnt = 0;

        for (int i=0;i<n;i++){
            if(arr[i]==0 || arr[i] <= t) { // 같아도 안됨
                cnt = 0;
            } else {
                cnt++;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        System.out.println(maxCnt);
    }
}
import java.util.Scanner;

public class Main {
    public static final int MAX_SIZE = 1000 * 1000;
    public static int[] a = new int[MAX_SIZE+1];
    public static int[] b = new int[MAX_SIZE+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int curA = 1;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt(); // v
            int t = sc.nextInt(); // t
            for(int j=0;j<t;j++){
                a[curA] = a[curA-1] + v;
                curA++;
            }
        }


        int curB = 1;
        for (int i = 0; i < m; i++) {
           int v = sc.nextInt(); // v
            int t = sc.nextInt(); // t
            for(int j=0;j<t;j++){
                b[curB] = b[curB-1] + v;
                curB++;
            }
        }


       int cur = 0; // 1이면 A, 2이면 B
       int cnt = 0;

       for(int i=1;i<curB;i++) {
        if(a[i]>b[i]){ // a가 더 큰 경우
            if(cur == 2) { // 이전이 b였으면
                cnt++; // 횟수세기
            }
            cur = 1; // a가 더 크다고 바꿈
        } else if(a[i]<b[i]){
            if(cur == 1) {
                cnt++;
            }
            cur = 2;
        }
       }

        System.out.println(cnt);
    }
}
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


        int cnt = 0;
        int cur = 0; // 1이면 a, 2이면 b
        for(int i=1;i<curB;i++) {
            if (a[i] < b[i] && cur != 2){
                cur = 2;
                cnt++;
            }
            else if (a[i] > b[i] && cur != 1){
                cur = 1;
                cnt++;
            } 
        }

        System.out.println(cnt-1);

    }
}
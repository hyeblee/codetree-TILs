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

        boolean isA; // 같은걸로 시작하면...?
        boolean isFirst = true;

        int cnt = 0;
        for(int i=1;i<curB;i++) {
           if (a[i]>b[i] && a[i-1]<b[i-1] || a[i]<b[i] && a[i-1]>b[i-1]){
            cnt++;
           }
        }

        System.out.println(cnt);

    }
}
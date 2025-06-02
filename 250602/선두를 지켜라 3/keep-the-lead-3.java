import java.util.Scanner;
public class Main {
    public static final int MAX_TIME = 1000;
    public static final int MAX_V = 1000;

    public static int time[] = new int[MAX_TIME+1];
    public static int a[] = new int[MAX_V * MAX_TIME + 1];
    public static int b[] = new int[MAX_V * MAX_TIME + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
  
        int curA = 1;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            for (int j=0; j<t;j++){
                a[curA] = a[curA-1] + v;
                curA++;
            }
        }

        int curB = 1;
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            for (int j=0; j<t;j++){
                b[curB] = b[curB-1] + v;
                curB++;
            }
        }

        int flag = -1; // 같으면 0, A: 1, B: 2
        int cnt = 0;

        for(int i=1;i<curA;i++) {
            // System.out.println(a[i] +", " + b[i]);
           if (a[i] > b[i] && flag != 1) {
                flag = 1;
                cnt++;
           } else if (a[i] < b[i] && flag != 2) {
                flag = 2;
                cnt++;
           } else if (a[i] == b[i] && flag != 0) {
                flag = 0;
                cnt++;
           }
        }

        System.out.println(cnt);

    }
}
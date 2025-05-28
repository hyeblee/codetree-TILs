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

        boolean isA = a[1] > b[1] ? true: false;
        int cnt = 0;
        for(int i=2;i<curB;i++) {
            if(isA && a[i] < b[i]) { // A가 앞이었는데 b가 더 커진 경우
                isA = false;
                cnt++;
            } else if(!isA && a[i] > b[i]) { // B가 앞이었는데 a가 더 커진 경우
                isA = true;
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
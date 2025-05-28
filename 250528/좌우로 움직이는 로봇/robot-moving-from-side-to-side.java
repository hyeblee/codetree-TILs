import java.util.Scanner;

public class Main {
    public static final int MAX_SIZE = 1000000;
    public static int[] a = new int[MAX_SIZE + 1];
    public static int[] b = new int[MAX_SIZE + 1];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int curA = 1;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            for(int j=0;j<t;j++) {
                if(d=='R'){
                    a[curA] = a[curA - 1] + 1;
                } else {
                    a[curA] = a[curA - 1] - 1;
                }
                curA++;
            }
        }

        int curB = 1;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            for(int j=0;j<t;j++) {
                if(d=='R'){
                    b[curB] = b[curB - 1] + 1;
                } else {
                    b[curB] = b[curB - 1] - 1;
                }
                curB++;
            }
        }
        
        int maxT;

        if (curA > curB) {
            // b의 나머지 배열 curA까지 채워주기
            int last = b[curB-1];
            for(int i=curB;i<curA;i++){
                b[i] = last;
            }
            maxT = curA;
        } else {
             // a의 나머지 배열 curB까지 채워주기
            int last = a[curA-1];
            for(int i=curA;i<curB;i++){
                a[i] = last;
            }
            maxT = curB;
        }

      
        // 바로 직전에 다른 위치에 있다가 같아지는 횟수 구하기
        int cnt = 0;
        for(int i=1; i<=maxT; i++){
            if(a[i]==b[i] && a[i-1]!=b[i-1]){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
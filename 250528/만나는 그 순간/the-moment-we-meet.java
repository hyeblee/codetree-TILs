import java.util.Scanner;

public class Main {
    public static final int MAX_SIZE = 1000*1000;
    public static int[] posA = new int[MAX_SIZE + 1];
    public static int[] posB = new int[MAX_SIZE + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Please write your code here.
        int curA = 1;
        for(int i=0;i<n;i++){
            char ch = sc.next().charAt(0);
            int t = sc.nextInt();

            for(int j=0;j<t;j++){
                if (ch=='R'){
                    posA[curA] = posA[curA-1] + 1;
                } else {
                    posA[curA] = posA[curA-1] - 1;
                }
                curA++;
            }
        }

        int curB = 1;
        for(int i=0;i<m;i++){
            char ch = sc.next().charAt(0);
            int t = sc.nextInt();

            for(int j=0;j<t;j++){
                if (ch=='R'){
                    posB[curB] = posB[curB-1] + 1;
                } else {
                    posB[curB] = posB[curB-1] - 1;
                }
                curB++;
            }
        }

        int result = -1;
        for(int i=1;i<curB;i++){
            if(posA[i]==posB[i]){
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
import java.util.Scanner;

public class Main {
    public static final int MAX_T = 1000000;

    public static int n, m;
    public static int[] posA = new int[MAX_T + 1];
    public static int[] posB = new int[MAX_T + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int timeA = 1;
        for(int i=0;i<n;i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            while(t > 0) {
                if(d == 'R')
                    posA[timeA] = posA[timeA - 1] + 1;
                else
                    posA[timeA] = posA[timeA - 1] - 1;
                timeA++;
                t--;
            }
        }
        
        int timeB = 1;
        for(int i = 0; i < m; i++) {
            char d = sc.next().charAt(0); 
            int t = sc.nextInt();
            
            while(t > 0) {
                if(d == 'R')
                    posB[timeB] = posB[timeB - 1] + 1;
                else
                    posB[timeB] = posB[timeB - 1] - 1;
                
                timeB++;
                t--;
            }
        }

        int result = -1;
        for(int i=1;i < timeA; i++) {
            if(posA[i] == posB[i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);

        
        // Please write your code here.
    }
}
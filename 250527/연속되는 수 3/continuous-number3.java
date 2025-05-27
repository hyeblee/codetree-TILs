import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int cnt = 1;
        int maxCnt = 1;
        
        for(int i=0;i<n;i++){
            if(i==0 || arr[i-1]*arr[i] < 0){
                cnt = 1;
            } else {
                cnt++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);

        
        // Please write your code here.
    }
}
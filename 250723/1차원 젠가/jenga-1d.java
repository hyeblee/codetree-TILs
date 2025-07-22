import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();
        for(int i=s1;i<=e1;i++){
            blocks[i-1] = 0;
        }
        int[] tmp = new int[n];
        int cur = 0;
        for(int i=0;i<n;i++){
            if (blocks[i] != 0) {
                tmp[cur++] = blocks[i];
            }
        }
        Arrays.fill(blocks,0);
        for(int i=0;i<cur;i++){
            blocks[i] = tmp[i];
        }
        // Please write your code here.

        for(int i=s2;i<=e2;i++){
            blocks[i-1] = 0;
        }
        cur = 0;
        for(int i=0;i<n;i++){
            if (blocks[i] != 0) {
                tmp[cur++] = blocks[i];
            }
        }
        
        System.out.println(cur);
        for(int i=0;i<cur;i++){
            System.out.println(tmp[i]);
        }
    }
}
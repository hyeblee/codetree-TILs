import java.util.Scanner;
import java.util.*;

public class Main {
    public static final int MAX_N = 10;

    public static int n,k;
    public static int[] coins = new int[MAX_N];
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }

        for(int i=n-1;i>=0;i--){
            answer += k/coins[i];
            k = k % coins[i]; // 몫으로 나누고 남은 나머지로 갱싱!
            if(k==0)
                break;
            
        }
        System.out.println(answer);
    }
}
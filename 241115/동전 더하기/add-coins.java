import java.util.*;

public class Main {
    public static final int MAX_K = 10;

    public static int n,k;
    public static int[] arr = new int[MAX_K];
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int minCnt = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i=0;i<k;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<k;i++){
            if(k==0)
                break;
            int cnt = k/arr[i];
            k-=arr[i]*cnt;
            minCnt+=cnt;
        }
        System.out.println(minCnt);
    }
}
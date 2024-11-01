import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100;

    public static int[] arr = new int[MAX_N];
    public static int n;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(i%2==0){
                Arrays.sort(arr,0,i+1);
                System.out.print(arr[(i+1)/2]+" ");
            }
        }
    }
}
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[2*N];
        for(int i=0;i<2*N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = arr[0]+arr[2*N-1];
        for(int i=1;i<N;i++){
            if(max<arr[i]+arr[2*N-i-1]){
                max = arr[i]+arr[2*N-i-1];
            }
        }
        System.out.println(max);
    }
}
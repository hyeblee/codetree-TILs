import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            if(arr[i]<0){
                arr[i] = Math.abs(arr[i]);
            }
            System.out.print(arr[i] + " ");
        }
    }
}
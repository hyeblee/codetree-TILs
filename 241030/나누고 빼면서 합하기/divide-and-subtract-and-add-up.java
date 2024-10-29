import java.util.Scanner;

public class Main {

    public static int divideAdd(int[] arr, int M){
        int sum = arr[M-1];
        while(M!=1){
            M = calculate(M);
            sum+=arr[M-1];
        }
        return sum;
    }

    public static int calculate(int n){
        if(n % 2 == 0){
            return n/2;
        }
        return n--;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(divideAdd(arr,m));
        


    }
}
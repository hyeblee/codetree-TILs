import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[2*n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[n+i] = sc.nextInt();
        }

        // Please write your code here.
        for(int i=0;i<t;i++){
            int tmp = arr[2*n-1];
            for(int j=2*n-1;j>=1;j--){
                arr[j] = arr[j-1];
            }
            arr[0] = tmp;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<n;i++){
            sb.append(arr[i]+" ");
        }
        sb.append("\n");
        for(int i=0;i<n;i++){
            sb.append(arr[n+i]+" ");
        }
        System.out.println(sb);
    }
}
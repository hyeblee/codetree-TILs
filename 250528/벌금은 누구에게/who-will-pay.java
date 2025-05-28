import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] penalizedPerson = new int[m];
        int[] penalizedCnt = new int[n+1];
        
        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();
            penalizedCnt[penalizedPerson[i]]++;
            if(penalizedCnt[penalizedPerson[i]] >= k){
                break;
            }
        }
        int result = -1;
         for (int i = 0; i < m; i++) {
            penalizedCnt[penalizedPerson[i]]++;
            if(penalizedCnt[penalizedPerson[i]] >= k){
                result = penalizedPerson[i];
                break;
            }
        }

        System.out.println(result);
        // Please write your code here.
    }
}
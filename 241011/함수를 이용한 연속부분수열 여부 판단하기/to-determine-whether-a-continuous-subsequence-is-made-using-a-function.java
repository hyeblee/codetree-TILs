import java.util.*;


public class Main {
    public static boolean judge(int[] A, int[] B){
        int lengthA = A.length;
        int lengthB = B.length;

        for(int i=0;i<lengthA-lengthB+1;i++){
            boolean result=true;
            for(int j=0;j<lengthB;j++){
                if(B[j]!=A[i+j]){
                    result=false;
                    break;
                }
            }
            if(result==true)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] A = new int[n1];
        int[] B = new int[n2];

        for(int i=0;i<n1;i++)
            A[i] = sc.nextInt();
            
        for(int i=0;i<n2;i++)
            B[i] = sc.nextInt();

        if(judge(A,B)){
            System.out.println("Yes");
        }
        else
            System.out.println("No");

    }
}
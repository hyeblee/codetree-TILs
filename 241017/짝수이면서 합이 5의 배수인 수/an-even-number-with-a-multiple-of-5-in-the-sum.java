import java.util.*;

public class Main {
    public static int digitSum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }

    public static boolean judgeNum(int n){
        return n%2==0&&digitSum(n)%5==0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(judgeNum(n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
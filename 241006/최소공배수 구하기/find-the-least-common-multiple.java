import java.util.*;

public class Main {
    public static int gcd(int a, int b){
        int min = Math.min(a, b);
        int gcd = 1;
        for(int i=2;i<=min;i++){
            if(a%i==0&&b%i==0)
                gcd=i;
        }
        return gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int lcm = n*m/gcd(n,m);
        System.out.println(lcm);
    }
}
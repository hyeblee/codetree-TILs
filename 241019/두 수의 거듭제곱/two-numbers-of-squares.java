import java.util.*;

public class Main {
    public static int calcPow(int base, int pow){
        int result=1;
        for(int i=0;i<pow;i++){
            result*=base;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(calcPow(a,b));
    }
}
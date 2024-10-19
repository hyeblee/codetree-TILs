import java.util.*;

public class Main {
    public static boolean isOnjeonsu(int n){
        if(n%2==0)
            return false;
        if(n%10==5)
            return false;
        if(n%3==0&&n%9!=0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;

        for(int i=a;i<=b;i++){
            if(isOnjeonsu(i))
                cnt++;
        }
        System.out.println(cnt);
    }
}
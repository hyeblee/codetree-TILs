import java.util.*;

public class Main {
    public static int lastDay(int m){
        if(m==2)
            return 28;
        else if(m==4||m==6||m==9||m==11)
            return 30;
        else
            return 31;
    }

    public static boolean judge(int m, int d){
        if(m<=12&&d<=lastDay(m))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        if(judge(m, d))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
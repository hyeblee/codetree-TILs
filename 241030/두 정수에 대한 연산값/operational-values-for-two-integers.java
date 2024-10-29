import java.util.*;


public class Main {
    public static int calculateBig(int big){
        return big+25;
    }

    public static int calculateSmall(int small){
        return small*2;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a>b){
            a = calculateBig(a);
            b = calculateSmall(b);
        }
        else{
            a = calculateSmall(a);
            b = calculateBig(b);
        }

        System.out.println(a + " " + b);
    }
}
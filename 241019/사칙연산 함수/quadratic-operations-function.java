import java.util.*;


public class Main {
    public static int plus(int a, int b){
        return a+b;
    }

    public static int minus(int a, int b){
        return a-b;
    }

    public static int divide(int a, int b){
        return a/b;
    }

    public static int multiply(int a, int b){
        return a*b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char b = sc.next().charAt(0);
        int c = sc.nextInt();

        int result=0;

        if(b=='+'){
            result=plus(a,c);
        }
        else if(b=='-'){
            result=minus(a,c);
        }
        else if(b=='/'){
            result=divide(a,c);
        }
        else if(b=='*'){
            result=multiply(a,c);
        }
        else {
            System.out.println("False");
            return;
        }
        System.out.println(a+" "+b+" "+c+" = "+result);
    }
    
}
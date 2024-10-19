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
        Scanner sc = new Scannner(System.in);
        int a = sc.nextInt();
        int b = sc.next().charAt(0);
        int c = sc.nextInt();

        int result=0;

        if(b=="+"){
            System.out.println(plus(a,c));
        }
        else if(b=="-"){
            System.out.println(minus(a,c));
        }
        else if(b=="/"){
            System.out.println(divide(a,c));
        }
        else if(b=="*"){
            System.out.println(multiply(a,c));
        }
        else {
            System.out.println("False");
        }
    }
}
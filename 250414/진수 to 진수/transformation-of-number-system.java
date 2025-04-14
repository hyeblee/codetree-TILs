import java.io.*;
import java.util.*;

public class Main {
  public static int A, B;
  public static String N;

  public static int AToDecimal(String N) {
    int decimal = 0;
    for(int i = 0; i < N.length(); i++) {
      decimal = decimal*A + (N.charAt(i) - '0');
    }
    return decimal;
  }

  public static String decimalToB(int decimal) {
    StringBuilder sb = new StringBuilder();

    while(true){
      sb.append(decimal%B);
      decimal = decimal/B;
      if(decimal==0) break;
    }
    return sb.reverse().toString();
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    A = sc.nextInt();
    B = sc.nextInt();
    N = sc.next();
    // Please write your code here.

    int decimal = AToDecimal(N);
    System.out.println(decimalToB(decimal));

  }
}
import java.io.*;
import java.util.*;

public class Main {
  public static int N;

  public static int binaryToDecimal(String binary) {
    int decimal = 0;
    for (int i = 0; i <binary.length(); i++) {
      decimal = decimal*2 + (binary.charAt(i) - '0');
    }
    return decimal;
  }

  public static String decimalToBinary(int decimal) {
    int[] arr = new int[15];
    int cnt = 0;

    while(true){
      arr[cnt++] = decimal%2;
      decimal = decimal/2;
      if(decimal==0)
        break;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = cnt-1; i >= 0; i--){
      sb.append(arr[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String N = sc.next();
    int decimal = binaryToDecimal(N);
    decimal *= 17;
    System.out.println(decimalToBinary(decimal));
  }
}
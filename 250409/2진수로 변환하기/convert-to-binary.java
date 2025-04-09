import java.io.*;
import java.util.*;

public class Main {

  public static int[] binary = new int[20];
  public static int length = 0;

  public static void decimalToBinary(int decimal) {
    while (decimal > 0) {
      binary[length++] = decimal % 2;
      decimal /= 2;
    }
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    decimalToBinary(n);

    for (int i = length - 1; i >= 0; i--) {
      System.out.print(binary[i]);
    }
    if (length == 0) {
      System.out.println("0");
    }
  }
}
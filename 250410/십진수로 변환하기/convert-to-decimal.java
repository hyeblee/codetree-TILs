import java.io.*;
import java.util.*;

public class Main {

  public static int binaryToDecimal(String binary) {
    int sum = 0;
    int base = 1;
    char[] chars = binary.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] == '1') {
        sum += base;
      }
      base *= 2;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String binary = sc.nextLine();
    int decimal = binaryToDecimal(binary);
    System.out.println(decimal);
  }
}
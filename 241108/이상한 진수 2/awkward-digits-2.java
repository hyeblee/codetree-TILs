import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        int n = Integer.parseInt(binary, 2);
        char[] arr = binary.toCharArray();
        int max = 0;
        for(int i = 0;i<binary.length();i++) {
        	char change = arr[i] == '0'? '1': '0';
        	String result = binary.substring(0,i)+change+binary.substring(i+1,binary.length());
        	max = Integer.max(Integer.parseInt(result,2), max);
        }
        System.out.println(max);
    }
}
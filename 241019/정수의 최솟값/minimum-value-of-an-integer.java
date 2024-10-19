import java.util.Scanner;

public class Main {
    // 최솟값을 반환하는 함수를 작성합니다.
    public static int min(int a, int b, int c) {
        int minVal = a;
        if(minVal > b)
            minVal = b;
        if(minVal > c)
            minVal = c;
        
        return minVal;
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(min(a, b, c));
    }
}
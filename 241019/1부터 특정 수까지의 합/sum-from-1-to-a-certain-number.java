import java.util.Scanner;

public class Main {
    public static int sumN(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++)
            sum += i;

        return sum / 10;
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(sumN(n));
    }
}
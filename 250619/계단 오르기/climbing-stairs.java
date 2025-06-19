import java.util.Scanner;
public class Main {
    // N까지 오르기
    // 한 번에 -2 or -3
    // 서로 다른 방법의 수
    // 바텀업
    public static int result = 0;

    public static void topDown(int depth) {
        if (depth == 0) {
            result++;
            return;
        }
        if (depth < 0)
            return;
        topDown(depth-2);
        topDown(depth-3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        topDown(n);
        System.out.println(result);
    }
}
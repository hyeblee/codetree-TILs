import java.util.Scanner;

public class Main {
    // n * m 크기의 사각형을 출력합니다.
    public static void printRect(int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                System.out.print("1");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        int rowNum = sc.nextInt();
        int colNum = sc.nextInt();
        printRect(rowNum, colNum);
    }
}
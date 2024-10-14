import java.util.Scanner;

public class Main {
    public static String text, pattern;

    public static boolean isSubStr(int startIdx) {
        int n = text.length();
        int m = pattern.length();

        // 만약 pattern을 매칭 시키기에
        // text 문자열 범위를 초과하게 된다면
        // 부분 문자열이 될 수 없으므로 false를 반환합니다.
        if(startIdx + m - 1 >= n)
            return false;

        for(int j = 0; j < m; j++) {
            // 하나라도 다르다면, 부분 문자열이 아니므로 false를 반환합니다.
            if(text.charAt(startIdx + j) != pattern.charAt(j))
                return false;
        }

        // 전부 일치한다면 부분 문자열이므로 true를 반환합니다.
        return true;
    }

    // 부분 문자열의 위치를 찾아 반환합니다.
    public static int findIndex() {
        int n = text.length();
        for(int i = 0; i < n; i++) {
            // i번째를 시작으로 부분 문자열이 된다면, 해당 위치를 반환합니다.
            if(isSubStr(i))
                return i;
        }

        // 없다면, -1을 반환합니다.
        return -1;
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        text = sc.next();
        pattern = sc.next();

        System.out.print(findIndex());
    }
}
import java.util.Scanner;

public class Main {
	public static final int MAX_N = 20;

	public static int[][] arr = new int[MAX_N][MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int maxCnt = 0;
		for (int i = 0; i <= n - 3; i++) {
			for (int j = 0; j <= n - 3; j++) {
				int cnt = 0;
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						cnt += arr[k][l];
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
		}
		System.out.println(maxCnt);
	}
}
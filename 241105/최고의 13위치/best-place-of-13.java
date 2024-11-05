import java.util.Scanner;

public class Main {
	public static final int MAX_N = 20;

	public static int n;

	public static int[][] arr = new int[20][20];

	public static void main(String[] args) {
		int maxCount = 0;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 2; j++) {
				int count = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
				maxCount = Math.max(maxCount, count);
			}
		}
		System.out.println(maxCount);

	}
}
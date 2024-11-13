
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final int MAX_NUM = 200;

	public static int[][] grid = new int[MAX_NUM][MAX_NUM];
	public static int n, m;

	public static int[][][] shape = { { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 } },

			{ { 0, 1, 0 }, { 1, 1, 0 }, { 0, 0, 0 } },

			{ { 1, 1, 0 }, { 0, 1, 0 }, { 0, 0, 0 } },

			{ { 1, 1, 0 }, { 1, 0, 0 }, { 0, 0, 0 } },

			{ { 1, 1, 1 }, { 0, 0, 0 }, { 0, 0, 0 } },

			{ { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 } }, };

	public static int getMaxSum(int y, int x) {
		int maxSum = 0;
		for (int i = 0; i < 6; i++) {
			int sum = 0;
			for (int dy = 0; dy < 3; dy++) {
				for (int dx = 0; dx < 3; dx++) {
					// 범위를 넘는 탐색은 하지 않는다.
					if (x + dx >= m || y + dy >= n) {
						continue;
					}
					sum += shape[i][dy][dx] * grid[y + dy][x + dx];

				}
			}
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				maxSum = Math.max(getMaxSum(i, j), maxSum);
			}
		}
		System.out.println(maxSum);
	}
}
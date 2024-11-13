import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final int MAX_M = 100;

	public static int m, n;
	public static int[][] arr = new int[MAX_M][MAX_M];

	public static boolean hasInRow(int[] row) {
		int cnt = 1;
		if (cnt >= m) {
			return true;
		}
		for (int i = 1; i < n; i++) {
			if (row[i-1] == row[i]) {
				cnt++;
			} 
			else {
				cnt = 1;
			}
			if (cnt >= m) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasInColumn(int column) {
		int cnt = 0;
		int[] row = new int[n];
		for (int i = 0; i < n; i++) {
			row[i] = arr[i][column];
		}
		return hasInRow(row);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (hasInRow(arr[i]))
				answer++;
			if (hasInColumn(i))
				answer++;
		}

		System.out.println(answer);
	}
}
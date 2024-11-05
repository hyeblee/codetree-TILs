import java.util.Scanner;

public class Main {
	public static final int MAX_R = 15;
	public static final int MAX_C = 15;

	public static int r;
	public static int c;

	public static char[][] arr = new char[MAX_R][MAX_C];

	public static void main(String[] args) {
		int count = 0;

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.next().charAt(0);
			}
		}
		char start = arr[0][0];
		char goal = arr[r - 1][c - 1];
		for (int i = 1; i < r - 1; i++) {
			if (start == goal)
				break;
			for (int j = 1; j < c - 1; j++) {
				if (arr[i][j] == start)
					continue;
				for (int k = i + 1; k < r - 1; k++) {
					for (int l = j + 1; l < c - 1; l++) {
						if (arr[k][l] == start) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);

	}
}
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int max = 0;
		// 한 줄에 2개 가능하다면?
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 2; j++) {
				for (int k = i + 1; k < n; k++) {
					for (int l = j; l < n - 2; l++) {
						int cnt = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[k][l] + arr[k][l + 1] + arr[k][l + 2];
						max = cnt > max ? cnt : max;
					}
				}
				// 한 줄에 두 칸 다 있는 경우
				for (int l = j + 3; l < n - 2; l++) {
					int cnt = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][l] + arr[i][l + 1] + arr[i][l + 2];
					max = cnt > max ? cnt : max;
				}

			}
		}

		System.out.println(max);

	}
}
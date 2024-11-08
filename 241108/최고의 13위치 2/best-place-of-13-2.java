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
		// 한 줄에 2개 가능하다면? -> 걍 모든 경우의 수 탐색하는데 아닌 걸 어떻게 거를지 생각해야해
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 2; j++) {
				for (int k = i; k < n; k++) {
					for (int l = 0; l < n - 2; l++) {
						if(i==k&&Math.abs(l-j)<3)
							continue;
						int cnt = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[k][l] + arr[k][l + 1] + arr[k][l + 2];
						max = cnt > max ? cnt : max;
					}
				}

			}
		}

		System.out.println(max);

	}
}
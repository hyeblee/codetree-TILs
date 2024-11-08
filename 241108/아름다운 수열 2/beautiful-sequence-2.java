import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arrA = new int[n];
		int[] arrB = new int[m];

		for (int i = 0; i < n; i++) {
			arrA[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			arrB[i] = sc.nextInt();
		}
		Arrays.sort(arrB);
		int cnt = 0;
		for (int i = 0; i <= n - m; i++) {
			boolean isSame = true;
			int[] copy = Arrays.copyOfRange(arrA, i, i + m);
			Arrays.sort(copy);
			for (int j = 0; j < m; j++) {
				if (copy[j] != arrB[j]) {
					isSame = false;
					break;
				}
			}
			if (isSame) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
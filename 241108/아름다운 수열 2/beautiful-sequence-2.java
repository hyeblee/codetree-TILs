import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		int[] arrA = new int[n];
		int[] arrB = new int[m];
		for (int i = 0; i < n; i++) {
			arrA[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			arrB[i] = sc.nextInt();
		}
		Arrays.sort(arrB);
		int answer = 0;
		for (int i = 0; i <= n - m; i++) {
			int[] copy = Arrays.copyOfRange(arrA, i, i + m);
			Arrays.sort(copy);
			boolean same = true;
			for (int j = 0; j < m; j++) {
				if (arrB[j] != copy[j]) {
					same = false;
					break;
				}
			}
			if (same) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
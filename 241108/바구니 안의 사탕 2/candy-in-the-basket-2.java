import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] baskets = new int[101];
		for (int i = 0; i < n; i++) {
			int cnt = sc.nextInt();
			int position = sc.nextInt();
			baskets[position-1] += cnt;
		}
		int maxSum = 0;
//		System.out.println(baskets[4]);
		for (int i = 0; i <= 100 - 2 * k; i++) {
			int sum = 0;
			for (int j = 0; j < 2*k; j++) {
				sum += baskets[i+j];
//				System.out.print(i+j+" ");
			}
//			System.out.println(sum);
			maxSum = Integer.max(maxSum, sum);
		}
		System.out.println(maxSum);
	}
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final int MAX_NUM = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] baskets = new int[MAX_NUM + 1];
		for (int i = 0; i < n; i++) {
			int candy = sc.nextInt();
			int position = sc.nextInt();
			baskets[position] += candy;
		}
		int maxSum = 0;
		for (int i = 1; i <= MAX_NUM; i++) {
			int sum = 0;
			for (int j = i - k; j <= i + k; j++) {
				if (j > 0 && j <= MAX_NUM) {
					sum += baskets[j];
				}
			}
			maxSum = Integer.max(maxSum,sum);
		}
		System.out.println(maxSum);
	}
}
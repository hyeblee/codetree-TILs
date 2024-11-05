import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;

	public static int n;
	public static int[] arr = new int[MAX_N];

	public static void main(String[] args) {
		int cnt = 0;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if(arr[i]<=arr[j]&&arr[j]<=arr[k]) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);

	}
}
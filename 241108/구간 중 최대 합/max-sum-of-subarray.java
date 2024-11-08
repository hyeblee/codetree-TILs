import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		for(int i=0;i<=n-k;i++) {
			int sum = 0;
			for(int j=0;j<k;j++) {
				sum += arr[i+j];
			}
			max = Integer.max(max, sum);
		}

		System.out.println(max);
	}
}
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[10001];
		for(int i=0;i<n;i++) {
			int position = sc.nextInt();
			char alphabet = sc.next().charAt(0);
			arr[position] += alphabet - 'F';
		}
		int maxSum=0;
		for(int i=1;i<=10001-k;i++) {
			int sum = 0;
			for(int j=0;j<k;j++) {
				sum+=arr[j+i];
			}
			maxSum = Math.max(maxSum, sum);
		}
		System.out.println(maxSum);
		
	}
}
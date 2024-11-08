import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int result = sum;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++){
				int exceptTwo = arr[i]+arr[j];
				result = Math.min(result, Math.abs(s-sum+ exceptTwo));
			}
		}
		
		System.out.println(result);
		


	}
}
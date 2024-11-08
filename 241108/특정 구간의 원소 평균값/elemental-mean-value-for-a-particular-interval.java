import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[100];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int cnt=0;
		for(int i=0;i<n;i++) { //시작범위
			for(int j=i;j<n;j++) { //끝 범위
				int[] copy = Arrays.copyOfRange(arr, i,j+1);
				double avg=0;
				for(int k=i;k<=j;k++) {
					avg+=arr[k];
				}
				avg/=copy.length;
				for(int k=i;k<=j;k++) {
					if(arr[k]==avg) {
						cnt++;
						break; // 같은 거 1회만 카운팅하므로 탈출
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
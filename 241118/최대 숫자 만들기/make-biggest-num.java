import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class Main {
	public static final int MAX_N = 50000;
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] arr = new String[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String str1 = o1+o2;
				String str2 = o2+o1;
				int n1 = Integer.valueOf(str1);
				int n2 = Integer.valueOf(str2);
				return Integer.compare(n2, n1);		
			}
			
		});
		String answer ="";
		for(String str:arr) {
			answer+=str;
		}
		System.out.println(answer);
	}

}
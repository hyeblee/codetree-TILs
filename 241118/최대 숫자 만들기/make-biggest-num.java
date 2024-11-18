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
				if(o2.charAt(0)!=o1.charAt(0))
					return Integer.compare(o2.charAt(0), o1.charAt(0));
				if(o1.startsWith(o2)) {
					System.out.println(o1+":"+o2);
					int length = o2.length();
					return Integer.compare(o2.charAt(0),o1.charAt(length));
				}
				if(o2.startsWith(o1)) {
					int length = o1.length();
					return Integer.compare(o2.charAt(length),o1.charAt(0));
				}
                return 0;
			}
			
		});
		String answer ="";
		for(String str:arr) {
			answer+=str;
		}
		System.out.println(answer);
	}

}
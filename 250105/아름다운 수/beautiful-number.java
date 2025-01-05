import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static int n;
	public static int result = 0;
	
	public static void recur(String str) {
		if(str.length()>n)
			return;
		if(str.length()==n) {
			result++;
//			System.out.println(str);
			return;
		}
		for(int i=1;i<=4;i++) {
			String plus = "";
			for(int j=0;j<i;j++) {
				plus+=String.valueOf(i);
			}
			recur(str+plus);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		recur("");
		
		System.out.println(result);
	}
}
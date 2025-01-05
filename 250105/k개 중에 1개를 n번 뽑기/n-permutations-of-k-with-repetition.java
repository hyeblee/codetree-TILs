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
	public static int N, K;
	public static int result = 0;
	
	public static void recur(int n, String result) {
		if(n==N+1) {
			System.out.println(result);
			return;
		}
		for(int i=1;i<=K;i++) {
			recur(n+1, result + i + " ");
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ArrayList<Integer> coins = new ArrayList<>();
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		recur(1, "");
		

	}
}
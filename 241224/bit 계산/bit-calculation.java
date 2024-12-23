import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		M = Integer.parseInt(br.readLine());
		int s = 0;
		for(int i=0;i<M;i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			String cmd = st.nextToken();
//			System.out.println(Integer.toBinaryString(s));
			if(cmd.equals("clear")) {
				s = 0;
			}
			else if (cmd.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				if(((s>>x)&1)!=0) {
					continue;
				}
				s += 1<<x;
			}
			else if (cmd.equals("delete")) {
				int x = Integer.parseInt(st.nextToken());
				if(((s>>x)&1)==0)
					continue;
				s -= (1<<x);
			}
			else if (cmd.equals("print")) {
				int x = Integer.parseInt(st.nextToken());
				if(((s>>x)&1)==0)
					System.out.println("0");
				else
					System.out.println("1");
			}
			else if (cmd.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if(((s>>x)&1)!=0) {
					s -= (1<<x);
				}
				else {
					s += 1<<x;
				}
			}
		}
	}
}
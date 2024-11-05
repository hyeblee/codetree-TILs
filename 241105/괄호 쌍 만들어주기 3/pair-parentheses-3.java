import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '(') {
				continue;
			}
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) == ')') {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Meeting implements Comparable<Meeting>{
	int s;
	int e;
	
	public Meeting(int s, int e) {
		this.s = s;
		this.e = e;
	}
	
	@Override
	public int compareTo(Meeting o) {
		return Integer.compare(this.e, o.e);
	}
	
}

public class Main {
	public static final int MAX_N = 100000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Meeting> meetings = new ArrayList<>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			Meeting metting = new Meeting(s,e);
			meetings.add(metting);
		}
		
		Collections.sort(meetings);
		
		int answer = 0;
		int current = 0;
		int s;
		for(int i=0;i<meetings.size();i++) {
			s = meetings.get(i).s;
			if(s>=current) {
				answer++;
				current = meetings.get(i).e;
			}
		}
		System.out.println(answer);
		
	}

}
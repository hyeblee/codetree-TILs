import java.util.*;

class Meeting {
	String secretCode;
	String meetingPoint;
	int time;

	public Meeting(String secretCode, String meetingPoint, int time) {
		this.secretCode = secretCode;
		this.meetingPoint = meetingPoint;
		this.time = time;
	}

	public void printStatus() {
		System.out.println("secret code: " + secretCode);
		System.out.println("meeting point : " + meetingPoint);
		System.out.println("time : " + time);
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String secretCode = sc.next();
		String meetingPoint = sc.next();
		int time = sc.nextInt();
		Meeting meeting = new Meeting(secretCode, meetingPoint, time);
		meeting.printStatus();
	}
}
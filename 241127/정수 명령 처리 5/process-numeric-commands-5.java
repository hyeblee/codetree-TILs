import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	public static ArrayList<Integer> list = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String command = st.nextToken();
    		
    		if(command.equals("push_back")) {
    			int num = Integer.parseInt(st.nextToken());
    			list.add(num);
    		}
    		if(command.equals("get")) {
    			int k = Integer.parseInt(st.nextToken());
    			bw.write(list.get(k-1)+"\n");
    		}
    		if(command.equals("size")) {
    			bw.write(list.size()+"\n");
    		}
    		if(command.equals("pop_back")) {
    			list.remove(list.size()-1);
    		}
    	}
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
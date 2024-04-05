import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			int cmd = Integer.parseInt(br.readLine());
			
			if (cmd == 0) {
				if (pq.isEmpty()) sb.append(0);
				else sb.append(pq.poll());
				sb.append("\n");
			}
			else pq.offer(cmd);
		}
		System.out.println(sb);	
	}
}
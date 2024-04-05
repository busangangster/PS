import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i=0; i<n; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if (cmd == 0) {
				if (pq.isEmpty()) {
					sb.append(0);
				}
				else {
					sb.append(pq.poll());
				}
				sb.append("\n");
			}
			else {
				pq.offer(cmd);
			}
		}
		System.out.println(sb);
	}
}
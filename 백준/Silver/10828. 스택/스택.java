import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			else if (cmd.equals("pop")) {
				if (stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.pop()).append("\n");
			}
			else if (cmd.equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			else if (cmd.equals("empty")) {
				if (stack.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if (cmd.equals("top")) {
				if (stack.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stack.peek()).append("\n");
			}	
		}
		System.out.println(sb);	
	}
}
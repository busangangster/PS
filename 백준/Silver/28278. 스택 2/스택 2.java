import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int k = Integer.parseInt(st.nextToken());
				stack.add(k);
			} else if (cmd == 2) {
				if (!stack.isEmpty()) sb.append(stack.pop());
				else sb.append(-1);
				sb.append("\n");
			} else if (cmd == 3) {
				sb.append(stack.size());
				sb.append("\n");
			} else if (cmd == 4) {
				if (!stack.isEmpty()) sb.append(0);
				else sb.append(1);
				sb.append("\n");
			} else if (cmd == 5) {
				if (!stack.isEmpty()) sb.append(stack.peek());
				else sb.append(-1);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
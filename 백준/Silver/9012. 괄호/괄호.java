import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int j=0; j< s.length(); j++) {
				if (stack.isEmpty()) {
					stack.push(s.charAt(j));
				}
				else {
					if (s.charAt(j) == ')') {
						if (stack.peek() == '(') {
							stack.pop();
						}
						else {
							stack.push(s.charAt(j));
						}
					}
					else {
						stack.push(s.charAt(j));
					}
				}
			}
			if (stack.isEmpty()) {
				sb.append("YES").append("\n");
			}
			else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}

}
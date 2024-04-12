import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		
		while (true) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			if (s.equals(".")) break;
			
			for (int i=0; i<s.length();i++) {
				char tmp = s.charAt(i);
				if (tmp == '(' || tmp == '[') {
					stack.add(tmp);
				}
				else if (tmp == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}
					else stack.add(tmp);
				}
				else if (tmp == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					}
					else stack.add(tmp);
				}
				else continue;
			}
			
			if (stack.isEmpty()) sb.append("yes");
			else sb.append("no");
			sb.append("\n");

		}
		System.out.println(sb);
	}
	
}
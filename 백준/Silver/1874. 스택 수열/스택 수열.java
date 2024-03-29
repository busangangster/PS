import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		for (int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			
			while (cnt <= num) {
				stack.push(cnt);
				cnt++;
				sb.append('+').append("\n");
			}
			if (stack.peek() == num) {
				stack.pop();
				sb.append('-').append("\n");
			}
			
		}
		if (stack.isEmpty()) {
			System.out.print(sb);
		} else {
			System.out.print("NO");
		}
	}

}
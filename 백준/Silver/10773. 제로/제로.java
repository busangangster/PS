import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Stack<Integer> stack = new Stack<>();
		int k = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i=0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				ans -= stack.pop();
			}
			else {
				stack.push(n);
				ans+=n;
			}
		}
		System.out.println(ans);
	}
}
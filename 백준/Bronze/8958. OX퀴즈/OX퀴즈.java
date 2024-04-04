import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			String s = br.readLine();
			int ans = 0;
			int tmp = 0;
			for (int j=0; j<s.length(); j++) {
				if (s.charAt(j) == 'O') {
					tmp++;
					ans += tmp;
				}
				else {
					tmp = 0;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
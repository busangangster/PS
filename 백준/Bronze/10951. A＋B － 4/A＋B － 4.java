import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			while (true) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (a == 0 && b == 0) break;
				sb.append(a+b).append("\n");
				
			}
			
		} catch (Exception e) {
			System.out.println(sb);
			return;
			
		}
	}
}
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int tmp = gcd(a,b);
		int lcm = a*b/tmp;
		
		sb.append(tmp).append("\n");
		sb.append(lcm);
		
		System.out.println(sb);
		
	}
	
	static int gcd(int a, int b) {
		if (b == 0) return a;
		
		return gcd(b,a%b);
	}
}
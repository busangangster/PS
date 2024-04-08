import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
 public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long ans = 0;
		int r = 31;
		int mod = 1234567891;
		long pow = 1;
		
		for (int i=0; i<n; i++) {
			int tmp = s.charAt(i) - 96;
			ans += (tmp * pow);
			pow = (pow*31) % mod;
		}
		sb.append(ans%mod);
		System.out.println(sb);
 }
}
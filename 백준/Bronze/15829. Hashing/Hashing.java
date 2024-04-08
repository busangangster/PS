import java.util.*;
import java.io.*;

public class Main {
 public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long ans = 0;
		int r = 31;
		int mod = 1234567891;
		
		for (int i=0; i<n; i++) {
			char k = s.charAt(i);
			int tmp = k - 96;
			ans += tmp * Math.pow(r,i);
		}
		System.out.println(ans%mod);
 }
}
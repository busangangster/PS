import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int mod = 10007;
		
		int[] dp = new int[N+1];
		
		if (N == 1) {
			System.out.println(N);
		}
		else {
			dp[1] = 1;
			dp[2] = 2;
			
			for (int i=3; i<=N; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % mod;
			}
			
			System.out.println(dp[N]%mod);
		}

	}
}
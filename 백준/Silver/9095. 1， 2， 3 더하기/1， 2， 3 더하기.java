import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i=4; i<=11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}

		for (int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}

	}

}
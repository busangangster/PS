import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc=0; tc<t; tc++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[K+1][N+1];
			
			for (int i=1; i<=N; i++) {
				dp[0][i] = i;
			}
			
			for (int i=1; i<=K; i++) {
				for (int j=1; j<=N; j++) {
					if (j == 1) dp[i][j] = 1;
					else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
			sb.append(dp[K][N]).append("\n");
		}
		System.out.println(sb);
			
	}
	
}
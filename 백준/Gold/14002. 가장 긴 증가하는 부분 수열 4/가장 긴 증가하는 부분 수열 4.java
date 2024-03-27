import java.io.*;
import java.util.*;

class Main { 

	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] dp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i=0; i<n; i++) {
			dp[i] = 1;
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
		}
		int len = Arrays.stream(dp).max().getAsInt();

		int cnt = len;
		Deque<Integer> d = new ArrayDeque<>();
		for (int i=n-1; i>=0; i--) {
			if (dp[i] == cnt) {
				d.addFirst(arr[i]);
				cnt--;
			}
		}
		for (int x: d){
			sb.append(x).append(" ");
		}
		System.out.println(len);
		System.out.println(sb);
	}
}
import java.util.*;
import java.io.*;

public class Main {
	static int N,K,ans;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ans = 0;
		nums = new int[K];
		
		comb(1,0);
		System.out.println(ans);
	}
	
	static void comb(int start, int cnt) {
		if (cnt == K) {
			ans++;
			return;
		}
		
		for (int i=start; i<=N; i++) {
			nums[cnt] = i;
			comb(i+1,cnt+1);
		}
	}
}
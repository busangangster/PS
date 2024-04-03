import java.io.*;
import java.util.*;

public class Main {
	static int N,M,res,answer;
	static int[] nums,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[3];
		nums = new int[N];
		res = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		System.out.println(answer);
		
	}
	
	static void comb(int start , int cnt) {
		int k = Arrays.stream(ans).sum();
		
		if (cnt == 3) {
			int tmp = Math.abs(M-k);
			if (k <= M) {
				if (tmp < res) {
					res = tmp;
					answer = k;
				}
			}
			return;
		}
		
		for (int i=start; i<N; i++) {
			ans[cnt] = nums[i];
			comb(i+1,cnt+1);
		}
	}
}
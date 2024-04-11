import java.util.*;
import java.io.*;

public class Solution {
	static int N,B,min_v;
	static int[] clerks,used;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			clerks = new int[N];
			used = new int[N];
			min_v = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				clerks[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0,0);
			sb.append("#").append(tc).append(" ").append(min_v).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void comb(int start, int cnt,int sum) {
		if (sum >= B) {
			min_v = Math.min(min_v, sum-B);
			return;
		}
		
		if (cnt == N) {
			if (sum >= B) {
				min_v = Math.min(min_v, sum-B);
			}
			return;
		}
		
		for (int i=start; i<N; i++) {
			
			comb(i+1,cnt+1,sum+clerks[i]);
		}
	}
}
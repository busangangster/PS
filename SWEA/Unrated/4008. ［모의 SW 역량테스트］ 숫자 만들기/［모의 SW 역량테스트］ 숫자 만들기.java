import java.util.*;
import java.io.*;

public class Solution {
	static int N,min_v,max_v;
	static int[] op,nums;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=t; tc++) {
			N = Integer.parseInt(br.readLine());
			
			
			op = new int[4];
			nums = new int[N];
			isSelected = new boolean[N];
			min_v = Integer.MAX_VALUE;
			max_v = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			dfs(nums[0],1,op[0],op[1],op[2],op[3]);
			
			sb.append("#").append(tc).append(" ").append(max_v-min_v).append("\n");
		}
		System.out.println(sb);
		

	}
	
	static void dfs(int total, int idx, int plus, int minus, int multiply, int divide) {
		if (idx == N) {
			
			min_v = Math.min(min_v, total);
			max_v = Math.max(max_v, total);
			
			return;
		}
		
		if (plus != 0) {
			dfs(total+nums[idx],idx+1,plus-1,minus,multiply,divide);
		}
		
		if (minus != 0) {
			dfs(total-nums[idx],idx+1,plus,minus-1,multiply,divide);
		}
		
		if (multiply != 0) {
			dfs(total*nums[idx],idx+1,plus,minus,multiply-1,divide);
		}
		
		if (divide != 0 ) {
			dfs(total/nums[idx],idx+1,plus,minus,multiply,divide-1);
		}
		
	}
}
import java.util.*;
import java.io.*;

public class Solution {
	static int N,min_v,max_v;
	static int[] op;
	static int[] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=t; i++) {
			N = Integer.parseInt(br.readLine());
			
			op = new int[4];
			numbers = new int[N];
			min_v = Integer.MAX_VALUE;
			max_v = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<4; j++) {
				op[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				numbers[j] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1,numbers[0],op[0], op[1],op[2],op[3]);
			sb.append("#").append(i).append(" ").append(max_v - min_v).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth, int total, int plus, int minus, int mutiply, int divide) {
		if (depth == N) {
			min_v = Math.min(min_v, total);
			max_v = Math.max(max_v, total);
			return;
		}
		
		if (plus != 0) {
			dfs(depth+1,total+ numbers[depth],plus-1,minus,mutiply,divide);
			
		}
		if (minus != 0) {
			dfs(depth+1,total - numbers[depth],plus,minus-1,mutiply,divide);

		}
		if (mutiply != 0) {
			dfs(depth+1,total * numbers[depth],plus,minus,mutiply-1,divide);

		}
		if (divide != 0) {
			dfs(depth+1,total / numbers[depth],plus,minus,mutiply,divide-1);
			
		}
	}
}
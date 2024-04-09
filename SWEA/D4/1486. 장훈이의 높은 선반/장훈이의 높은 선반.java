import java.util.*;
import java.io.*;

public class Solution {
	
	static int N,B;
	static int[] clerks; 
	static int[] sum;
	static ArrayList<Integer> answers;

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
			sum = new int[N];
			answers = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				clerks[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0,0);
			Collections.sort(answers);
			int tmp = answers.get(0);
			sb.append("#").append(tc).append(" ").append(tmp-B).append("\n");
		}
		System.out.println(sb);

	}
	
	static void comb(int start, int cnt, int total) {
		if (total >= B) {
			answers.add(total);
			return;
		}
		if (cnt == N) {
			if (total >= B) {
				answers.add(total);
			}
			return;
		}
		
		for (int i=start; i<N; i++) {
			
			sum[cnt] = clerks[i];
			comb(i+1,cnt+1,total+clerks[i]);
		}
		
	}
}
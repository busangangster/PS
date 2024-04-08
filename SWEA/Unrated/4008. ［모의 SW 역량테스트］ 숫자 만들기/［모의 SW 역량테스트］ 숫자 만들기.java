import java.io.*;
import java.util.*;
 
class Solution {
	static int N,min_v,max_v;
	static int[] arr,operators,op_case;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N];
			visited = new boolean[N-1];
			operators = new int[4];
			op_case = new int[N-1];
			min_v = Integer.MAX_VALUE;
			max_v = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i=0; i<4; i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			perm(0);
			sb.append("#").append(tc).append(" ").append(max_v - min_v).append("\n");
		}
		System.out.println(sb);

	}

	static void perm(int cnt) {
		if (cnt == N-1) {
			cal();
			return;
		}

		for (int i=0; i<4; i++) {

			if (operators[i] ==  0) continue;

			op_case[cnt] = i;
			operators[i]--;
			perm(cnt+1);
			operators[i]++;

		}
	}

	static void cal() {
		int res = arr[0];
		int cnt = 1;
		

		for (int i=0; i<N-1;i++) {
			switch (op_case[i]) {
				case 0:
					res += arr[cnt];
					cnt++;
					break;
				case 1:
					res -= arr[cnt];
					cnt++;
					break;
	
				case 2:
					res *= arr[cnt];
					cnt++;
					break;
	
				case 3:
					res /= arr[cnt];
					cnt++;
					break;
	
			}
		}

		min_v = Math.min(min_v,res);
		max_v = Math.max(max_v,res);

	}
}
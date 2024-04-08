import java.io.*;
import java.util.*;
 
class Solution {
	static int D,W,K,ans;
	static int[][] graph,copy;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			graph = new int[D][W];
			copy = new int[D][W];
			isSelected = new boolean[D];
			ans = Integer.MAX_VALUE;

			for (int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = graph[i][j];
				}
			}

			if (check()) {
				sb.append("#").append(tc).append(" ").append(0);
			}
			else {
				subset(0);
				sb.append("#").append(tc).append(" ").append(ans);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void subset(int cnt) {
		if (cnt == D) {
			dfs(isSelected,0,0);
			renew();
			return;
		}

		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}

	static void dfs(boolean[] checked,int cnt, int idx) {
		if (cnt >= ans) return;

		if (idx == D) {
			if (check()) {
				ans = Math.min(cnt,ans);
			}
			return;
		}

		if (checked[idx]) {
			Arrays.fill(graph[idx],0);
			dfs(checked,cnt+1,idx+1);

			Arrays.fill(graph[idx],1);
			dfs(checked,cnt+1,idx+1);
		}

		else {
			dfs(checked,cnt,idx+1);
		}
	}

	static boolean check() {
		for (int i=0; i<W; i++) {
			int cnt = 1;
			int start = graph[0][i];
			boolean flag = false;

			for (int j=1; j<D; j++) {

				if (start == graph[j][i]) {
					cnt++;
				}
				else {
					start = graph[j][i];
					cnt = 1;
				}

				if (cnt == K) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}

	static void renew() {
		for (int i=0; i<D; i++) {
			for (int j=0; j<W; j++) {
				graph[i][j] = copy[i][j];
			}
		}
	}
}
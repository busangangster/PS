import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[] nums, selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		selected = new int[M];
		visited = new boolean[N + 1];

		perm(0);
		System.out.println(sb);
	}

	static void perm(int cnt) {
		if (cnt == M) {
			for (int x : selected) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {

			if (visited[i])
				continue;

			selected[cnt] = nums[i];
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

}
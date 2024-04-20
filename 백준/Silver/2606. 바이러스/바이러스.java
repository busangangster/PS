import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new ArrayList<>();
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr.get(a).add(b);
			arr.get(b).add(a);
		}

		int ans = bfs();
		System.out.println(ans - 1);

	}

	static int bfs() {
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		visited[1] = true;
		q.offer(1);

		while (!q.isEmpty()) {
			int cur = q.poll();
			cnt++;

			for (int next : arr.get(cur)) {
				if (visited[next])
					continue;
				q.offer(next);
				visited[next] = true;
			}
		}
		return cnt;
	}

}
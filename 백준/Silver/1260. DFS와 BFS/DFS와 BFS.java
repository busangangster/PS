import java.io.*;
import java.util.*;

class Main {
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		arr = new ArrayList<ArrayList<Integer>>();

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

		for (ArrayList x : arr) {
			Collections.sort(x);
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}

	static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(" ");

		for (int next : arr.get(start)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited = new boolean[N + 1];
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");

			for (int next : arr.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
}